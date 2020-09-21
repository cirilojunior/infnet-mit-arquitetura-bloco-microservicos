package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import br.com.itjobhunters.vaga.Nivel;
import br.com.itjobhunters.vaga.cargo.Cargo;
import br.com.itjobhunters.vaga.experiencia.Experiencia;
import br.com.itjobhunters.vaga.habilidade.Habilidade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.List;

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perfil {

    public enum Tipo {
        GESTAO,
        TECNICO
    }

    @NonNull
    @EqualsAndHashCode.Include
    Sigla sigla;
    Tipo tipo;
    Nome nome;
    Descricao descricaoDetalhada;
    Nivel nivel;
    Cargo cargo;
    List<Habilidade> habilidades;
    List<Experiencia> experiencias;

    public boolean isTecnico() {
        return Tipo.TECNICO.equals(tipo);
    }

    public boolean isGestao() {
        return Tipo.GESTAO.equals(tipo);
    }

}
