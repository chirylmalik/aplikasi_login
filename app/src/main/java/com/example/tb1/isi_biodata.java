package com.example.tb1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class isi_biodata extends AppCompatActivity implements View.OnClickListener{
    Button save, reset;
    ImageView back;
    EditText nama, alamat, id;

    TextView namaValue, alamatValue, customerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_biodata);
        //menampilkan semua tampilan, create tinggal klik di icon sebelah kiri syntax
        findAllViewsId();
        //Create method onClick - tinggal klisk di icon sebelah kiri syntax
        save.setOnClickListener(this);
        reset.setOnClickListener(this);


    }
    private void findAllViewsId(){
        save = findViewById(R.id.Save);
        nama = findViewById(R.id.nama);
        back = findViewById(R.id.backButton);
        id = findViewById(R.id.customer);
        alamat = findViewById(R.id.alamat);
        reset = findViewById(R.id.Reset);
        namaValue=findViewById(R.id.namaValue);
        customerValue=findViewById(R.id.customerValue);
        alamatValue=findViewById(R.id.alamatValue);// Menambahkan inisialisasi tombol reset
    }
    private void displayData() {
        // Menampilkan data yang disimpan dalam TextView
        customerValue.setText(id.getText().toString());
        namaValue.setText(nama.getText().toString());
        alamatValue.setText(alamat.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Save) {
            saveData();
        } else if (v.getId() == R.id.Reset) {
            resetData();
        }
    }

    private void saveData() {
        Bundle b = new Bundle();

        b.putString("customerText", customerValue.getText().toString());
        b.putString("namaText", namaValue.getText().toString());
        b.putString("alamatText", alamatValue.getText().toString());

        // Tambahkan kode untuk menyimpan data ke penyimpanan lokal atau database
        displayData();
    }

    private void resetData() {
        nama.setText("");
        id.setText("");
        alamat.setText("");
        namaValue.setText("");
        customerValue.setText("");
        alamatValue.setText("");
    }
    private void backButtonId() {
        back = (ImageView) findViewById(R.id.backButton);
    }
    public void onBackButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), home.class);
        intent.putExtra("Username", getIntent().getStringExtra("Username"));
        startActivity(intent);
    }
}