package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.cqrs.command.CommandException;

public class CadastroPerfilException extends CommandException {

    public CadastroPerfilException() {
        super("Ocorreu um erro no cadastro do Perfil");
    }

}
