package quyetmtph28802.fpoly.lab3.Lab3_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import quyetmtph28802.fpoly.lab3.R;

public class MainActivity_EX2 extends AppCompatActivity {
    private String urlJsonObj = "http://10.24.34.90/Tainguyen/contacts/person_object.json";
    private String urlJsonArr = "http://10.24.34.90/Tainguyen/contacts/person_aray.json";
    private Button btnObject, btnArray;
    private TextView txtResponse;
    private String jsonResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ex2);

        btnObject = findViewById(R.id.lab32btnObj);
        btnArray = findViewById(R.id.lab32btnArray);
        txtResponse = findViewById(R.id.lab32tvKetqua);
        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArray();
            }
        });
        btnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObject();
            }
        });

    }
    public void makeJsonArray(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                urlJsonArr,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i<response.length(); i++){
                            try {
                                JSONObject object = (JSONObject) response.get(i);
                                String name = object.getString("name");
                                String email = object.getString("email");
                                JSONObject phone = object.getJSONObject("phone");
                                String home = object.getString("home");
                                String mobile = object.getString("mobile");

                                jsonResponse="";
                                jsonResponse += "Name: "+name+"\n\n";
                                jsonResponse += "Email: "+email+"\n\n";
                                jsonResponse += "Home: "+home+"\n\n";
                                jsonResponse += "Mobile: "+mobile+"\n\n";

                                txtResponse.setText(jsonResponse);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
    public void makeJsonObject(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = response.getString("name");
                            String email = response.getString("email");
                            JSONObject phone = response.getJSONObject("phone");
                            String home = response.getString("home");
                            String mobile = response.getString("mobile");

                            jsonResponse="";
                            jsonResponse += "Name: "+name+"\n\n";
                            jsonResponse += "Email: "+email+"\n\n";
                            jsonResponse += "Home: "+home+"\n\n";
                            jsonResponse += "Mobile: "+mobile+"\n\n";

                            txtResponse.setText(jsonResponse);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("LOI", error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}