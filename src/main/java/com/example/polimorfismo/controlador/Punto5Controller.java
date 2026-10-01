package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.Instrumento;
import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class Punto5Controller {

    private final InstrumentoRepository repositories;

    public Punto5Controller() {
        repositories = new InstrumentoRepository();
    }

    @GetMapping("/punto5")
    public String punto5(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                repositories.getTodosLosManipuladores();

        List<Instrumento> todosLosInstrumentos =
                manipuladores.stream()
                        .flatMap(manipulador ->
                                manipulador.getInstrumentos().stream())
                        .toList();

        Instrumento instrumentoMayor =
                todosLosInstrumentos.stream()
                        .max(
                                Comparator.comparing(
                                        Instrumento::getValor
                                )
                        )
                        .orElse(null);

        model.addAttribute(
                "instrumentoMayor",
                instrumentoMayor
        );

        return "punto5";
    }
}