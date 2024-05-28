package dev.gustavo.analiticatest.data.network.response;

import java.util.List;

public interface GetTelemetryResponse {
    void onResponse(TelemetryResponse telemetryResponse);

    void onFailure(Throwable throwable);
}
