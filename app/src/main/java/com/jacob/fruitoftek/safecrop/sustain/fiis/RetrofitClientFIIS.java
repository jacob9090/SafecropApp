package com.jacob.fruitoftek.safecrop.sustain.fiis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientFIIS {

    private static final String BASE_URL = "https://fruitoftek.com/fedco/iis/"; // Replace with your server URL
    private static RetrofitClientFIIS instance;
    private Retrofit retrofit;

    private RetrofitClientFIIS() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClientFIIS getInstance() {
        if (instance == null) {
            instance = new RetrofitClientFIIS();
        }
        return instance;
    }

    public ApiServiceFIIS getApiService() {
        return retrofit.create(ApiServiceFIIS.class);
    }
}
