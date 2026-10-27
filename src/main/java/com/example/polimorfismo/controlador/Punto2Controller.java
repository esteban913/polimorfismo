
package com.example.polimorfismo.controlador;

import com.example.polimorfismo.TallerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Punto2Controller {

    private final TallerService taller;

    public Punto2Controller(TallerService taller) {
        this.taller = taller;
    }

    @GetMapping("/punto2")
    public String punto2(Model model) {

        model.addAttribute(
                "stackIterado",
                taller.listarConListIterator()
        );

        model.addAttribute(
                "dequeIterado",
                taller.listarDequeConIterator()
        );

        return "punto2";
    }
}
