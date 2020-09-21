package br.com.itjobhunters.vaga.habilidade;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import lombok.*;

@Value
@Builder
public class Habilidade {

    public enum Tipo {
        GESTAO,
        TECNICA
    }

    @NonNull
    Sigla sigla;
    Nome nome;
    Descricao descricaoDetalhada;
    Tipo tipo;

}
