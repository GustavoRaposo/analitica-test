package dev.gustavo.analiticatest.domain;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public interface GetTelemetryUseCase {
    void invoke(MutableLiveData<String> status);
}
