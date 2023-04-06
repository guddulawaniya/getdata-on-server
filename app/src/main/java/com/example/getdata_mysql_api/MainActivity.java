package com.example.getdata_mysql_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        apiInterface = retrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getposts().enqueue(new Callback<List<Postpojo>>() {
            @Override
            public void onResponse(Call<List<Postpojo>> call, Response<List<Postpojo>> response) {
                if (response.body().size()>0)
                {
                    List<Postpojo> list = response.body();

                    MyAdapter adapter = new MyAdapter(MainActivity.this,list);
                    recyclerView.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "list is empty", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Postpojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}