package com.example.polimorfismo.modelo;

import java.util.Stack;
import java.util.function.Function;

/** Instrumento musical. Conserva también el constructor usado por los ejercicios anteriores. */
public class Instrumento {
    private String nombre;
    private String marca;
    private String tipo;
    private Integer valor;
    private EnumInstrumento enumInstrumento;
    private Categoria categoria;
    private Stack<Integer> conteo;

    public Instrumento() {
        this.conteo = new Stack<>();
    }

    public Instrumento(String nombre, String marca, String tipo, Integer valor) {
        this();
        this.nombre = nombre; this.marca = marca; this.tipo = tipo; this.valor = valor;
        this.enumInstrumento = inferirInstrumento(nombre);
        this.categoria = inferirCategoria(this.enumInstrumento);
    }

    public Instrumento(String nombre, String marca, String tipo, Integer valor,
                       EnumInstrumento enumInstrumento, Categoria categoria) {
        this(nombre, marca, tipo, valor, enumInstrumento, categoria, new Stack<>());
    }

    public Instrumento(String nombre, String marca, String tipo, Integer valor,
                       EnumInstrumento enumInstrumento, Categoria categoria, Stack<Integer> conteo) {
        this.nombre = nombre; this.marca = marca; this.tipo = tipo; this.valor = valor;
        this.enumInstrumento = enumInstrumento; this.categoria = categoria;
        this.conteo = conteo == null ? new Stack<>() : conteo;
    }

    private EnumInstrumento inferirInstrumento(String nombre) {
        if (nombre == null) return EnumInstrumento.GUITARRA;
        String n = nombre.toLowerCase();
        if (n.contains("piano")) return EnumInstrumento.PIANO;
        if (n.contains("viol")) return EnumInstrumento.VIOLIN;
        if (n.contains("flaut")) return EnumInstrumento.FLAUTA;
        if (n.contains("bater")) return EnumInstrumento.BATERIA;
        return EnumInstrumento.GUITARRA;
    }
    private Categoria inferirCategoria(EnumInstrumento tipo) {
        if (tipo == EnumInstrumento.FLAUTA) return Categoria.VIENTO;
        if (tipo == EnumInstrumento.PIANO || tipo == EnumInstrumento.BATERIA) return Categoria.PERCUSION;
        return Categoria.CUERDA;
    }

    public void agregarConteo(int numero) { conteo.push(numero); }
    public int sumarConteo() { return conteo.stream().mapToInt(Integer::intValue).sum(); }
    public void verTotales(Function<Instrumento, Integer> funcion) {
        System.out.println("Total del conteo de " + nombre + ": " + funcion.apply(this));
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getValor() { return valor; }
    public void setValor(Integer valor) { this.valor = valor; }
    public EnumInstrumento getEnumInstrumento() { return enumInstrumento; }
    public void setEnumInstrumento(EnumInstrumento enumInstrumento) { this.enumInstrumento = enumInstrumento; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Stack<Integer> getConteo() { return conteo; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo == null ? new Stack<>() : conteo; }
    @Override public String toString() { return "Instrumento{nombre='" + nombre + "', marca='" + marca + "', tipo='" + tipo + "', valor=" + valor + ", enumInstrumento=" + enumInstrumento + ", categoria=" + categoria + ", conteo=" + conteo + "}"; }
}
