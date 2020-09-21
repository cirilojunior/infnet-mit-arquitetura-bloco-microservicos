package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import br.com.itjobhunters.vaga.Nivel;
import br.com.itjobhunters.vaga.cargo.Cargo;
import br.com.itjobhunters.vaga.experiencia.Experiencia;
import br.com.itjobhunters.vaga.habilidade.Habilidade;
import lombok.NonNull;

import java.util.List;


public class PerfilTecnico extends Perfil {

    PerfilTecnico(@NonNull Sigla sigla, Tipo tipo, Nome nome, Descricao descricaoDetalhada, Nivel nivel, Cargo cargo, List<Habilidade> habilidades, List<Experiencia> experiencias) {
        super(sigla, tipo, nome, descricaoDetalhada, nivel, cargo, habilidades, experiencias);
    }

    @Override
    public boolean isTecnico() {
        return true;
    }

    @Override
    public boolean isGestao() {
        return false;
    }

}
