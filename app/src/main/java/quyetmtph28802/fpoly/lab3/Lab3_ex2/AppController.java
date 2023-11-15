package quyetmtph28802.fpoly.lab3.Lab3_ex2;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();
    private RequestQueue mrequestQueue;
    public static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized  AppController getInstance(){
        return mInstance;
    }
    public RequestQueue getmRequestQueue(){
        if (mrequestQueue == null){
            mrequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mrequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }
    public void cancelPendingRequest(Object tag){
        if (mrequestQueue != null){
            mrequestQueue.cancelAll(tag);
        }
    }
}
