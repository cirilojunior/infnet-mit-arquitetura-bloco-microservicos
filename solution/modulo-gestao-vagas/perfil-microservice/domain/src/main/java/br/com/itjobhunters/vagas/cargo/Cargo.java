package br.com.itjobhunters.vagas.cargo;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.NonNull;
import lombok.Value;

@Value
public class Cargo {

    @NonNull
    Codigo codigo;
    Nome nome;
    Descricao descricaoDetalhada;

}
