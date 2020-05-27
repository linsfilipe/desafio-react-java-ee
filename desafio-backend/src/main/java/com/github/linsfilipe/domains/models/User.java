package com.github.linsfilipe.domains.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User extends BaseEntity {

	private static final long serialVersionUID = 1827827478586853272L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_USER", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "NOME", length = 100, unique = true, nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "LOGIN", length = 15, unique = true, nullable = false)
    private String login;

    @Size(min = 6, max = 15)
    @Column(name = "SENHA", length = 15, nullable = false)
    private String senha;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", nullable = false, referencedColumnName = "ID_PERFIL")
    private Profile perfil;
    
    public User() {
    	this.dataCadastro = LocalDate.now();
    }

    public User(String nome, String login, String senha, Profile perfil) {
    	this.nome = nome;
    	this.login = login;
    	this.senha = senha;
    	this.perfil = perfil;
    	this.dataCadastro = LocalDate.now();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Profile getPerfil() {
		return perfil;
	}

	public void setPerfil(Profile perfil) {
		this.perfil = perfil;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
