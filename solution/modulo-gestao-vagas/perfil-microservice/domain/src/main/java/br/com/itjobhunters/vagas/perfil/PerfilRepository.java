package br.com.itjobhunters.vagas.perfil;

import br.com.itjobhunters.tipos.cqrs.command.CommandRepository;
import br.com.itjobhunters.tipos.cqrs.command.CommandResult;
import br.com.itjobhunters.tipos.cqrs.query.QueryRepository;

public interface PerfilRepository extends QueryRepository<Perfil>, CommandRepository<Perfil, CommandResult<Perfil>> {

}
