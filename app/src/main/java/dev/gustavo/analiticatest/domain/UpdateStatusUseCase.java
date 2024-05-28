package dev.gustavo.analiticatest.domain;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

public interface UpdateStatusUseCase {
    void invoke(Integer counter, HashMap<String, Object> map, MutableLiveData<String> _status);
}
