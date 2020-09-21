package br.com.itjobhunters.tipos.iam;

import br.com.itjobhunters.tipos.tiny.Lista;

public class Claims {

    Lista<Claim> lista;

    public Claims(final Lista<Claim> lista) {
        this.lista = lista;
    }

    public Claims adiciona(final Claim claim) {
        lista.adiciona(claim);
        return this;
    }

    public boolean possui(final Claim habilidade) {
        return lista.contem(habilidade);
    }

}
