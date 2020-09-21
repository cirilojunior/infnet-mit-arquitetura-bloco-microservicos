package br.com.itjobhunters.vaga;

import br.com.itjobhunters.tipos.tiny.Codigo;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum Nivel {

    JUNIOR(Codigo.para(1)),
    PLENO(Codigo.para(2)),
    SENIOR(Codigo.para(3));

    private Codigo<Integer> codigo;

    Nivel(final Codigo<Integer> codigo) {
        this.codigo = codigo;
    }

    public static Optional<Nivel> from(final Codigo<Integer> codigo) {
        return stream(Nivel.values())
                .filter(n -> n.equals(codigo))
                .findFirst();
    }
}
