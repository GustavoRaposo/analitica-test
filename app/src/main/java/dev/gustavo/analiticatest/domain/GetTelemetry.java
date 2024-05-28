package dev.gustavo.analiticatest.domain;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

import dev.gustavo.analiticatest.data.TelemetryRepository;
import dev.gustavo.analiticatest.data.network.response.GetTelemetryResponse;
import dev.gustavo.analiticatest.data.network.response.TelemetryResponse;

public class GetTelemetry implements GetTelemetryUseCase{

    private TelemetryRepository repository;
    private int counter;

    public GetTelemetry(TelemetryRepository repository) {
        this.repository = repository;
    }


    @Override
    public void invoke(MutableLiveData<String> status) {
        repository.getTelemetry(counter, new GetTelemetryResponse() {
            @Override
            public void onResponse(TelemetryResponse response) {

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
