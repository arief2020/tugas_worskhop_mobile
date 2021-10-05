package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        addData();

        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData() {
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Muhammad Syaifullah Al Arief", "E32202398", "080786587"));
        mahasiswaArrayList.add(new Mahasiswa("Firdaus", "E3220222", "08056767567"));
        mahasiswaArrayList.add(new Mahasiswa("Arya", "E3220333", "08324255654"));
        mahasiswaArrayList.add(new Mahasiswa("Diki", "E3220444", "0856475674"));
        mahasiswaArrayList.add(new Mahasiswa("Dea", "E3220555", "0801354568"));
    }
}