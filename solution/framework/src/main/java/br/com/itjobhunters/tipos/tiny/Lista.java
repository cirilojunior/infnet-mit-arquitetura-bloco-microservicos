package br.com.itjobhunters.tipos.tiny;

import br.com.itjobhunters.tipos.tiny.exception.ListaVaziaException;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lista<T> {

    @EqualsAndHashCode.Include
    List<T> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    public Lista(final List<T> lista) {
        if (isEmpty(lista)) {
            throw new ListaVaziaException();
        }

        this.lista = new ArrayList<>(lista);
    }

    public Lista adiciona(final T item) {
        lista.add(item);
        return this;
    }

    public boolean contem(final T item) {
        return lista.contains(item);
    }

}
