package br.com.itjobhunters.tipos.tiny;

import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TextoVazioException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Texto {

    @NonNull
    @EqualsAndHashCode.Include
    String valor;
    @EqualsAndHashCode.Include
    Integer tamanhoMaximo;
    @EqualsAndHashCode.Include
    Integer tamanhoMinimo;

    private Texto(final String valor, final Integer tamanhoMaximo, final Integer tamanhoMinimo) {
        if (valor.isEmpty()) {
            throw new TextoVazioException();
        }
        this.valor = valor;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoMinimo = tamanhoMinimo;
    }

    public static Texto para(final @NonNull String valor) {
        return new Texto(valor, null, null);
    }

    public static Texto para(final @NonNull String valor, final @NonNull Integer tamanhoMinimo, final @NonNull Integer tamanhoMaximo) {
        return new Texto(valor, tamanhoMinimo, tamanhoMaximo);
    }

    public static Texto paraComTamanhoMinimo(final @NonNull String valor, final @NonNull Integer tamanhoMinimo) {
        if (valor.length() < tamanhoMinimo) {
            throw new TamanhoMinimoTextoException();
        }

        return Texto.para(valor, tamanhoMinimo, null);
    }

    public static Texto paraComTamanhoMaximo(final @NonNull String valor, final @NonNull Integer tamanhoMaximo) {
        if (valor.length() > tamanhoMaximo) {
            throw new TamanhoMaximoTextoException();
        }

        return Texto.para(valor, null, tamanhoMaximo);
    }

    public boolean contem(final @NonNull String valor) {
        return this.valor.contains(valor);
    }

    @Override
    public String toString() {
        return valor;
    }

    public int tamanho() {
        return valor.length();
    }

    public boolean atingiu(final int tamanhoMinimo) {
        return tamanho() >= tamanhoMinimo;
    }

    public boolean excedeu(final int tamanhoMaximo) {
        return tamanho() > tamanhoMaximo;
    }

}
