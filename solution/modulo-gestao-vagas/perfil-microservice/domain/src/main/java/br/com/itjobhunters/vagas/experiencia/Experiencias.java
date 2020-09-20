package br.com.itjobhunters.vagas.experiencia;


import br.com.itjobhunters.tipos.tiny.Lista;

public class Experiencias {

    private Lista<Experiencia> lista;

    public Experiencias(final Lista<Experiencia> lista) {
        this.lista = lista;
    }

    public Experiencias adiciona(final Experiencia habilidade) {
        lista.adiciona(habilidade);
        return this;
    }

    public boolean possui(final Experiencia experiencia) {
        return lista.contem(experiencia);
    }

}
