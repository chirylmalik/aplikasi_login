package com.example.tb1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class home extends AppCompatActivity {

    String username;
    TextView welcome, btnLogout;
    Button btnBiodata, btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = getIntent().getStringExtra("Username");
        welcome = findViewById(R.id.welcomeMessage);
        btnLogout = findViewById(R.id.btnLogout);
        btnBiodata = findViewById(R.id.btnBiodata);
        btnCal = findViewById(R.id.btnCal);

        String greeting = "";
        int hour = Integer.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date()));
        if (hour >= 0 && hour < 11) {
            greeting = "Selamat Pagi, " + username + "!";
        } else if (hour >= 11 && hour < 15) {
            greeting = "Selamat Siang, " + username + "!";
        } else if (hour >= 15 && hour < 19) {
            greeting = "Selamat Sore, " + username + "!";
        } else {
            greeting = "Selamat Malam, " + username + "!";
        }

        welcome.setText(greeting);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogout.setTextColor(Color.RED);
                Drawable[] drawables = btnLogout.getCompoundDrawables();
                Drawable rightDrawable = drawables[2]; // right drawable index
                if (rightDrawable != null) {
                    rightDrawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN); // Ubah warna ke merah
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
                builder.setTitle("Konfirmasi Logout");
                builder.setMessage("Apakah Anda yakin ingin logout?");

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(home.this, Login.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Anda Telah Logout", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, isi_biodata.class);
                intent.putExtra("Username", username);
                startActivity(intent);
            }
        });

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, kalkulator.class);
                intent.putExtra("Username", username);
                startActivity(intent);
            }
        });

    }
}
