package dev.gustavo.analiticatest.data.network.api;

import dev.gustavo.analiticatest.data.network.response.TelemetryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AnaliticaAPI {

    @GET("telemetry")
    Call<TelemetryResponse> getTelemetry(@Query("counter") int counter);

    @POST("31/in-operation")
    Call<String> saveTelemetry(@Query("counter") int counter);
}
