package dev.gustavo.analiticatest.data;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import dev.gustavo.analiticatest.data.network.api.AnaliticaAPI;
import dev.gustavo.analiticatest.data.network.response.TelemetryCallback;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelemetryRepositoryImp implements TelemetryRepository {

    private AnaliticaAPI service;

    public TelemetryRepositoryImp(AnaliticaAPI service) {
        this.service = service;
    }

    @Override
    public void getTelemetry(int counter, TelemetryCallback callback) {
        service.getTelemetry(counter).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response.body().string());
                    } catch (JSONException | IOException e) {
                        callback.onFail(e);
                    }
                    callback.onResponse(jsonObject);
                } else callback.onFail(new Throwable("Response Fail"));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void saveOperation(int counter) {
        service.saveTelemetry(counter).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.d("Telemetry Repository", "operation was saved: " + counter);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

            }
        });
    }
}
