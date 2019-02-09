package com.example.kresna.photography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("pesan", "masuk Oncreate ");

        RecyclerView recyclerView = findViewById(R.id.Recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataDummy dataDummy=new DataDummy();
        RecylerAdapter adapter=new RecylerAdapter(dataDummy);
        recyclerView.setAdapter(adapter);

    }
}
