package com.android.example.avengerretrofit.helper;

import com.android.example.avengerretrofit.model.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<ArrayList<Hero>> getHeros();
}
