package br.com.itjobhunters.cliente;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.NonNull;
import lombok.Value;

@Value
public class Cliente {

    @NonNull
    Codigo<Integer> codigo;
    Nome nome;

    private Cliente(final @NonNull Codigo<Integer> codigo, final Nome nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static Cliente para(final Codigo<Integer> codigo) {
        return new Cliente(codigo, null);
    }

    public static Cliente para(final Codigo<Integer> codigo, final Nome nome) {
        return new Cliente(codigo, nome);
    }

}
