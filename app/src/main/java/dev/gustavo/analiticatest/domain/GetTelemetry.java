package dev.gustavo.analiticatest.domain;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

import dev.gustavo.analiticatest.data.TelemetryRepository;
import dev.gustavo.analiticatest.data.network.response.TelemetryCallback;

public class GetTelemetry implements GetTelemetryUseCase{

    private TelemetryRepository repository;
    private int counter;

    public GetTelemetry(TelemetryRepository repository, int counter) {
        this.repository = repository;
        this.counter = counter;
    }


    @Override
    public void invoke(HashMap<String, Object> map, MutableLiveData<Integer> _counter){
        repository.getTelemetry(counter, new TelemetryCallback() {
            @Override
            public void onResponse(JSONObject response) {
                String sensor;
                Object value;
                try {
                    sensor = response.getString("sensor");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                try {
                    value = response.get("currentValue");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                map.put(sensor, value);
                _counter.setValue(counter++);
            }

            @Override
            public void onFail(Throwable throwable) {
                _counter.setValue(counter);
            }
        });

    }
}
