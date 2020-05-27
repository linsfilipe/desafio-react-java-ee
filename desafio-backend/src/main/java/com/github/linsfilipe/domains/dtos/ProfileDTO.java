package com.github.linsfilipe.domains.dtos;

public class ProfileDTO extends BaseDTO {

	private static final long serialVersionUID = 8636936447254687879L;
	
	private Integer id;
	private String nome;
    
	public ProfileDTO() {
	}
	
	public ProfileDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

}
