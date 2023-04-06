package com.example.getdata_mysql_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitInstance {
    private static Retrofit retrofit;
    private final static String BASEURL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit() {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();

        }

        return retrofit;
    }
}
