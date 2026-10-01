package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InstrumentoController {

    private final InstrumentoRepository repository;

    public InstrumentoController() {
        repository = new InstrumentoRepository();
    }

    @GetMapping({"/", "/instrumentos"})
    public String mostrarInstrumentos(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                new ArrayList<>();

        manipuladores.addAll(repository.getGuitarristas());
        manipuladores.addAll(repository.getPianistas());
        manipuladores.addAll(repository.getViolinistas());

        model.addAttribute(
                "manipuladores",
                manipuladores
        );

        return "instrumentos";
    }
}