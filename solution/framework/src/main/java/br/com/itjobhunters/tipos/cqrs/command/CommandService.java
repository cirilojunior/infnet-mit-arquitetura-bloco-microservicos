package br.com.itjobhunters.tipos.cqrs.command;

import br.com.itjobhunters.tipos.ddd.Repository;

public interface CommandService<T> extends Repository<T> {

}
