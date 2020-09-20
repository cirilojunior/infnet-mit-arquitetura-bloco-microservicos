package br.com.itjobhunters.tipos;

import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.tipos.tiny.Texto;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DescricaoTest {

    @Test
    public void criaPorString() {
        assertEquals("abcde", new Descricao("abcde").toString());
    }

    @Test(expected = TamanhoMinimoTextoException.class)
    public void nomeTamanhoMinimo() {
        new Descricao(Texto.para("abcd"));
    }

    @Test(expected = TamanhoMaximoTextoException.class)
    public void nomeTamanhoMaximo() {
        new Descricao(Texto.para("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaab"));
    }


}