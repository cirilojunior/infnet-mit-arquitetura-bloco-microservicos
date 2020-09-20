package br.com.itjobhunters.cliente;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.NonNull;
import lombok.Value;

@Value
public class Cliente {

    @NonNull
    Codigo codigo;
    Nome nome;

}
