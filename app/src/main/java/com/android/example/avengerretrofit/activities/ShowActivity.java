package com.android.example.avengerretrofit.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.example.avengerretrofit.R;
import com.android.example.avengerretrofit.adapter.AvengersAdapter;
import com.android.example.avengerretrofit.helper.Api;
import com.android.example.avengerretrofit.model.Hero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHeros();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {

                ArrayList<Hero> heroes = response.body();
                recyclerView.setAdapter(new AvengersAdapter(heroes));
               /* for(Hero hero: heroes)
                {
                    Log.d("name",hero.getName());
                    Log.d("realName",hero.getRealName());
                }
                */

            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                Log.d("Failure",t.getMessage());
            }
        });


    }

    private void doRefresh() {
    }
}
