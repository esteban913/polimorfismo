package com.example.polimorfismo.modelo;

public class ResultadoInstrumento {

    private String musico;
    private Instrumento instrumento;
    private String mensajeAfinar;
    private String mensajeMelodia;
    private String mensajeImprovisar;

    public ResultadoInstrumento(
            String musico,
            Instrumento instrumento,
            String mensajeAfinar,
            String mensajeMelodia,
            String mensajeImprovisar) {

        this.musico = musico;
        this.instrumento = instrumento;
        this.mensajeAfinar = mensajeAfinar;
        this.mensajeMelodia = mensajeMelodia;
        this.mensajeImprovisar = mensajeImprovisar;
    }

    public String getMusico() {
        return musico;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public String getMensajeAfinar() {
        return mensajeAfinar;
    }

    public String getMensajeMelodia() {
        return mensajeMelodia;
    }

    public String getMensajeImprovisar() {
        return mensajeImprovisar;
    }
}