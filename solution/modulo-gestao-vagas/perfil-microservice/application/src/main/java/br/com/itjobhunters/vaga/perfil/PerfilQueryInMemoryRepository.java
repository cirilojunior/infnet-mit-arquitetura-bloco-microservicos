package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.tipos.cqrs.command.Command;
import br.com.itjobhunters.tipos.cqrs.command.CommandResult;
import br.com.itjobhunters.tipos.cqrs.query.QueryCriteria;
import br.com.itjobhunters.tipos.cqrs.query.QueryCriterias;
import br.com.itjobhunters.tipos.tiny.*;
import br.com.itjobhunters.vaga.Nivel;
import br.com.itjobhunters.vaga.cargo.Cargo;

import java.util.Optional;

public class PerfilQueryInMemoryRepository implements PerfilQueryRepository, PerfilCommandRepository {

    private Lista<Perfil> lista = new Lista<>();

    public PerfilQueryInMemoryRepository() {
        lista.adiciona(PerfilGestao.builder()
                .tipo(Perfil.Tipo.TECNICO)
                .nome(Nome.para("Desenvolvedor Java Jr"))
                .cargo(Cargo.para(Codigo.para(1)))
                .nivel(Nivel.JUNIOR)
                .sigla(Sigla.para("DEV_JAVA_JNR"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build());

        lista.adiciona(PerfilGestao.builder()
                .tipo(Perfil.Tipo.TECNICO)
                .nome(Nome.para("Desenvolvedor Java Pleno"))
                .cargo(Cargo.para(Codigo.para(2)))
                .nivel(Nivel.PLENO)
                .sigla(Sigla.para("DEV_JAVA_PLN"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build());

        lista.adiciona(PerfilGestao.builder()
                .tipo(Perfil.Tipo.TECNICO)
                .nome(Nome.para("Desenvolvedor Java Sênior"))
                .cargo(Cargo.para(Codigo.para(3)))
                .nivel(Nivel.SENIOR)
                .sigla(Sigla.para("DEV_JAVA_SNR"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build());

        lista.adiciona(PerfilGestao.builder()
                .tipo(Perfil.Tipo.GESTAO)
                .nome(Nome.para("Gerente de Projetos Pleno"))
                .cargo(Cargo.para(Codigo.para(4)))
                .nivel(Nivel.PLENO)
                .sigla(Sigla.para("GER_PROJ_PLN"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build());

        lista.adiciona(PerfilGestao.builder()
                .tipo(Perfil.Tipo.GESTAO)
                .nome(Nome.para("Gerente de Projetos Sênior"))
                .cargo(Cargo.para(Codigo.para(5)))
                .nivel(Nivel.SENIOR)
                .sigla(Sigla.para("GER_PROJ_SNR"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build());
    }

    @Override
    public Lista<Perfil> list(final QueryCriterias criterias) {
        return lista;
    }

    @Override
    public Lista<Perfil> list(final QueryCriteria<?> queryCriteria) {
        Cliente cliente = (Cliente) queryCriteria.getValue();
        /// ... logica...
        return lista;
    }

    @Override
    public CommandResult<Perfil> execute(Command<Perfil> command) {
        final Perfil perfil = command.getTarget();
        lista.adiciona(perfil);
        return new CommandResult<>(Optional.of(perfil));
    }

    @Override
    public int total() {
        return lista.getLista().size();
    }
}
