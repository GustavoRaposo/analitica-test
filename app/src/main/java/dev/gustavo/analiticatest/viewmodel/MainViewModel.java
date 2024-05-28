package dev.gustavo.analiticatest.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.gustavo.analiticatest.data.TelemetryRepository;
import dev.gustavo.analiticatest.data.TelemetryRepositoryImp;
import dev.gustavo.analiticatest.data.network.AnaliticaService;
import dev.gustavo.analiticatest.domain.GetTelemetry;
import dev.gustavo.analiticatest.domain.GetTelemetryUseCase;
import dev.gustavo.analiticatest.domain.UpdateStatus;
import dev.gustavo.analiticatest.domain.UpdateStatusUseCase;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> _counter = new MutableLiveData<>();
    public LiveData<Integer> counter = _counter;
    private MutableLiveData<String> _status = new MutableLiveData<>();
    public LiveData<String> status = _status;

    private TelemetryRepository repository;

    private GetTelemetryUseCase getTelemetryUseCase;
    private UpdateStatusUseCase updateStatusUseCase;
    private int requestCounter;
    private HashMap<String, Object> map;

    public MainViewModel(){
        requestCounter = 0;
        map = new HashMap<>();
        repository = new TelemetryRepositoryImp(AnaliticaService.getInstance());
        getTelemetryUseCase = new GetTelemetry(repository, requestCounter);
        updateStatusUseCase = new UpdateStatus(repository);

    }

    public void getTelemetry(){
        getTelemetryUseCase.invoke(map, _counter);
    }

    public void checkStatus(Integer i){
        updateStatusUseCase.invoke(i, map, _status);
    }
}
