package com.example.cine;

import java.util.UUID;

public class Proveedor {

    private UUID uuid;
    private String nombre;

    public Proveedor (String nombre){
        this.uuid=UUID.randomUUID();
        this.nombre=nombre;

    }

    public void setNombre(String nombre){
        uuid=uuid;
    }

    public String getNombre(){
        return nombre;
    }

    public UUID getUuid(){
        return uuid;
    }

}
