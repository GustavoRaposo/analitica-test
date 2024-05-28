package dev.gustavo.analiticatest.data.network.response;

public class TelemetryResponse {
    private String sensor;
    private int currentValue;

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
