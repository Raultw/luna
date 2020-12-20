package com.example.cine;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    final static int precio2D = 50;
    final static int precio3D = 100;


    public static List<Pelicula> getPeliculas() {
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

    public static List<String> getListaCantPers(){

        //Creo la lista de personas
        List<String>listaCantPers = new ArrayList<>();
        //Cargo la lista con cantidades de personas
        listaCantPers.add("1");
        listaCantPers.add("2");
        listaCantPers.add("3");
        listaCantPers.add("4");
        listaCantPers.add("5");

        return listaCantPers;
    }

}
