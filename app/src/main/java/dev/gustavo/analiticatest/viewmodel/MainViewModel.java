package dev.gustavo.analiticatest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dev.gustavo.analiticatest.data.TelemetryRepository;
import dev.gustavo.analiticatest.data.TelemetryRepositoryImp;
import dev.gustavo.analiticatest.data.network.AnaliticaService;
import dev.gustavo.analiticatest.domain.GetTelemetry;
import dev.gustavo.analiticatest.domain.GetTelemetryUseCase;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> _counter = new MutableLiveData<>();
    public LiveData<String> counter = _counter;
    private MutableLiveData<String> _status = new MutableLiveData<>();
    public LiveData<String> status = _status;

    private TelemetryRepository repository;

    private GetTelemetryUseCase getTelemetryUseCase;

    public MainViewModel(){
        repository = new TelemetryRepositoryImp(AnaliticaService.getInstance());
        getTelemetryUseCase = new GetTelemetry(repository);
    }

    public void getTelemetry(){
        getTelemetryUseCase.invoke(_status);
    }
}
