package br.com.itjobhunters.oportunidade;

import br.com.itjobhunters.cliente.Cliente;
import br.com.itjobhunters.tipos.cqrs.query.QueryRepository;
import br.com.itjobhunters.tipos.tiny.Lista;
import br.com.itjobhunters.vaga.Nivel;
import br.com.itjobhunters.vaga.Vaga;
import br.com.itjobhunters.vaga.experiencia.Experiencias;
import br.com.itjobhunters.vaga.habilidade.Habilidades;
import br.com.itjobhunters.vaga.perfil.Perfil;

public interface OportunidadeRepository extends QueryRepository<Oportunidade> {

    Lista<Oportunidade> lista(Cliente cliente);

    Lista<Oportunidade> lista(Cliente cliente, Nivel nivel);

    Lista<Oportunidade> lista(Cliente cliente, Vaga.Tipo tipoVaga);

    Lista<Oportunidade> lista(Cliente cliente, Perfil.Tipo tipoPerfil);

    Lista<Oportunidade> lista(Cliente cliente, Habilidades habilidades);

    Lista<Oportunidade> lista(Cliente cliente, Experiencias experiencias);

}
