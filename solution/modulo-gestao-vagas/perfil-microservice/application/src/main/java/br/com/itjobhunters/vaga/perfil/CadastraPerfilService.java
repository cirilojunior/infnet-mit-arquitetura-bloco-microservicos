package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.ddd.ApplicationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import static br.com.itjobhunters.tipos.cqrs.command.Command.Type;
import static br.com.itjobhunters.tipos.cqrs.command.Command.of;

@AllArgsConstructor
public class CadastraPerfilService implements ApplicationService<Perfil> {

    private PerfilCommandRepository perfilCommandRepository;

    public Perfil cadastra(final @NonNull Perfil perfil) {
        return perfilCommandRepository.execute(of(Type.INSERT, perfil))
                .getResult()
                .orElseThrow(CadastroPerfilException::new);
    }

}
