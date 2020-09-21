package br.com.itjobhunters.tipos.tiny;

import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Descricao {

    public static final int TAMANHO_MINIMO = 5;
    public static final int TAMANHO_MAXIMO = 500;
    @EqualsAndHashCode.Include
    private Texto valor;

    private Descricao(final Texto valor) {
        if (!valor.atingiu(TAMANHO_MINIMO)) {
            throw new TamanhoMinimoTextoException();
        }

        if (valor.excedeu(TAMANHO_MAXIMO)) {
            throw new TamanhoMaximoTextoException();
        }

        this.valor = valor;
    }

    public static Descricao para(final String valor) {
        return new Descricao(Texto.para(valor));
    }

    public static Descricao para(final Texto valor) {
        return new Descricao(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
