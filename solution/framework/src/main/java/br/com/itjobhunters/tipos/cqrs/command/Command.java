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

    private Command(final @NonNull Type type, final @NonNull T target) {
        this.type = type;
        this.target = target;
    }

    public static <T> Command<T> of(final @NonNull Type type, final @NonNull T target) {
        return new Command<T>(type, target);
    }
}
