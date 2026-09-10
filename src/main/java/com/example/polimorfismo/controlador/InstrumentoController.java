package com.example.polimorfismo.controlador;

import com.example.polimorfismo.modelo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InstrumentoController {

    @GetMapping("/")
    public String mostrarInstrumentos(Model model) {

        // =========================
        // CREACIÓN DE INSTRUMENTOS
        // =========================

        Instrumento guitarraAcustica = new Instrumento(
                "Guitarra",
                "Yamaha",
                "Acústica"
        );

        Instrumento guitarraElectrica = new Instrumento(
                "Guitarra",
                "Fender",
                "Eléctrica"
        );

        Instrumento guitarraClasica = new Instrumento(
                "Guitarra",
                "Alhambra",
                "Clásica"
        );

        Instrumento pianoCola = new Instrumento(
                "Piano",
                "Yamaha",
                "De cola"
        );

        Instrumento pianoVertical = new Instrumento(
                "Piano",
                "Kawai",
                "Vertical"
        );

        Instrumento pianoDigital = new Instrumento(
                "Piano",
                "Casio",
                "Digital"
        );

        Instrumento violinClasico = new Instrumento(
                "Violín",
                "Stradivarius",
                "Clásico"
        );

        Instrumento violinElectrico = new Instrumento(
                "Violín",
                "Yamaha",
                "Eléctrico"
        );

        Instrumento violinAcustico = new Instrumento(
                "Violín",
                "Cremona",
                "Acústico"
        );


        // =========================
        // 9 OBJETOS POLIMÓRFICOS
        // =========================

        ManipuladorInstrumento[] musicos = {

                new Guitarrista(guitarraAcustica),
                new Guitarrista(guitarraElectrica),
                new Guitarrista(guitarraClasica),

                new Pianista(pianoCola),
                new Pianista(pianoVertical),
                new Pianista(pianoDigital),

                new Violinista(violinClasico),
                new Violinista(violinElectrico),
                new Violinista(violinAcustico)
        };


        // =========================
        // RESULTADOS POLIMÓRFICOS
        // =========================

        List<ResultadoInstrumento> resultados = new ArrayList<>();

        for (ManipuladorInstrumento musico : musicos) {

            Instrumento instrumento = obtenerInstrumento(musico);

            ResultadoInstrumento resultado = new ResultadoInstrumento(
                    musico.getClass().getSimpleName(),
                    instrumento,
                    musico.afinar(instrumento),
                    musico.tocarMelodia(instrumento),
                    musico.improvisar(instrumento)
            );

            resultados.add(resultado);
        }


        // Enviamos los resultados al HTML
        model.addAttribute("resultados", resultados);

        return "instrumentos";
    }


    // =========================
    // OBTENER INSTRUMENTO
    // =========================

    private Instrumento obtenerInstrumento(ManipuladorInstrumento musico) {

        if (musico instanceof Guitarrista) {
            return ((Guitarrista) musico).getInstrumento();
        }

        if (musico instanceof Pianista) {
            return ((Pianista) musico).getInstrumento();
        }

        if (musico instanceof Violinista) {
            return ((Violinista) musico).getInstrumento();
        }

        throw new IllegalArgumentException(
                "Tipo de músico no reconocido"
        );
    }
}