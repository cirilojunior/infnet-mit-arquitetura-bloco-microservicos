package br.com.itjobhunters.vagas.perfil;

import lombok.Data;

@Data
public class PerfilTecnico extends Perfil {

    @Override
    boolean isTecnico() {
        return true;
    }

    @Override
    boolean isGestao() {
        return false;
    }

}
