package com.example.polimorfismo.modelo;

import java.util.List;

public interface ManipuladorInstrumento
        extends Afinable, Melodista, Improvisador {

    String getNombre();

    List<Instrumento> getInstrumentos();
}