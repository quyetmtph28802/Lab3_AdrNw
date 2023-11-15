package quyetmtph28802.fpoly.lab3.Lab3_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import quyetmtph28802.fpoly.lab3.R;

public class MainActivity_EX1 extends AppCompatActivity {
    private ListView lvContact;
    GetContact getContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ex1);
        lvContact = findViewById(R.id.listContact);

        getContact = new GetContact(this, lvContact);
        getContact.execute();
    }
}