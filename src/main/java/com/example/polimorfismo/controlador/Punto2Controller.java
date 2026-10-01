package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.Instrumento;
import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Punto2Controller {

    private final InstrumentoRepository repositories;

    public Punto2Controller() {
        repositories = new InstrumentoRepository();
    }

    @GetMapping("/punto2")
    public String punto2(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                repositories.getTodosLosManipuladores();

        List<Instrumento> todosLosInstrumentos =
                manipuladores.stream()
                        .flatMap(manipulador ->
                                manipulador.getInstrumentos().stream())
                        .toList();

        long cantidad = todosLosInstrumentos.size();

        int suma = todosLosInstrumentos.stream()
                .mapToInt(Instrumento::getValor)
                .sum();

        double promedio = todosLosInstrumentos.stream()
                .mapToInt(Instrumento::getValor)
                .average()
                .orElse(0);

        int minimo = todosLosInstrumentos.stream()
                .mapToInt(Instrumento::getValor)
                .min()
                .orElse(0);

        int maximo = todosLosInstrumentos.stream()
                .mapToInt(Instrumento::getValor)
                .max()
                .orElse(0);

        model.addAttribute("cantidad", cantidad);
        model.addAttribute("suma", suma);
        model.addAttribute("promedio", promedio);
        model.addAttribute("minimo", minimo);
        model.addAttribute("maximo", maximo);

        return "punto2";
    }
}