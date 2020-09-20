package br.com.itjobhunters.tipos.cqrs.command;

import br.com.itjobhunters.tipos.ddd.Repository;

public interface CommandRepository<T, R> extends Repository<T> {

    CommandResult<R> execute(Command<T> command);

}
