package com.example.cine;

import com.example.clase7.R;

public class Pelicula {

    private String titulo;
    private String sinopsis;
    private double valor;
    private Boolean tresD;
    private Proveedor proveedor;
    private int tapa;

    public Pelicula(String titulo, double valor, Boolean tresD, Proveedor proveedor) {
        this.titulo = titulo;
        this.sinopsis = "Sin informacion";
        this.valor = valor;
        this.tresD = tresD;
        this.proveedor = proveedor;
        this.tapa = R.drawable.sin_imagen;
    }

    public Pelicula(String titulo, String sinopsis, double valor, Boolean tresD, Proveedor proveedor) {
        this(titulo, valor, tresD, proveedor);
        this.sinopsis = sinopsis;
    }

    public Pelicula(String titulo, double valor, Boolean tresD, Proveedor proveedor, int tapa) {
        this(titulo, valor, tresD, proveedor);
        this.tapa = tapa;
    }

    public Pelicula(String titulo, String sinopsis, double valor, Boolean tresD, Proveedor proveedor, int tapa) {
        this(titulo, valor, tresD, proveedor);
        this.tapa = tapa;
        this.sinopsis = sinopsis;
    }

    public static Pelicula crearPelicula(String titulo, double valor, Boolean tresD, Proveedor proveedor) throws Exception {
        if (valor > 50) {
            return new Pelicula(titulo, "Sin informacion", valor, tresD, proveedor);
        }
        throw new Exception();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setTresD(Boolean tresD) {
        this.tresD = tresD;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean getTresD() {
        return tresD;
    }

    public int getTapa() {
        return tapa;
    }

    public void setTapa(int tapa) {
        this.tapa = tapa;
    }

}
