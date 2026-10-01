package com.example.polimorfismo.repositories;

import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.modelo.Guitarrista;
import com.example.polimorfismo.modelo.Instrumento;
import com.example.polimorfismo.modelo.Pianista;
import com.example.polimorfismo.modelo.Violinista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstrumentoRepository {

    private List<Guitarrista> guitarristas;
    private List<Pianista> pianistas;
    private List<Violinista> violinistas;

    public InstrumentoRepository() {

        // =========================
        // INSTRUMENTOS
        // =========================

        Instrumento guitarraAcustica =
                new Instrumento(
                        "Guitarra",
                        "Yamaha",
                        "Acústica",
                        800000
                );

        Instrumento guitarraElectrica =
                new Instrumento(
                        "Guitarra",
                        "Fender",
                        "Eléctrica",
                        1500000
                );

        Instrumento guitarraClasica =
                new Instrumento(
                        "Guitarra",
                        "Alhambra",
                        "Clásica",
                        1200000
                );

        Instrumento pianoCola =
                new Instrumento(
                        "Piano",
                        "Yamaha",
                        "De cola",
                        8000000
                );

        Instrumento pianoVertical =
                new Instrumento(
                        "Piano",
                        "Kawai",
                        "Vertical",
                        5000000
                );

        Instrumento pianoDigital =
                new Instrumento(
                        "Piano",
                        "Casio",
                        "Digital",
                        2500000
                );

        Instrumento violinClasico =
                new Instrumento(
                        "Violín",
                        "Stradivarius",
                        "Clásico",
                        6000000
                );

        Instrumento violinElectrico =
                new Instrumento(
                        "Violín",
                        "Yamaha",
                        "Eléctrico",
                        1800000
                );

        Instrumento violinAcustico =
                new Instrumento(
                        "Violín",
                        "Cremona",
                        "Acústico",
                        900000
                );


        // =========================
        // LISTAS DE INSTRUMENTOS
        // =========================

        List<Instrumento> lista0 =
                new ArrayList<>();

        List<Instrumento> lista1 =
                Arrays.asList(
                        guitarraAcustica
                );

        List<Instrumento> lista2 =
                Arrays.asList(
                        guitarraAcustica,
                        guitarraElectrica
                );

        List<Instrumento> lista3 =
                Arrays.asList(
                        guitarraAcustica,
                        guitarraElectrica,
                        guitarraClasica
                );

        List<Instrumento> lista4 =
                Arrays.asList(
                        guitarraAcustica,
                        guitarraElectrica,
                        guitarraClasica,
                        pianoCola
                );

        List<Instrumento> lista5 =
                Arrays.asList(
                        guitarraAcustica,
                        guitarraElectrica,
                        guitarraClasica,
                        pianoCola,
                        pianoVertical
                );


        // =========================
        // GUITARRISTAS
        // =========================

        Guitarrista g1 =
                new Guitarrista(
                        "Guitarrista 1",
                        lista0
                );

        Guitarrista g2 =
                new Guitarrista(
                        "Guitarrista 2",
                        lista1
                );

        Guitarrista g3 =
                new Guitarrista(
                        "Guitarrista 3",
                        lista2
                );

        Guitarrista g4 =
                new Guitarrista(
                        "Guitarrista 4",
                        lista3
                );


        // =========================
        // PIANISTAS
        // =========================

        Pianista p1 =
                new Pianista(
                        "Pianista 1",
                        lista4
                );

        Pianista p2 =
                new Pianista(
                        "Pianista 2",
                        lista5
                );

        Pianista p3 =
                new Pianista(
                        "Pianista 3",
                        lista0
                );

        Pianista p4 =
                new Pianista(
                        "Pianista 4",
                        lista1
                );


        // =========================
        // VIOLINISTAS
        // =========================

        Violinista v1 =
                new Violinista(
                        "Violinista 1",
                        lista2
                );

        Violinista v2 =
                new Violinista(
                        "Violinista 2",
                        lista3
                );

        Violinista v3 =
                new Violinista(
                        "Violinista 3",
                        lista4
                );

        Violinista v4 =
                new Violinista(
                        "Violinista 4",
                        lista5
                );


        // =========================
        // GUARDAR LOS OBJETOS
        // =========================

        guitarristas =
                Arrays.asList(
                        g1, g2, g3, g4
                );

        pianistas =
                Arrays.asList(
                        p1, p2, p3, p4
                );

        violinistas =
                Arrays.asList(
                        v1, v2, v3, v4
                );
    }


    public List<Guitarrista> getGuitarristas() {
        return guitarristas;
    }


    public List<Pianista> getPianistas() {
        return pianistas;
    }


    public List<Violinista> getViolinistas() {
        return violinistas;
    }
    public List<ManipuladorInstrumento> getTodosLosManipuladores() {

        return Arrays.asList(
                guitarristas.get(0),
                guitarristas.get(1),
                guitarristas.get(2),
                guitarristas.get(3),

                pianistas.get(0),
                pianistas.get(1),
                pianistas.get(2),
                pianistas.get(3),

                violinistas.get(0),
                violinistas.get(1),
                violinistas.get(2),
                violinistas.get(3)
        );
    }
}