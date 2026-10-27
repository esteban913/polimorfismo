
package com.example.polimorfismo.controlador;

import com.example.polimorfismo.TallerService;
import com.example.polimorfismo.modelo.Instrumento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Punto5Controller {

    private final TallerService taller;

    public Punto5Controller(TallerService taller) {
        this.taller = taller;
    }

    @GetMapping("/punto5")
    public String punto5(Model model) {

        Map<String, Integer> totales = new LinkedHashMap<>();

        for (Instrumento i : taller.getInstrumentos()) {

            i.verTotales(taller.getFuncionSuma());

            totales.put(
                    i.getNombre(),
                    taller.getFuncionSuma().apply(i)
            );
        }

        model.addAttribute("totales", totales);

        return "punto5";
    }
}
