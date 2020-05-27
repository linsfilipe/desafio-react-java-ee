package com.github.linsfilipe.domains.dtos;

import com.github.linsfilipe.domains.models.enums.EnumTipoPessoa;

public class PessoaDTO extends BaseDTO {

	private static final long serialVersionUID = 8648681069082092876L;

    private String nome;
    private String documento;
    private String dataNascimento;
    private String nomePai;
    private String nomeMae;
    private EnumTipoPessoa tipoPessoa;
    
    public PessoaDTO() {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
