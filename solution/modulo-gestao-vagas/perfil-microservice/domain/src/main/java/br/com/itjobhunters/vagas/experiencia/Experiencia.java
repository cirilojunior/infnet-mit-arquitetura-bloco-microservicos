package br.com.itjobhunters.vagas.experiencia;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import br.com.itjobhunters.vagas.habilidade.Habilidade;
import lombok.*;

@Value
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Experiencia {

    public enum Tipo {
        GESTAO,
        TECNICA,
        NEGOCIO,
        CULTURAL,
        SOFT_SKILL
    }

    @NonNull
    Sigla sigla;
    Nome nome;
    Descricao descricaoDetalhada;
    Habilidade.Tipo tipo;

}
