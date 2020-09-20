package br.com.itjobhunters.tipos.tiny;

import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sigla {

    public static final int TAMANHO_MINIMO = 5;
    public static final int TAMANHO_MAXIMO = 10;
    @EqualsAndHashCode.Include
    private Texto valor;

    public Sigla(final String valor) {
        this(Texto.para(valor));
    }

    public Sigla(final Texto valor) {
        if (!valor.atingiu(TAMANHO_MINIMO)) {
            throw new TamanhoMinimoTextoException();
        }

        if (valor.excedeu(TAMANHO_MAXIMO)) {
            throw new TamanhoMaximoTextoException();
        }

        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }


}
