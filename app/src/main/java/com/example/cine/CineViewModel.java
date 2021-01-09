package com.example.cine;

import java.util.List;

public class CineViewModel {

    private final DataSource dataSource;

    public CineViewModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pelicula> getProgramacion() {
        return dataSource.getPeliculas();
    }

    public List<String> getCantidadPersonas() {
        return dataSource.getListaCantPers();
    }

    public List<CineInfo> getCines() {
        return dataSource.getCines();
    }

    public String calcularPrecioActual(int cntSeleccionada, double valorPelicula) {
        double totalFinal;
        if (cntSeleccionada == 5) {
            totalFinal = (cntSeleccionada * valorPelicula * 0.8);
        } else {
            totalFinal = (cntSeleccionada * valorPelicula);
        }

        return String.valueOf(totalFinal);
    }


    public String resolveProveedor(String edad) {
        return Integer.parseInt(edad) > 17 ? "Sony" : "Disney";
    }
}
