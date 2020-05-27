package com.github.linsfilipe.domains.dtos;

import com.github.linsfilipe.domains.models.Profile;

public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 8636936447254687879L;
	
	private Integer id;
	private String nome;
	private String login;
	private String dataCadastro;
	private Profile perfil;
    
	public UserDTO() {
	}
	
	public UserDTO(Integer id, String nome, String login, String dataCadastro, Profile perfil) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.dataCadastro = dataCadastro;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Profile getPerfil() {
		return perfil;
	}

	public void setPerfil(Profile perfil) {
		this.perfil = perfil;
	}
	
}
