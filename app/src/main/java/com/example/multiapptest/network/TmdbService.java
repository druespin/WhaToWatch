package com.example.multiapptest.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbService {

    public final String API_KEY = "1ef053623376c52e57fa08a511ca3e2d";
    public final String BASE_URL = "https://api.themoviedb.org/3/";
    private static TmdbService instance = null;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public static TmdbService getTmdbInstance() {
        if (instance == null) {
            instance = new TmdbService();
        }
        return instance;
    }

    private TmdbService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public TmdbApi getRequest() {
        return retrofit.create(TmdbApi.class);
    }
}
