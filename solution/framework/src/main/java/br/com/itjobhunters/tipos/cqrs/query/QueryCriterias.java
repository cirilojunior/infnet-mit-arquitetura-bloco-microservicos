package br.com.itjobhunters.tipos.cqrs.query;

import br.com.itjobhunters.tipos.tiny.Lista;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Iterator;

@Value
@NoArgsConstructor
public class QueryCriterias {

    Lista<QueryCriteria<?>> criterias = new Lista<>();

    private QueryCriterias(final QueryCriteria criteria) {
        add(criteria);
    }

    public static <T> QueryCriterias of(final QueryCriteria<T> criteria) {
        return new QueryCriterias(criteria);
    }

    public QueryCriterias add(final QueryCriteria criteria) {
        criterias.adiciona(criteria);
        return this;
    }

    public Iterator<QueryCriteria<?>> iterator() {
        return criterias.getLista().iterator();
    }

}
