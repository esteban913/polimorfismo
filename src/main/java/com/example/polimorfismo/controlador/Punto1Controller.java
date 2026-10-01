package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Punto1Controller {

    private final InstrumentoRepository repositories;

    public Punto1Controller() {
        repositories = new InstrumentoRepository();
    }

    @GetMapping("/punto1")
    public String punto1(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                repositories.getTodosLosManipuladores();

        String nombres = manipuladores.stream()
                .map(ManipuladorInstrumento::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("nombres", nombres);

        return "punto1";
    }
}