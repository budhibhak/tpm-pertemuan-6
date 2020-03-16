package com.dicoding.sarjanasantuy.belajardatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.sarjanasantuy.belajardatabase.database.AppDatabase;
import com.dicoding.sarjanasantuy.belajardatabase.database.DataDiri;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity implements MainListener{
    private AppDatabase appDatabase;
    RecyclerView recyclerView;
    List<MahasiswaModel> main_list;
    RecyclerView.Adapter adapter;
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ini DataBase
        appDatabase = AppDatabase.initDB(this);
        
        main_list = new ArrayList<>();
        
        //findViewById
        recyclerView = findViewById(R.id.activitymain_recyclerview);
        
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        main_list.add(new MahasiswaModel("Tama","Solo", "L"));
        main_list.add(new MahasiswaModel("Budhi", "Jogja", "L"));
        adapter = new MahasiswaAdapter (main_list,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
    
    private void read(){
        // TODO 1: ngambil data dari database
        DataDiri[] list = appDatabase.dao().getData();
        
        //TODO 2: Tampilin ke recyclerView
        MahasiswaAdapter adapter = new MahasiswaAdapter(list);
        RecyclerView rc;
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);
    }

    // Update
    @Override
    public void onItemClicked(DataDiri item){
        Toast.makeText(this, "" + item.getNama()+"Akan di edit", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, UpdateActivity.class);
        intent.putExtra("nama", item.getNama());
        intent.putExtra("alamat", item.getAlamat());
        intent.putExtra("kelamin", item.getJkelamin());
        startActivity(intent);
    }

}
