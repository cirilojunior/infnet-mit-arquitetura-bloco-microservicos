package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.tipos.cqrs.query.QueryCriteria;
import br.com.itjobhunters.tipos.ddd.ApplicationService;
import br.com.itjobhunters.tipos.tiny.Lista;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class PesquisaPerfilService implements ApplicationService<Perfil> {

    private PerfilQueryRepository perfilQueryRepository;

    public Lista<Perfil> recuperaPerfisDesejados(final @NonNull Cliente cliente) {

        final QueryCriteria<Cliente> criteria = QueryCriteria.of(
                Nome.para(Cliente.class.getName()),
                cliente
        );

        return perfilQueryRepository.list(criteria);
    }

}
