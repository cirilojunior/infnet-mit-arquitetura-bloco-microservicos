package br.com.itjobhunters.tipos.cqrs.command;

import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class CommandResult<T> {

    @NonNull
    Optional<T> result;

}
