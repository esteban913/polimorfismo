package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.Instrumento;
import com.example.polimorfismo.modelo.ManipuladorInstrumento;
import com.example.polimorfismo.repositories.InstrumentoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Punto4Controller {

    private final InstrumentoRepository repositories;

    public Punto4Controller() {
        repositories = new InstrumentoRepository();
    }

    @GetMapping("/punto4")
    public String punto4(Model model) {

        List<ManipuladorInstrumento> manipuladores =
                repositories.getTodosLosManipuladores();

        List<Instrumento> todosLosInstrumentos =
                manipuladores.stream()
                        .flatMap(manipulador ->
                                manipulador.getInstrumentos().stream())
                        .toList();

        boolean existeYamaha =
                todosLosInstrumentos.stream()
                        .anyMatch(instrumento ->
                                "Yamaha".equals(instrumento.getMarca()));

        boolean existeInstrumentoCaro =
                todosLosInstrumentos.stream()
                        .anyMatch(instrumento ->
                                instrumento.getValor() >= 8000000);

        boolean ningunoNegativo =
                todosLosInstrumentos.stream()
                        .noneMatch(instrumento ->
                                instrumento.getValor() < 0);

        model.addAttribute(
                "existeYamaha",
                existeYamaha
        );

        model.addAttribute(
                "existeInstrumentoCaro",
                existeInstrumentoCaro
        );

        model.addAttribute(
                "ningunoNegativo",
                ningunoNegativo
        );

        return "punto4";
    }
}