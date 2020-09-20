package br.com.itjobhunters.tipos.cqrs.query;

import br.com.itjobhunters.tipos.ddd.Repository;
import br.com.itjobhunters.tipos.tiny.Lista;

public interface QueryRepository<T> extends Repository<T> {

    Lista<T> list(QueryCriterias queryCriterias);

}
