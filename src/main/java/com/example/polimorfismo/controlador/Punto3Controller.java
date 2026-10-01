package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.Instrumento;
import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Punto3Controller {

    private final InstrumentoRepository repositories;

    public Punto3Controller() {
        repositories = new InstrumentoRepository();
    }

    @GetMapping("/punto3")
    public String punto3(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                repositories.getTodosLosManipuladores();

        List<Instrumento> todosLosInstrumentos =
                manipuladores.stream()
                        .flatMap(manipulador ->
                                manipulador.getInstrumentos().stream())
                        .toList();

        List<String> nombresInstrumentos =
                todosLosInstrumentos.stream()
                        .map(Instrumento::getNombre)
                        .toList();

        model.addAttribute(
                "instrumentos",
                todosLosInstrumentos
        );

        model.addAttribute(
                "nombresInstrumentos",
                nombresInstrumentos
        );

        return "punto3";
    }
}