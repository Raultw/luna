package com.example.clase7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cine.AdaptadorCine;
import com.example.cine.CineInfo;
import com.example.cine.CineViewModel;
import com.example.cine.InfoCine;
import com.example.cine.ProveedorDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class SeleccionCine extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView seleccionCine;
    AdaptadorCine adapterCines;
    List<CineInfo> listaCines;
    CineViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_cine);

        seleccionCine = findViewById(R.id.listViewCines);

        viewModel = ProveedorDeObjetos.createViewModel(); //PREGUNTAR PORQUE NO HACE FALTA.
        listaCines = viewModel.getCines();
        adapterCines = new AdaptadorCine(this, (ArrayList<CineInfo>) listaCines);
        seleccionCine.setAdapter(adapterCines);

        seleccionCine.setOnItemClickListener(SeleccionCine.this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.listViewCines) {
            CineInfo cine = listaCines.get(i);
            //Toast.makeText(this, "Selecciono: " + listaCines.get(i).getTitulo(), Toast.LENGTH_SHORT).show();
            Intent intentInfoCine = new Intent(SeleccionCine.this, InfoCine.class);
            intentInfoCine.putExtra("titulo", cine.getTitulo());
            intentInfoCine.putExtra("descripcion", cine.getDescripcion());
            intentInfoCine.putExtra("imagen", cine.getImgId());
            startActivity(intentInfoCine);
        }

    }
}