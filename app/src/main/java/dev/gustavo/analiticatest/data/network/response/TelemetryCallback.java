package dev.gustavo.analiticatest.data.network.response;

import org.json.JSONObject;

public interface TelemetryCallback {
    void onResponse(JSONObject response);

    void onFail(Throwable throwable);
}
