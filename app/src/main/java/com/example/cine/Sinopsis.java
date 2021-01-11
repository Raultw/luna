package com.example.cine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clase7.R;

public class Sinopsis extends AppCompatActivity {

    private TextView tvTituloSinopsis;
    private TextView tvSinopsis;
    private ImageView ivTapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);

        tvTituloSinopsis = findViewById(R.id.tvTituloSinopsis);
        tvSinopsis = findViewById(R.id.tvSinopsis);
        ivTapa = findViewById(R.id.ivTapa);

        Bundle datosPel = getIntent().getExtras();
        tvTituloSinopsis.setText(datosPel.getString("titulo"));
        tvSinopsis.setText(datosPel.getString("sinopsis"));
        ivTapa.setImageResource(datosPel.getInt("tapa"));

    }
}