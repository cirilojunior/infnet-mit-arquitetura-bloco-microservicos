package br.com.itjobhunters.tipos.tiny.exception;

public class TamanhoMaximoTextoException extends TextoInvalidoException {

    public TamanhoMaximoTextoException() {
        super("O valor informado ultrapassou o valor máximo.");
    }

}
