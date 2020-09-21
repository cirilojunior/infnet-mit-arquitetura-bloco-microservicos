package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Lista;
import br.com.itjobhunters.tipos.tiny.Sigla;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PesquisaPerfilServiceTest {

    private PesquisaPerfilService service;

    @Before
    public void setup() {
        service = new PesquisaPerfilService(new PerfilQueryInMemoryRepository());
    }

    @Test
    public void perfisDesejadosCliente() {
        final Lista<Perfil> perfisDesejados = service.recuperaPerfisDesejados(Cliente.para(Codigo.para(1000)));

        final Perfil javaSenior = Perfil.builder().sigla(Sigla.para("DEV_JAVA_SNR")).build();
        assertTrue(perfisDesejados.contem(javaSenior));
    }

}