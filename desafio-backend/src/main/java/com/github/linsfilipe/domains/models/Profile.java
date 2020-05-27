package com.github.linsfilipe.domains.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Cacheable
public class Profile extends BaseEntity {

	private static final long serialVersionUID = 3039800604537909517L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_PERFIL", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "NOME", length = 50, unique = true, nullable = false)
    private String nome;

    public Profile() {
    }
    
    public Profile(String nome) {
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
