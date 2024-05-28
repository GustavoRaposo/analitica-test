package dev.gustavo.analiticatest.data;

import dev.gustavo.analiticatest.data.network.response.GetTelemetryResponse;
import dev.gustavo.analiticatest.data.network.response.SaveTelemetryResponse;

public interface TelemetryRepository {

    void getTelemetry(int counter, GetTelemetryResponse response);

    void saveTelemetry(int counter, SaveTelemetryResponse response);
}
