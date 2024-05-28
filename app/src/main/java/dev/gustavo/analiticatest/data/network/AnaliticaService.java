package dev.gustavo.analiticatest.data.network;

import dev.gustavo.analiticatest.data.network.api.AnaliticaAPI;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnaliticaService {
    private static AnaliticaAPI service = null;

    public static AnaliticaAPI getInstance(){
        if(service == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://test.analitica.ag/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            service = retrofit.create(AnaliticaAPI.class);
        }
        return service;
    }
}
