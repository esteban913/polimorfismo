
package com.example.polimorfismo.controlador;

import com.example.polimorfismo.TallerService;
import com.example.polimorfismo.modelo.Instrumento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Punto4Controller {

    private final TallerService taller;

    public Punto4Controller(TallerService taller) {
        this.taller = taller;
    }

    @GetMapping("/punto4")
    public String punto4(Model model) {

        Map<String, Integer> totales = new LinkedHashMap<>();

        for (Instrumento i : taller.getInstrumentos()) {
            totales.put(
                    i.getNombre(),
                    taller.getFuncionSuma().apply(i)
            );
        }

        model.addAttribute("totales", totales);

        model.addAttribute(
                "funcion",
                "Function<Instrumento, Integer>"
        );

        return "punto4";
    }
}
