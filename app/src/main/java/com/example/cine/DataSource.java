package com.example.cine;

import com.example.clase7.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource implements ContratoDataSource {

    final static int precio2D = 50;
    final static int precio3D = 100;


    public List<Pelicula> getPeliculas(String nombreCine) {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        //Formateo el nombre del cine
        nombreCine = nombreCine.toUpperCase();
        nombreCine = nombreCine.trim();
        nombreCine = nombreCine.replace(" ", "");

        //Creo los proveedores
        Proveedor sony = new Proveedor("Sony");
        Proveedor disney = new Proveedor("Disney");

        switch (nombreCine) {

            case "CINEHOYTS":
                //Creo las peliculas
                Pelicula hoytsPel1 = new Pelicula("Mi pobre angelito", "Cuenta la historia de un pendejito re mil culiao...", precio2D, false, sony);
                Pelicula hoytsPel2 = new Pelicula("PeterPan", "Sin informacion", precio2D, false, disney);
                Pelicula hoytsPel3 = new Pelicula("Yo Robot", "Chicago, año 2035. Vivimos en completa armonía con robots inteligentes. Cocinan para nosotros, conducen nuestros aviones, cuidan de nuestros hijos y confiamos plenamente en ellos debido a que se rigen por las Tres Leyes de la Robótica que nos protegen de cualquier daño. Inesperadamente un robot se ve implicado en el crimen de un brillante científico y el detective Del Spooner (Will Smith) queda a cargo de la investigación.", precio3D, true, sony);
                //Cargo el arreglo con peliculas
                listaPeliculas.add(hoytsPel1);
                listaPeliculas.add(hoytsPel2);
                listaPeliculas.add(hoytsPel3);
                break;
            case "CINEIMAX":
                //Creo las peliculas
                Pelicula imaxPel1 = new Pelicula("El Cubo", "Sin informacion", precio2D, false, sony);
                Pelicula imaxPel2 = new Pelicula("Rocky", "Rocky Balboa es un desconocido boxeador a quien se le ofrece la posibilidad de pelear por el título mundial de los pesos pesados. Con una gran fuerza de voluntad, Rocky se prepara concienzudamente para el combate y también para los cambios que acabarán produciéndose en su vida.", precio2D, false, sony, R.drawable.rocky1);
                Pelicula imaxPel3 = new Pelicula("La Sirenita", "Una flaquita re pescada que vive en el mar.", precio3D, true, disney);
                //Cargo el arreglo con peliculas
                listaPeliculas.add(imaxPel1);
                listaPeliculas.add(imaxPel2);
                listaPeliculas.add(imaxPel3);
                break;
            case "CINEINCA":
                //Creo las peliculas
                Pelicula incaPel1 = new Pelicula("Jurassic Park", "La pelicula que dio origen al meme: 'Lavate las manos rex...'", precio2D, false, sony);
                Pelicula incaPel12 = new Pelicula("Eternal Sunshine of the spotless mind", precio2D, false, sony);
                Pelicula incaPel13 = new Pelicula("Tarzan", "Cuando Kala, una gorila hembra, encuentra un niño huérfano en la jungla, decide adoptarlo como su propio hijo a pesar de la oposición de Kerchak, el jefe de la manada. Junto a Terk, un gracioso mono y Tantor, un elefante algo neurótico, Tarzán crecerá en la jungla desarrollando los instintos de los animales y aprendiendo a deslizarse entre los árboles a velocidad de vértigo. Pero cuando una expedición se adentra en la jungla y Tarzán conoce a Jane, descubrirá quién es realmente y cuál es el mundo al que pertenece...", precio3D, true, disney);
                Pelicula incaPel14 = new Pelicula("Rocky III", precio2D, false, sony, R.drawable.rocky3);
                //Cargo el arreglo con peliculas
                listaPeliculas.add(incaPel1);
                listaPeliculas.add(incaPel12);
                listaPeliculas.add(incaPel13);
                listaPeliculas.add(incaPel14);
                break;
        }


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
