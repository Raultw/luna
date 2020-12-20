package com.example.cine;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clase7.R;

import java.util.ArrayList;
import java.util.List;


public class CineActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    TextView auxiliar;
    Spinner cntPersonas, spinnerPeliculas;
    List<Pelicula> listaPeliculas, listaPelFiltradas;
    List<String> titulosPeliculas;
    Button btnComprar, btnPeliculas;
    TextView textTotal;
    EditText edad;
    List<String> listaCantPers;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterPeliculas;
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

        listaPeliculas = DataSource.getPeliculas();
        listaCantPers = DataSource.getListaCantPers();
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
        calcularPrecioActual(cntSeleccionada, valorPelicula);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnComprar) {//Accion

            //Validar si la compra es correcta
            //Mostrar mensaje
            Toast.makeText(getApplicationContext(), "Compra realizada", Toast.LENGTH_SHORT).show();
        }

        if (view.getId() == R.id.btnPeliculas) {

            if (edad.getText().toString().length() > 0) {
                spinnerPeliculas.setVisibility(View.VISIBLE);

                if (Integer.parseInt(edad.getText().toString()) > 17) {
                    cargarLista("Sony");
                } else {
                    cargarLista("Disney");
                }
            }else{
                Toast.makeText(this, "No se ingreso edad", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void calcularPrecioActual(int cntSeleccionada, double valorPelicula) {
        double totalFinal;
        if (cntSeleccionada == 5) {
            totalFinal = (cntSeleccionada * valorPelicula * 0.8);
        }else {
            totalFinal = (cntSeleccionada * valorPelicula);
        }
        textTotal.setText(String.valueOf(totalFinal));
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
        for (int i = 0; i < listaPeliculas.size(); i++) {

            if (listaPeliculas.get(i).getProveedor().getNombre().equals(proveedor)) {

                //COPIAR ELEMENTOS DE UN ARRAYLIST A OTRO
                listaPelFiltradas.add(listaPeliculas.get(i));
                titulosPeliculas.add(listaPeliculas.get(i).getTitulo() + " (3D: " + listaPeliculas.get(i).getTresD() + " ) [ " + listaPeliculas.get(i).getProveedor().getNombre() + " ] - $" + listaPeliculas.get(i).getValor());

            }
        }


        //Genero adapter y envio la lista de peliculas al spinner
        adapterPeliculas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, titulosPeliculas);
        spinnerPeliculas.setAdapter(adapterPeliculas);
    }


}
