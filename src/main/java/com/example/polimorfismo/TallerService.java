
package com.example.polimorfismo;

import com.example.polimorfismo.modelo.*;
import com.example.polimorfismo.repositories.TallerRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

@Service
public class TallerService {

    private final TallerRepository repository;

    private final Function<Instrumento, Integer> sumarConteo =
            instrumento -> instrumento.getConteo()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

    public TallerService(TallerRepository repository) {
        this.repository = repository;
    }

    public List<Instrumento> getInstrumentos() {
        return repository.getListaInstrumentos();
    }

    public AgrupacionMusical getAgrupacion() {
        return repository.getAgrupacion();
    }

    public List<String> listarConListIterator() {

        List<String> salida = new ArrayList<>();

        ListIterator<Instrumento> it =
                repository.getInstrumentosStack().listIterator();

        while (it.hasNext()) {
            salida.add(it.next().toString());
        }

        return salida;
    }

    public List<String> listarDequeConIterator() {

        List<String> salida = new ArrayList<>();

        Iterator<Instrumento> it =
                repository.getAgrupacion()
                        .getInstrumentos()
                        .iterator();

        while (it.hasNext()) {
            salida.add(it.next().toString());
        }

        return salida;
    }

    public List<Instrumento> filtrarPorEnum() {

        return repository.getAgrupacion()
                .getInstrumentos()
                .stream()
                .filter(i -> i.getEnumInstrumento()
                        == EnumInstrumento.GUITARRA)
                .toList();
    }

    public int total(Instrumento instrumento) {
        return sumarConteo.apply(instrumento);
    }

    public Function<Instrumento, Integer> getFuncionSuma() {
        return sumarConteo;
    }
}
