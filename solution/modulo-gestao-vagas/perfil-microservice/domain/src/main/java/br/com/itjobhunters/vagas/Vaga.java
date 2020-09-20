package br.com.itjobhunters.vagas;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.oportunidade.Oportunidade;
import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.NonNull;

public abstract class Vaga {

    public enum Tipo {
        PRESENCIAL,
        REMOTA
    }

    @NonNull
    Codigo codigo;
    @NonNull
    Tipo tipo;
    Nome nome;
    Descricao descricaoDetalhada;
    Cliente cliente;
    Oportunidade oportunidade;

    public abstract boolean isPresencial();

    public abstract boolean isRemota();

}
