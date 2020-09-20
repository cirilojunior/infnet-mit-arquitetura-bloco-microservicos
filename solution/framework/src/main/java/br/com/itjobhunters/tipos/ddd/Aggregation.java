package br.com.itjobhunters.tipos.ddd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Aggregation<T> {

    private T root;

}
