package br.com.itjobhunters.tipos;

import br.com.itjobhunters.tipos.tiny.Codigo;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CodigoTest {

    @Test
    public void igualdade() {
        final Codigo<Integer> codigo = new Codigo<>(1);
        assertTrue(codigo.getValor().equals(1));
        assertFalse(codigo.getValor().equals(2));
        assertTrue(codigo.equals(new Codigo<>(1)));
        assertFalse(codigo.equals(new Codigo<>(2)));
    }

}