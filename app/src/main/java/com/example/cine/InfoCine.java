package com.example.cine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clase7.R;

import java.util.ArrayList;
import java.util.List;

public class InfoCine extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ImageView ivMiniatura;
    TextView tvTitulo;
    TextView tvDescripcion;
    ListView lvPeliculas;
    CineViewModel viewModel;
    List<Pelicula> listaPeliculas;
    ArrayList<String> nombresPeliculas;
    ArrayAdapter<String> adapterPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cine);

        ivMiniatura = findViewById(R.id.ivMiniatura);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        lvPeliculas = findViewById(R.id.lvPeliculas);

        Bundle bundle = getIntent().getExtras();
        tvTitulo.setText(bundle.getString("titulo"));
        tvDescripcion.setText(bundle.getString("descripcion"));
        ivMiniatura.setImageResource(bundle.getInt("imagen"));

        viewModel = ProveedorDeObjetos.createViewModel();
        nombresPeliculas = new ArrayList<>();
        listaPeliculas = viewModel.getProgramacion(bundle.getString("titulo"));
        cargarLista();
        adapterPeliculas = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresPeliculas);
        lvPeliculas.setAdapter(adapterPeliculas);

        lvPeliculas.setOnItemClickListener(this);

    }

    private void cargarLista() {


        //Si la lista fue cargada previamente limpio el spinner
        if (nombresPeliculas.size() > 0) {
            adapterPeliculas.clear(); //No compatible con android viejo!!!
            lvPeliculas.setAdapter(adapterPeliculas);
            //Limpio las peliculas anteriores
            listaPeliculas.clear();
        }


        //Cargo lista con titulos solo del proveedor correspondiente
        for (Pelicula pelicula : listaPeliculas) {
            //if (pelicula.getProveedor().getNombre().equals(proveedor)) {
            //COPIAR ELEMENTOS DE UN ARRAYLIST A OTRO
            //listaPeliculas.add(pelicula)
            nombresPeliculas.add(pelicula.getTitulo() + " (3D: " + pelicula.getTresD() + " ) [ " + pelicula.getProveedor().getNombre() + " ] - $" + pelicula.getValor());

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (adapterView.getId() == R.id.lvPeliculas) {
            Pelicula peli = listaPeliculas.get(position);
            Intent intentPelicula = new Intent(InfoCine.this, Sinopsis.class);
            intentPelicula.putExtra("titulo", peli.getTitulo());
            intentPelicula.putExtra("sinopsis", peli.getSinopsis());
            intentPelicula.putExtra("3d", peli.getTresD());
            intentPelicula.putExtra("valor", peli.getValor());
            intentPelicula.putExtra("tapa", peli.getTapa());
            startActivity(intentPelicula);
        }
    }
}