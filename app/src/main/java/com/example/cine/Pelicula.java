package com.example.cine;

public class Pelicula {

    private String titulo;
    private double valor;
    private Boolean tresD;
    private Proveedor proveedor;

    public Pelicula(String titulo, double valor, Boolean tresD, Proveedor proveedor) {

        this.titulo = titulo;
        this.valor = valor;
        this.tresD = tresD;
        this.proveedor = proveedor;

    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public void setProveedor(Proveedor proveedor){
        this.proveedor=proveedor;
    }

    public void setTresD(Boolean tresD) {
        this.tresD = tresD;
    }

    public String getTitulo(){
        return titulo;
    }

    public double getValor(){
        return valor;
    }

    public Proveedor getProveedor(){
        return proveedor;
    }

    public Boolean getTresD() {
        return tresD;
    }

    public static Pelicula crearPelicula(String titulo, double valor, Boolean tresD, Proveedor proveedor) throws Exception {
        if (valor>50){
            return new Pelicula(titulo,valor,tresD,proveedor);
        }
        throw new Exception();

    }

}
