package br.com.itjobhunters.tipos.cqrs.command;

import lombok.NonNull;
import lombok.Value;

@Value
public class Command<T> {

    public enum Type {
        INSERT,
        UPDATE,
        DELETE,
        BUSINESS
    }

    @NonNull
    Type type;
    @NonNull
    T target;

}
