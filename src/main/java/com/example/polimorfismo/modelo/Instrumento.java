package com.example.polimorfismo.modelo;

public class Instrumento {

    private String nombre;
    private String marca;
    private String tipo;
    private Integer valor;

    public Instrumento(String nombre, String marca, String tipo, Integer valor) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.valor = valor;
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

    public Integer getValor() {
        return valor;
    }
}