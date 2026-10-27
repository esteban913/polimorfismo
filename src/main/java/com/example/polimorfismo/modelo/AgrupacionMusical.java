package com.example.polimorfismo.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

/** Clase contenedora que reúne instrumentos en una agrupación musical. */
public class AgrupacionMusical {
    private String nombre;
    private String director;
    private EnumInstrumento enumInstrumento;
    private Categoria categoria;
    private Deque<Instrumento> instrumentos;

    public AgrupacionMusical() { instrumentos = new ArrayDeque<>(); }
    public AgrupacionMusical(String nombre, String director, EnumInstrumento enumInstrumento, Categoria categoria) {
        this(nombre, director, enumInstrumento, categoria, new ArrayDeque<>());
    }
    public AgrupacionMusical(String nombre, String director, EnumInstrumento enumInstrumento, Categoria categoria, Deque<Instrumento> instrumentos) {
        this.nombre = nombre; this.director = director; this.enumInstrumento = enumInstrumento; this.categoria = categoria;
        this.instrumentos = instrumentos == null ? new ArrayDeque<>() : instrumentos;
    }
    public void agregarInstrumento(Instrumento instrumento) { if (instrumento != null) instrumentos.addLast(instrumento); }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public EnumInstrumento getEnumInstrumento() { return enumInstrumento; }
    public void setEnumInstrumento(EnumInstrumento enumInstrumento) { this.enumInstrumento = enumInstrumento; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Deque<Instrumento> getInstrumentos() { return instrumentos; }
    public void setInstrumentos(Deque<Instrumento> instrumentos) { this.instrumentos = instrumentos == null ? new ArrayDeque<>() : instrumentos; }
}
