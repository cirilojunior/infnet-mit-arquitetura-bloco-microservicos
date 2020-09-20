package br.com.itjobhunters.tipos.cqrs.command;

import lombok.NonNull;
import lombok.Value;

@Value
public class CommandResult<T> {

    @NonNull
    T result;

}
