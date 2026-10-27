package com.example.polimorfismo.repositories;

import com.example.polimorfismo.modelo.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Repository
public class TallerRepository {
    private final Stack<Instrumento> instrumentos = new Stack<>();
    private final AgrupacionMusical agrupacion;

    public TallerRepository() {
        agregar("Guitarra acústica", "Yamaha", "Acústica", 800000, EnumInstrumento.GUITARRA, Categoria.CUERDA, new int[]{1,2,3});
        agregar("Guitarra eléctrica", "Fender", "Eléctrica", 1500000, EnumInstrumento.GUITARRA, Categoria.CUERDA, new int[]{2,3,4});
        agregar("Guitarra clásica", "Alhambra", "Clásica", 1200000, EnumInstrumento.GUITARRA, Categoria.CUERDA, new int[]{0,2,5});
        agregar("Guitarra electroacústica", "Yamaha", "Electroacústica", 1800000, EnumInstrumento.GUITARRA, Categoria.CUERDA, new int[]{3,4,5});
        agregar("Guitarra flamenca", "Córdoba", "Flamenca", 950000, EnumInstrumento.GUITARRA, Categoria.CUERDA, new int[]{1,1,2});
        // Objeto de la clase contenedora (columna F): mismos enums que los 5 instrumentos
        agrupacion = new AgrupacionMusical("Ensamble de cuerdas", "María López", EnumInstrumento.GUITARRA, Categoria.CUERDA);
        // Se agregan los 5 instrumentos al Deque usando el método agregarInstrumento
        for (Instrumento instrumento : instrumentos) {
            agrupacion.agregarInstrumento(instrumento);
        }
    }
    private void agregar(String nombre, String marca, String tipo, int valor, EnumInstrumento opcion, Categoria categoria, int[] numeros) {
        Stack<Integer> conteo = new Stack<>(); for (int n : numeros) conteo.push(n);
        instrumentos.push(new Instrumento(nombre, marca, tipo, valor, opcion, categoria, conteo));
    }
    public Stack<Instrumento> getInstrumentosStack() { return instrumentos; }
    public AgrupacionMusical getAgrupacion() { return agrupacion; }
    public List<Instrumento> getListaInstrumentos() { return new ArrayList<>(instrumentos); }
}
