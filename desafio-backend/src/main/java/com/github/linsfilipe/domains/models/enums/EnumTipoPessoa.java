package com.github.linsfilipe.domains.models.enums;

public enum EnumTipoPessoa {
	FISICA("Física"),
	JURIDICA("Jurídica");
	
	private String descricao;
	
	EnumTipoPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
