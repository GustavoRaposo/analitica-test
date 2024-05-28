package dev.gustavo.analiticatest.domain;

import androidx.lifecycle.MutableLiveData;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public interface GetTelemetryUseCase {
    void invoke(HashMap<String, Object> map, MutableLiveData<Integer> _counter);
}
