package br.com.itjobhunters.vaga.habilidade;

import br.com.itjobhunters.tipos.tiny.Lista;

public class Habilidades {

    private Lista<Habilidade> lista;

    public Habilidades(final Lista<Habilidade> lista) {
        this.lista = lista;
    }

    public Habilidades adiciona(final Habilidade habilidade) {
        lista.adiciona(habilidade);
        return this;
    }

    public boolean possui(final Habilidade habilidade) {
        return lista.contem(habilidade);
    }

}
