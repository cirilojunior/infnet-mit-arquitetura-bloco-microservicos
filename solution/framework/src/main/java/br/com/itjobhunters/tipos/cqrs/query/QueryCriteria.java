package br.com.itjobhunters.tipos.cqrs.query;

import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class QueryCriteria<T> {

    @NonNull
    @EqualsAndHashCode.Include
    Nome name;
    @NonNull
    T value;

    private QueryCriteria(final @NonNull Nome name, final @NonNull T value) {
        this.name = name;
        this.value = value;
    }

    public static <T> QueryCriteria<T> of(final @NonNull Nome name, final @NonNull T value) {
        return new QueryCriteria<T>(name, value);
    }
}
