package com.dicoding.sarjanasantuy.belajardatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dicoding.sarjanasantuy.belajardatabase.database.AppDatabase;
import com.dicoding.sarjanasantuy.belajardatabase.database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etJKel;
    private Button btnInsert;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.initDB(getApplicationContext());

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etJKel = findViewById(R.id.etJKel);
        btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }

    private void insertData(){
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        char JKel = etJKel.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJkelamin(JKel);

        //setelah itu, kirim database
        appDatabase.dao().insertData(item);

        etNama.setText("");
        etAlamat.setText("");
        etJKel.setText("");
    }

}
