package com.example.clase7;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cine.AdaptadorCine;
import com.example.cine.CineInfo;

import java.util.ArrayList;

public class SeleccionCine extends AppCompatActivity {

    ListView seleccionCine;
    AdaptadorCine adapterCines;
    ArrayList<CineInfo> listadoCines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_cine);

        seleccionCine = findViewById(R.id.listViewCines);
        listadoCines = new ArrayList<>();
        CineInfo cine1 = new CineInfo(R.drawable.cine_hoyts, "Cine HOYTS", "Cine 3D de la capital, 3 salas, bla bla bla");
        CineInfo cine2 = new CineInfo(R.drawable.cine_imax, "Cine IMAX", "Cine ubicado en el centro de la ciudad");
        CineInfo cine3 = new CineInfo(R.drawable.cine_inca, "Cine INCA", "Historico cine Argentino, que proyecta filmografia nacional");
        listadoCines.add(cine1);
        listadoCines.add(cine2);
        listadoCines.add(cine3);

        adapterCines = new AdaptadorCine(this, listadoCines);
        seleccionCine.setAdapter(adapterCines);
    }
}