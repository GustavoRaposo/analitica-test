package dev.gustavo.analiticatest.data.network.response;

public interface SaveTelemetryResponse {
    void onResponse(String response);

    void onFailure(Throwable throwable);
}
