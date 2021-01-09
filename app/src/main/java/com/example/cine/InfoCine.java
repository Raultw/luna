package com.example.cine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clase7.R;

public class InfoCine extends AppCompatActivity {

    ImageView ivMiniatura;
    TextView tvTitulo;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cine);

        ivMiniatura = findViewById(R.id.ivMiniatura);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);


        Bundle bundle = getIntent().getExtras();
        tvTitulo.setText(bundle.getString("titulo"));
        tvDescripcion.setText(bundle.getString("descripcion"));
        ivMiniatura.setImageResource(bundle.getInt("imagen"));


    }

}