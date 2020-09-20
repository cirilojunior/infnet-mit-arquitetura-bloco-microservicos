package br.com.itjobhunters.vagas;

import br.com.itjobhunters.tipos.tiny.Codigo;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum Nivel {

    JUNIOR(new Codigo(1)),
    PLENO(new Codigo(2)),
    SENIOR(new Codigo(3));

    private Codigo codigo;

    Nivel(final Codigo codigo) {
        this.codigo = codigo;
    }

    public static Optional<Nivel> from(final Codigo codigo) {
        return stream(Nivel.values())
                .filter(n -> n.equals(codigo))
                .findFirst();
    }
}
