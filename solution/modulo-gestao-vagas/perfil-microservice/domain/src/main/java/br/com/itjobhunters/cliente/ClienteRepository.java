package br.com.itjobhunters.cliente;

import br.com.itjobhunters.tipos.cqrs.query.QueryRepository;
import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Lista;
import br.com.itjobhunters.tipos.tiny.Nome;

public interface ClienteRepository extends QueryRepository<Cliente> {

    Lista<Cliente> busca(Codigo codigo);

    Lista<Cliente> busca(Nome nome);

}
