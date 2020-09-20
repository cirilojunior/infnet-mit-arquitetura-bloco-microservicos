package br.com.itjobhunters.tipos.tiny.exception;

public class ListaVaziaException extends RuntimeException {
    public ListaVaziaException() {
        super("Lista vazia.");
    }
}
