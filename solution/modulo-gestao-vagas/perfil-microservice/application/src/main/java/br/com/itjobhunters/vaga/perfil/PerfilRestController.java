package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.tiny.Lista;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("perfil")
public class PerfilRestController {

    @GetMapping("/{codigoCliente}")
    public Lista<Perfil> recuperaPerfisDesejados(@PathVariable Integer codigoCliente) {
        return new Lista<>();
    }

}
