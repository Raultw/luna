package com.example.cine;

import com.example.clase7.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource implements ContratoDataSource {

    final static int precio2D = 50;
    final static int precio3D = 100;


    public List<Pelicula> getPeliculas() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        //Creo los proveedores
        Proveedor sony = new Proveedor("Sony");
        Proveedor disney = new Proveedor("Disney");

        //Creo las peliculas
        Pelicula pelicula1 = new Pelicula("Rocky 1", precio2D, false, sony);
        Pelicula pelicula2 = new Pelicula("Rambo 1", precio2D, false, sony);
        Pelicula pelicula3 = new Pelicula("El señor de los ladrillos", precio3D, true, disney);

        //Cargo el arreglo con peliculas
        listaPeliculas.add(pelicula1);
        listaPeliculas.add(pelicula2);
        listaPeliculas.add(pelicula3);

        return listaPeliculas;
    }

    public List<String> getListaCantPers() {

        //Creo la lista de personas
        List<String> listaCantPers = new ArrayList<>();
        //Cargo la lista con cantidades de personas
        listaCantPers.add("1");
        listaCantPers.add("2");
        listaCantPers.add("3");
        listaCantPers.add("4");
        listaCantPers.add("5");

        return listaCantPers;
    }

    public List<CineInfo> getCines() {
        //Creo la lista de cines
        List<CineInfo> listaCines = new ArrayList<>();

        //Creo los cines
        CineInfo cine1 = new CineInfo(R.drawable.cine_hoyts, "Cine HOYTS", "Cine 3D de la capital, 3 salas, bla bla bla");
        CineInfo cine2 = new CineInfo(R.drawable.cine_imax, "Cine IMAX", "Cine ubicado en el centro de la ciudad");
        CineInfo cine3 = new CineInfo(R.drawable.cine_inca, "Cine INCA", "Historico cine Argentino, que proyecta filmografia nacional");

        //Cargo el arreglo con los cines
        listaCines.add(cine1);
        listaCines.add(cine2);
        listaCines.add(cine3);

        return listaCines;

    }

}
