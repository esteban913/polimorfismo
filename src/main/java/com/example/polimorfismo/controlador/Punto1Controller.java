
package com.example.polimorfismo.controlador;

import com.example.polimorfismo.TallerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Punto1Controller {

    private final TallerService taller;

    public Punto1Controller(TallerService taller) {
        this.taller = taller;
    }

    @GetMapping("/punto1")
    public String punto1(Model model) {

        model.addAttribute(
                "instrumentos",
                taller.getInstrumentos()
        );

        model.addAttribute(
                "agrupacion",
                taller.getAgrupacion()
        );

        return "punto1";
    }
}
