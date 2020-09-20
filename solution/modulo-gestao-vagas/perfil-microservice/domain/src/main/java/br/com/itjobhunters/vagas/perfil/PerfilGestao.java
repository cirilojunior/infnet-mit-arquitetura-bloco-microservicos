package br.com.itjobhunters.vagas.perfil;

import lombok.Data;

@Data
public class PerfilGestao extends Perfil {

    @Override
    boolean isTecnico() {
        return false;
    }

    @Override
    boolean isGestao() {
        return true;
    }

}
