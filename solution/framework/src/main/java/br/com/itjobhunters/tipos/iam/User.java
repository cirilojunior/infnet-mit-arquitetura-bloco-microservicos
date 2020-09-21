package br.com.itjobhunters.tipos.iam;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Nome;
import lombok.*;

@Value
@AllArgsConstructor
@Builder
public class User {

    public enum Profile {
        GESTOR,
        ANALISTA,
        CLIENTE,
        CANDIDATO
    }

    @NonNull
    Codigo<Integer> code;
    Nome name;
    Profile profile;
    Claims permissions;

}
