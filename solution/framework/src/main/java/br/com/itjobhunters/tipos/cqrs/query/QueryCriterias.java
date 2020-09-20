package br.com.itjobhunters.tipos.cqrs.query;

import br.com.itjobhunters.tipos.tiny.Lista;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Iterator;

@Value
@NoArgsConstructor
public class QueryCriterias {

    Lista<Criteria> criterias = new Lista<>();

    public QueryCriterias(final Criteria criteria) {
        add(criteria);
    }

    public QueryCriterias add(final Criteria criteria) {
        criterias.adiciona(criteria);
        return this;
    }

    public Iterator<Criteria> iterator() {
        return criterias.getLista().iterator();
    }

}
