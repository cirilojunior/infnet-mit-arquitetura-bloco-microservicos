package br.com.itjobhunters.tipos;

import br.com.itjobhunters.tipos.tiny.Nome;
import br.com.itjobhunters.tipos.tiny.Texto;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NomeTest {

    @Test
    public void criaPorString() {
        assertEquals("ab", Nome.para("ab").toString());
    }

    @Test(expected = TamanhoMinimoTextoException.class)
    public void nomeTamanhoMinimo() {
        Nome.para(Texto.para("a"));
    }

    @Test(expected = TamanhoMaximoTextoException.class)
    public void nomeTamanhoMaximo() {
        Nome.para(Texto.para("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
    }

}