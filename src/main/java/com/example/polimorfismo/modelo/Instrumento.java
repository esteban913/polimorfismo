package com.example.polimorfismo.modelo;

public class Instrumento {

    private String nombre;
    private String marca;
    private String tipo;

    public Instrumento(String nombre, String marca, String tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }
}