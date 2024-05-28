package dev.gustavo.analiticatest.data;

import dev.gustavo.analiticatest.data.network.api.AnaliticaAPI;
import dev.gustavo.analiticatest.data.network.response.GetTelemetryResponse;
import dev.gustavo.analiticatest.data.network.response.SaveTelemetryResponse;
import dev.gustavo.analiticatest.data.network.response.TelemetryResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelemetryRepositoryImp implements TelemetryRepository{

    private AnaliticaAPI service;

    public TelemetryRepositoryImp(AnaliticaAPI service) {
        this.service = service;
    }

    @Override
    public void getTelemetry(int counter, GetTelemetryResponse telemetryResponse) {
        service.getTelemetry(counter).enqueue(new Callback<TelemetryResponse>() {
            @Override
            public void onResponse(Call<TelemetryResponse> call, Response<TelemetryResponse> response) {

            }

            @Override
            public void onFailure(Call<TelemetryResponse> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void saveTelemetry(int counter, SaveTelemetryResponse response) {
        service.saveTelemetry(counter).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {

            }
        });
    }
}
