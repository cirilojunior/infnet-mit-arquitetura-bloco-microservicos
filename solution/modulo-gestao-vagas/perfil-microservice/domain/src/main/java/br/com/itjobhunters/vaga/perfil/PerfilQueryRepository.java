package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.cqrs.query.QueryRepository;

public interface PerfilQueryRepository extends QueryRepository<Perfil> {

    int total();

}
