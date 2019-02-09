package com.example.kresna.photography;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.kresna.photography.api.APIRepository;
import com.example.kresna.photography.api.PhotoItem;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<PhotoItem>> {

    private static final String baseurl = "https://picsum.photos/";
    private RelativeLayout relativeLoading;
    private RecyclerView recyclerView;
    private RecylerAdapter.OnPhotoClickListener photoClickListener = new RecylerAdapter.OnPhotoClickListener() {
        @Override
        public void OnClick(int id) {
            Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("pesan", "masuk Oncreate ");

        relativeLoading = findViewById(R.id.RelativeLoading);
        recyclerView = findViewById(R.id.Recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataFromAPI();

    }

    private void getDataFromAPI() {
        showLoading();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        APIRepository apiRepository = retrofit.create(APIRepository.class);
        Call<List<PhotoItem>> call = apiRepository.getAllPhotos();
        call.enqueue(this);
    }

    private void showLoading() {
        relativeLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        relativeLoading.setVisibility(View.GONE);
    }

    private void showDataRecylcer(List<PhotoItem> data) {
        RecylerAdapter adapter = new RecylerAdapter(data,photoClickListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponse(@NonNull Call<List<PhotoItem>> call, @NonNull Response<List<PhotoItem>> response) {
        hideLoading();
        showDataRecylcer(response.body());
    }

    @Override
    public void onFailure(@NonNull Call<List<PhotoItem>> call, @NonNull Throwable t) {
        hideLoading();
        Toast.makeText(this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }
}
