package br.com.itjobhunters.tipos.tiny;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Codigo<T> {

    @NonNull
    @EqualsAndHashCode.Include
    T valor;

    private Codigo(final T valor) {
        this.valor = valor;
    }

    public static <T> Codigo<T> para(T valor) {
        return new Codigo<T>(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }

}
