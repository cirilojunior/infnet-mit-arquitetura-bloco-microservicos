package br.com.itjobhunters.tipos.tiny;

import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Nome {

    public static final int TAMANHO_MINIMO = 2;
    public static final int TAMANHO_MAXIMO = 100;
    @EqualsAndHashCode.Include
    private Texto valor;

    private Nome(final Texto valor) {
        if (!valor.atingiu(TAMANHO_MINIMO)) {
            throw new TamanhoMinimoTextoException();
        }

        if (valor.excedeu(TAMANHO_MAXIMO)) {
            throw new TamanhoMaximoTextoException();
        }

        this.valor = valor;
    }

    public static Nome para(final String valor) {
        return new Nome(Texto.para(valor));
    }

    public static Nome para(final Texto valor) {
        return new Nome(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
