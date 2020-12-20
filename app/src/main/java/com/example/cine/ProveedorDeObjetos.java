package com.example.cine;

public class ProveedorDeObjetos {

    public static CineViewModel createViewModel() {
        DataSource dataSource = new DataSource();

        return new CineViewModel(dataSource);
    }


}
