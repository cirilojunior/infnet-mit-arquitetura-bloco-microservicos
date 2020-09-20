package br.com.itjobhunters.tipos.tiny;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Codigo<T> {

    @EqualsAndHashCode.Include
    T valor;

    @Override
    public String toString() {
        return valor.toString();
    }

}
