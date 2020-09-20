package br.com.itjobhunters.tipos.tiny.exception;

public class TamanhoMinimoTextoException extends TextoInvalidoException {

    public TamanhoMinimoTextoException() {
        super("O valor informado não atingiu o valor mínimo.");
    }

}
