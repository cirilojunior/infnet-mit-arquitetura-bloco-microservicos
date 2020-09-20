package br.com.itjobhunters.vagas.perfil;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import br.com.itjobhunters.vagas.experiencia.Experiencia;
import br.com.itjobhunters.vagas.habilidade.Habilidade;
import br.com.itjobhunters.vagas.Nivel;
import br.com.itjobhunters.vagas.cargo.Cargo;
import lombok.NonNull;

import java.util.List;

public abstract class Perfil {

    public enum Tipo {
        GESTAO,
        TECNICO
    }

    @NonNull
    Sigla sigla;
    Tipo tipo;
    Nome nome;
    Descricao descricaoDetalhada;
    Nivel nivel;
    Cargo cargo;
    List<Habilidade> habilidades;
    List<Experiencia> experiencias;

    abstract boolean isTecnico();

    abstract boolean isGestao();

}
