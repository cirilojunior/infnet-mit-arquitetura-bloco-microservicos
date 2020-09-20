package br.com.itjobhunters.tipos.tiny.exception;

public class TextoVazioException extends TextoInvalidoException {

    public TextoVazioException() {
        super("Não permite texto vazio.");
    }

}
