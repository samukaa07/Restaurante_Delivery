package br.com.restaurant.delivery.service.cliente.acao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.controller.ClienteController;
import br.com.restaurant.delivery.data.vo.v1.cliente.ClienteVO;

@Component
public class AdicionaLinkCliente {
	
	public ClienteVO adicionaLink(ClienteVO vo) {
		vo.add(linkTo(methodOn(ClienteController.class).buscaClientePeloId(vo.getId())).withSelfRel());

		return vo;
	}
	
	public List<ClienteVO> adicionaLinkLista(List<ClienteVO> vos){
		vos.forEach(vo -> vo
				.add(linkTo(methodOn(ClienteController.class).buscaClientePeloId(vo.getId())).withSelfRel()));

		return vos;
	}

}
