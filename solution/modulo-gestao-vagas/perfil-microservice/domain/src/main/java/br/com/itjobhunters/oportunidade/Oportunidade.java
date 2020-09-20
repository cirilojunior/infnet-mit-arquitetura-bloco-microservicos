package br.com.itjobhunters.oportunidade;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.tipos.tiny.Descricao;
import br.com.itjobhunters.vagas.Nivel;
import br.com.itjobhunters.vagas.Vaga;
import br.com.itjobhunters.vagas.experiencia.Experiencias;
import br.com.itjobhunters.vagas.habilidade.Habilidades;
import br.com.itjobhunters.vagas.perfil.Perfil;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Oportunidade {

    Cliente cliente;
    Nivel nivel;
    Vaga.Tipo tipoVaga;
    Perfil.Tipo tipoPerfil;
    Habilidades habilidades;
    Experiencias experiencias;
    Descricao descricaoDetalhada;

}
