package br.com.ProjetoPi.ProjetoPi.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.ProjetoPi.ProjetoPi.models.Usuario;

@Entity
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty
	private String nickname;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String pswd;
	
	@OneToMany(mappedBy = "cadastro", cascade = CascadeType.REMOVE)
	private List<Usuario> usuarios;
	
	//GETTERS AND SETTERS
	public long getCodigo() {
		return codigo;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getPswd() {
		return pswd;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
