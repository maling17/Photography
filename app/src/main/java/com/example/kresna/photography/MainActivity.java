package com.example.kresna.photography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("pesan", "masuk Oncreate ");

        relativeLoading = findViewById(R.id.RelativeLoading);
        RecyclerView recyclerView = findViewById(R.id.Recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataDummy dataDummy = new DataDummy();
        RecylerAdapter adapter = new RecylerAdapter(dataDummy);
        recyclerView.setAdapter(adapter);

    }

    private void showLoading() {
        relativeLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        relativeLoading.setVisibility(View.GONE);
    }
}
