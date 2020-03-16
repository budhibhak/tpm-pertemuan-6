package com.dicoding.sarjanasantuy.belajardatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import com.dicoding.sarjanasantuy.belajardatabase.database.AppDatabase;
import com.dicoding.sarjanasantuy.belajardatabase.database.DataDiri;

public class UpdateActivity extends AppCompatActivity {
    private String nama, alamat, kelamin;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        alamat = intent.getStringExtra("alamat");
        kelamin = "" + intent.getCharExtra("kelamin", ' ');
        id = intent.getIntExtra("id", 0);

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etJKel = findViewById(R.id.etJKel);
        btnUpdate = findViewById(R.id.btnUpdate);

        //TODO 1: setText hasil intent tadi
        etNama.setText(nama);
        etAlamat.setText(alamat);
        etGender.setText(kelamin);

        //TODO 2: setOnClickListener btnUpdate
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                update();
            }

        });

    }

    void update(){
        //TODO 3: Simpan Hasil inputan ke dalam String tadi
        nama = etNama.getText().toString();
        alamat = etAlamat.getText().toString();
        char kelamin = etJkelamin.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJkelamin(kelamin);
        item.setId(id);

        //TODO 4: Panggil Fungsi update DAO()
        appDatabase.dao().insertData();

        //TODO 5: finish()
        finish();
    }
}
