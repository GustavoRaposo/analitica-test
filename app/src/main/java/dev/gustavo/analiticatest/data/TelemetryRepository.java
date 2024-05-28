package dev.gustavo.analiticatest.data;

import dev.gustavo.analiticatest.data.network.response.TelemetryCallback;

public interface TelemetryRepository {

    void getTelemetry(int counter, TelemetryCallback callback);

    void saveOperation(int counter);
}
