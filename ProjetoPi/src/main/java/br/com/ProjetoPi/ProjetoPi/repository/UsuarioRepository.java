package br.com.ProjetoPi.ProjetoPi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ProjetoPi.ProjetoPi.models.Cadastro;
import br.com.ProjetoPi.ProjetoPi.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Iterable<Usuario>findByCadastro(Cadastro cadastro);
	
	Usuario findById(long id);
	
	List<Usuario>findByNickname(String nickname);
	
	@Query(value = "select u from Usuario u where u.nickname like %?1%")
	List<Usuario>findByNicknames(String nickname);
	
}
