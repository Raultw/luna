package com.example.cine;

public class CineInfo {

    private int imgId;
    private String titulo;
    private String descripcion;

    public CineInfo(int imgId, String titulo, String descripcion) {
        this.imgId = imgId;
        this.titulo = titulo;
        this.descripcion = descripcion;

    }

    public int getImgId() {
        return imgId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
