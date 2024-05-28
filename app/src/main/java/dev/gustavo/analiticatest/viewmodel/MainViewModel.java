package dev.gustavo.analiticatest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> _counter = new MutableLiveData<>();
    public LiveData<String> counter = _counter;
    private MutableLiveData<String> _status = new MutableLiveData<>();
    public LiveData<String> status = _status;

    public MainViewModel(){

    }

    public void getTelemetry(){

    }
}
