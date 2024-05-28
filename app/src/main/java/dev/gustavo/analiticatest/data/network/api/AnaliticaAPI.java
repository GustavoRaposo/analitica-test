package dev.gustavo.analiticatest.data.network.api;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AnaliticaAPI {

    @GET("telemetry")
    Call<ResponseBody> getTelemetry(@Query("counter") int counter);

    @POST("31/in-operation")
    Call<ResponseBody> saveTelemetry(@Query("counter") int counter);
}
