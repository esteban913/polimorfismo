package com.example.polimorfismo.modelo;

public interface ManipuladorInstrumento
        extends Afinable, Melodista, Improvisador {

    String getNombre();
}