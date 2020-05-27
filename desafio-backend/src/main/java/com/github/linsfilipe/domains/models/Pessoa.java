package com.github.linsfilipe.domains.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.linsfilipe.domains.models.enums.EnumTipoPessoa;
import com.github.linsfilipe.utils.Util;

@Entity
public class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 1827827478586853272L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_USER", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "DOCUMENTO", length = 15, unique = true, nullable = false)
    private String documento;

    @NotNull
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "NOME_PAI", length = 100)
    private String nomePai;

    @Column(name = "NOME_MAE", length = 100)
    private String nomeMae;
    
    @NotNull
    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;
    
    @NotBlank
    @Column(name = "LOGIN_OPERADOR", length = 15)
    private String loginOperador;

    @NotNull
    @Column(name = "TIPO_PESSOA", nullable = false)
    private EnumTipoPessoa tipoPessoa;
    
	public Pessoa() {
		this.dataCadastro = LocalDate.now();
	}
    
	public Pessoa(String nome, String documento, LocalDate dataNascimento, String nomePai, String nomeMae,
			String loginOperador, EnumTipoPessoa tipoPessoa) {
		this.nome = nome;
		this.documento = documento;
		this.dataNascimento = dataNascimento;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.loginOperador = loginOperador;
		this.tipoPessoa = tipoPessoa;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getDataNascimentoFormatada() {
		return Util.formatarData(this.dataNascimento);
	}
	
	public String getDataCadastroFormatada() {
		return Util.formatarData(this.dataCadastro);
	}
}
