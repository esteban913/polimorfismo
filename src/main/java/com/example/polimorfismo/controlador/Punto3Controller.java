
package com.example.polimorfismo.controlador;

import com.example.polimorfismo.TallerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Punto3Controller {

    private final TallerService taller;

    public Punto3Controller(TallerService taller) {
        this.taller = taller;
    }

    @GetMapping("/punto3")
    public String punto3(Model model) {

        model.addAttribute(
                "instrumentos",
                taller.filtrarPorEnum()
        );

        model.addAttribute(
                "enumBuscado",
                "GUITARRA"
        );

        return "punto3";
    }
}
