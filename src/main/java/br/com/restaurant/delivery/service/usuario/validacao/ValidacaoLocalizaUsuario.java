package br.com.restaurant.delivery.service.usuario.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.restaurant.delivery.exception.RecursoNaoEncontradoException;
import br.com.restaurant.delivery.model.usuario.Usuario;
import br.com.restaurant.delivery.repository.usuario.UsuarioRepository;

@Component
public class ValidacaoLocalizaUsuario {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario valida(Long id) {
		Usuario usuario = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum usuário encontrado com este ID!"));
		
		return usuario;
	}

}
