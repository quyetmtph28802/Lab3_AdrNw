package quyetmtph28802.fpoly.lab3.Lab3_ex3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("jsonandroid")
    Call<JSONResponse> getJSON();
}
