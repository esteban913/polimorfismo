package com.example.polimorfismo.modelo;

public class Guitarrista implements ManipuladorInstrumento {

    private Instrumento instrumento;

    public Guitarrista(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String afinar(Instrumento instrumento) {
        return "El guitarrista está afinando la "
                + this.instrumento.getNombre()
                + " de marca "
                + this.instrumento.getMarca()
                + ", tipo "
                + this.instrumento.getTipo() + ".";
    }
    @Override
    public String tocarMelodia(Instrumento instrumento) {
        return "El guitarrista está tocando una melodía con la "
                + this.instrumento.getNombre()
                + " de marca "
                + this.instrumento.getMarca() + ".";
    }

    @Override
    public String improvisar(Instrumento instrumento) {
        return "El guitarrista está improvisando con la "
                + this.instrumento.getNombre()
                + " de tipo "
                + this.instrumento.getTipo() + ".";
    }
    public Instrumento getInstrumento() {
        return this.instrumento;
    }
}