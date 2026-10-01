package com.example.polimorfismo.modelo;

import java.util.List;

public class Pianista implements ManipuladorInstrumento {

    private String nombre;
    private List<Instrumento> instrumentos;

    public Pianista(String nombre, List<Instrumento> instrumentos) {
        this.nombre = nombre;
        this.instrumentos = instrumentos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    @Override
    public String afinar(List<Instrumento> instrumentos) {
        return "El pianista " + nombre +
                " está afinando " +
                instrumentos.size() +
                " instrumento(s).";
    }

    @Override
    public String tocarMelodia(List<Instrumento> instrumentos) {
        return "El pianista " + nombre +
                " está tocando una melodía con " +
                instrumentos.size() +
                " instrumento(s).";
    }

    @Override
    public String improvisar(List<Instrumento> instrumentos) {
        return "El pianista " + nombre +
                " está improvisando con " +
                instrumentos.size() +
                " instrumento(s).";
    }
}