package br.com.ProjetoPi.ProjetoPi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ProjetoPi.ProjetoPi.models.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Long> {
	Cadastro findByCodigo(long codigo);
	List<Cadastro> findByNickname(String nickname);
	
	@Query(value = "select u from Cadastro u where u.nickname like %?1%")
	List<Cadastro>findByNicknamesCadastro(String nickname);	
}
