package com.example.polimorfismo.modelo;

public class Pianista implements ManipuladorInstrumento {

    private Instrumento instrumento;

    public Pianista(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String afinar(Instrumento instrumento) {
        return "El pianista está afinando el "
                + this.instrumento.getNombre()
                + " de marca "
                + this.instrumento.getMarca()
                + ", tipo "
                + this.instrumento.getTipo() + ".";
    }

    @Override
    public String tocarMelodia(Instrumento instrumento) {
        return "El pianista está tocando una melodía en el "
                + this.instrumento.getNombre()
                + " de marca "
                + this.instrumento.getMarca() + ".";
    }

    @Override
    public String improvisar(Instrumento instrumento) {
        return "El pianista está improvisando en el "
                + this.instrumento.getNombre()
                + " de tipo "
                + this.instrumento.getTipo() + ".";
    }
    public Instrumento getInstrumento() {
        return this.instrumento;
    }
}