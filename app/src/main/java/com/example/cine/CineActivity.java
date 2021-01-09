package com.example.cine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clase7.R;

import java.util.ArrayList;
import java.util.List;


public class CineActivity extends BaseActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    TextView auxiliar;
    Spinner cntPersonas, spinnerPeliculas;
    List<Pelicula> listaPeliculas, listaPelFiltradas;
    List<String> titulosPeliculas;
    Button btnComprar, btnPeliculas, btnCines;
    TextView textTotal;
    EditText edad;
    List<String> listaCantPers;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterPeliculas;
    CineViewModel viewModel;
    int cntSeleccionada = 0;
    double valorPelicula = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine);

        auxiliar = findViewById(R.id.auxiliar);
        cntPersonas = findViewById(R.id.cantPersonas);
        spinnerPeliculas = findViewById(R.id.spinnerPeliculas);
        edad = findViewById(R.id.edad);
        btnCines = findViewById(R.id.btnCines);

        viewModel = ProveedorDeObjetos.createViewModel();
        listaPeliculas = viewModel.getProgramacion();
        listaCantPers = viewModel.getCantidadPersonas();
        listaPelFiltradas = new ArrayList<>();

        //Creo lista de titulos de peliculas
        titulosPeliculas = new ArrayList<>();

        btnPeliculas = findViewById(R.id.btnPeliculas);
        btnComprar = findViewById(R.id.btnComprar);
        textTotal = findViewById(R.id.textTotal);

        //Genero adapter y envio la lista de personas al spinner
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaCantPers);
        cntPersonas.setAdapter(adapter);

        cntPersonas.setOnItemSelectedListener(this);
        spinnerPeliculas.setOnItemSelectedListener(this);
        btnComprar.setOnClickListener(this);
        btnCines.setOnClickListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //Tomo el valor de la pelicula seleccionada
        if (adapterView.getId() == R.id.spinnerPeliculas) {
            valorPelicula = listaPelFiltradas.get(position).getValor();
        }

        //Almaceno la cantidad de personas seleccionada como entero
        if (adapterView.getId() == R.id.cantPersonas) {
            cntSeleccionada = Integer.parseInt(listaCantPers.get(position));
        }

        //Llamo a la funciona de calculo con la cantidad de personas y el valor de la pelicula
        String totalFinal = viewModel.calcularPrecioActual(cntSeleccionada, valorPelicula);
        textTotal.setText(totalFinal);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnComprar) {//Accion
            toast("Compra realizada");
        }

        if (view.getId() == R.id.btnPeliculas) {
            if (edad.getText().toString().length() > 0) {
                spinnerPeliculas.setVisibility(View.VISIBLE);
                String proveedor = viewModel.resolveProveedor(edad.getText().toString());
                cargarLista(proveedor);
            } else {
                toast(Constants.AGE_MESSAGE);
            }
        }

        if (view.getId() == R.id.btnCines) {
            Intent i = new Intent(CineActivity.this, InfoCine.class);
            startActivity(i);
        }
    }


    private void cargarLista(String proveedor) {


        //Si la lista fue cargada previamente limpio el spinner
        if (titulosPeliculas.size() > 0) {
            adapterPeliculas.clear(); //No compatible con android viejo!!!
            spinnerPeliculas.setAdapter(adapterPeliculas);
            //Limpio las peliculas anteriores
            listaPelFiltradas.clear();
        }


        //Cargo lista con titulos solo del proveedor correspondiente
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getProveedor().getNombre().equals(proveedor)) {
                //COPIAR ELEMENTOS DE UN ARRAYLIST A OTRO
                listaPelFiltradas.add(pelicula);
                titulosPeliculas.add(pelicula.getTitulo() + " (3D: " + pelicula.getTresD() + " ) [ " + pelicula.getProveedor().getNombre() + " ] - $" + pelicula.getValor());

            }
        }


        //Genero adapter y envio la lista de peliculas al spinner
        adapterPeliculas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, titulosPeliculas);
        spinnerPeliculas.setAdapter(adapterPeliculas);
    }


}
