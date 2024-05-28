package dev.gustavo.analiticatest.domain;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

import dev.gustavo.analiticatest.data.TelemetryRepository;

public class UpdateStatus implements UpdateStatusUseCase {
    private TelemetryRepository repository;

    public UpdateStatus(TelemetryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void invoke(Integer counter, HashMap<String, Object> map, MutableLiveData<String> _status) {
        if (!parametersExists(map)){
            _status.setValue("Evento indeterminado");
            return;
        }

        if (checkStatus(map)){
            repository.saveOperation(counter);
            _status.setValue("Em operação");
        }else _status.setValue("Evento indeterminado");
    }

    boolean parametersExists(HashMap<String, Object> map) {
        return map.containsKey("speed")
                && map.containsKey("engine_status")
                && map.containsKey("sugar_cane_elevator_status")
                && map.containsKey("industry_status");
    }

    boolean checkStatus(HashMap<String, Object> map) {
        return checkSpeed((Integer) map.get("speed")) &&
                checkEngineStatus((Boolean) map.get("engine_status")) &&
                checkSugarCaneElevatorStatus((Boolean) map.get("sugar_cane_elevator_status")) &&
                checkIndustryStatus((Boolean) map.get("industry_status"));
    }

    boolean checkSpeed(Integer speed) {
        return speed > 0;
    }

    boolean checkEngineStatus(Boolean engineStatus) {
        return engineStatus;
    }

    boolean checkSugarCaneElevatorStatus(Boolean sugarCaneElevatorStatus) {
        return sugarCaneElevatorStatus;
    }

    boolean checkIndustryStatus(Boolean industryStatus) {
        return industryStatus;
    }
}
