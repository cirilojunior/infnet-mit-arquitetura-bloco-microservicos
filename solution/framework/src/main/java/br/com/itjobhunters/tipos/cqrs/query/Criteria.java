package br.com.itjobhunters.tipos.cqrs.query;

import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Criteria<T> {

    @NonNull
    Nome nome;
    @NonNull
    T valor;

}
