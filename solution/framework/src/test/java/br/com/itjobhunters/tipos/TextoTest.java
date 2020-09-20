package br.com.itjobhunters.tipos;

import br.com.itjobhunters.tipos.tiny.Texto;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMaximoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TamanhoMinimoTextoException;
import br.com.itjobhunters.tipos.tiny.exception.TextoVazioException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextoTest {

    @Test(expected = NullPointerException.class)
    public void valorNulo() {
        Texto.para(null);
    }

    @Test(expected = TextoVazioException.class)
    public void valorVazio() {
        Texto.para("");
    }

    @Test
    public void apenasValor() {
        final Texto cirilo = Texto.para("Cirilo");

        assertEquals("Cirilo", cirilo.toString());
        assertEquals(6, cirilo.tamanho());
    }

    @Test(expected = TamanhoMinimoTextoException.class)
    public void comValorMaisTamanhoMinimo() {
        final Texto cirilo = Texto.paraComTamanhoMinimo("Cirilo", 7);
        ;
    }

    @Test(expected = TamanhoMaximoTextoException.class)
    public void comValorMaisTamanhoMaximo() {
        final Texto cirilo = Texto.paraComTamanhoMaximo("Cirilo", 5);

        assertEquals("Cirilo", cirilo.toString());
    }

    @Test
    public void apenasValorMaisTamanhosMinimoMaximo() {
        final Texto cirilo = Texto.para("Cirilo");

        assertEquals("Cirilo", cirilo.toString());
    }

    @Test
    public void testandoTamanhoMinimo() {
        final Texto cirilo = Texto.para("Cirilo");

        assertTrue(cirilo.atingiu(6));
        assertFalse(cirilo.excedeu(7));
    }

    @Test
    public void testandoTamanhoMaximo() {
        final Texto cirilo = Texto.para("Cirilo");

        assertFalse(cirilo.atingiu(7));
        assertTrue(cirilo.atingiu(6));
    }

    @Test
    public void contem() {
        final Texto cirilo = Texto.para("Cirilo");

        assertTrue(cirilo.contem("lo"));
    }

    @Test
    public void naoContem() {
        final Texto cirilo = Texto.para("Cirilo");

        assertFalse(cirilo.contem("a"));
    }

}