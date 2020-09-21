package br.com.itjobhunters.vaga.cargo;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.NonNull;
import lombok.Value;

@Value
public class Cargo {

    @NonNull
    Codigo<Integer> codigo;
    Nome nome;
    Descricao descricaoDetalhada;

    private Cargo(final @NonNull Codigo<Integer> codigo, final Nome nome, final Descricao descricaoDetalhada) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public static Cargo para(final Codigo<Integer> codigo) {
        return new Cargo(codigo, null, null);
    }

    public static Cargo para(final Codigo<Integer> codigo, final Nome nome, final Descricao descricaoDetalhada) {
        return new Cargo(codigo, nome, descricaoDetalhada);
    }

}
