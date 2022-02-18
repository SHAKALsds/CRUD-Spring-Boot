package br.com.ProjetoPi.ProjetoPi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String nickname;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String pswd;
	
	@ManyToOne
	private Cadastro cadastro;

	
	//GETTERS AND SETTERS
	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getPswd() {
		return pswd;
	}

	public Cadastro getCadastro() {
		return cadastro;
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

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
	
}
