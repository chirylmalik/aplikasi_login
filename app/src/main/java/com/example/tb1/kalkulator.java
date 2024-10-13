package com.example.tb1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class kalkulator extends AppCompatActivity {

    EditText angka1, angka2;
    Button btnPlus, btnMinus, btnKali, btnBagi, btnReset;
    TextView hasilText;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        angka1 = findViewById(R.id.Angka1);
        angka2 = findViewById(R.id.Angka2);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnReset = findViewById(R.id.btnReset);
        back = findViewById(R.id.backButton);
        hasilText = findViewById(R.id.HasilText);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('x');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung(':');
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasilText.setText("");
            }
        });

    }

    private void hitung(char operator) {
        double angkaSatu = Double.parseDouble(angka1.getText().toString());
        double angkaDua = Double.parseDouble(angka2.getText().toString());
        double hasil = 0;

        switch (operator) {
            case '+':
                hasil = angkaSatu + angkaDua;
                break;
            case '-':
                hasil = angkaSatu - angkaDua;
                break;
            case 'x':
                hasil = angkaSatu * angkaDua;
                break;
            case ':':
                if (angkaDua != 0) {
                    hasil = angkaSatu / angkaDua;
                } else {
                    hasilText.setText("Tidak bisa membagi dengan nol");
                    return;
                }
                break;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedHasil = df.format(hasil);
        hasilText.setText(formattedHasil);
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
