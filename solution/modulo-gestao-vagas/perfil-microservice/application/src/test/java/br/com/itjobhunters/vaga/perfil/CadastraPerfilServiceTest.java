package br.com.itjobhunters.vaga.perfil;

import br.com.itjobhunters.tipos.tiny.Codigo;
import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Sigla;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import br.com.itjobhunters.vaga.Nivel;
import br.com.itjobhunters.vaga.cargo.Cargo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CadastraPerfilServiceTest {

    private static final PerfilQueryInMemoryRepository IN_MEMORY_REPO = new PerfilQueryInMemoryRepository();
    private CadastraPerfilService service;
    private PerfilQueryInMemoryRepository perfilQueryRepository;

    @Before
    public void setup() {
        perfilQueryRepository = IN_MEMORY_REPO;
        service = new CadastraPerfilService(IN_MEMORY_REPO);
    }

    @Test
    public void incluirPerfil() {

        final Perfil novoPerfil = PerfilGestao.builder()
                .tipo(Perfil.Tipo.TECNICO)
                .nome(Nome.para("Dev Full Stack"))
                .cargo(Cargo.para(Codigo.para(10)))
                .nivel(Nivel.PLENO)
                .sigla(Sigla.para("DEV_FULLST_PLN"))
                .descricaoDetalhada(Descricao.para("blah blah blah"))
                .build();

        assertEquals(5, perfilQueryRepository.total());
        service.cadastra(novoPerfil);
        assertEquals(6, perfilQueryRepository.total());
    }

    @Test(expected = TamanhoMinimoTextoException.class)
    public void falhaPorCriacaoTipoInvalidoPerfil() {

        final Perfil novoPerfil = PerfilGestao.builder()
                .tipo(Perfil.Tipo.TECNICO)
                .nome(Nome.para("Dev Full Stack"))
                .cargo(Cargo.para(Codigo.para(10)))
                .nivel(Nivel.PLENO)
                .sigla(Sigla.para("DEV_FULLST_PLN"))
                .descricaoDetalhada(Descricao.para("blah")) // Falha aqui pq a descricao não atingiu o mínimo!
                // Isso evita validações desnecessárias em vários pontos!
                .build();

        service.cadastra(novoPerfil); // nem chega aqui. Foi só pra exemplificar a segurança que isso traz.
    }

}