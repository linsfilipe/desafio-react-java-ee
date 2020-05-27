package com.github.linsfilipe.domains.dtos;

public class AuthDTO extends BaseDTO {

	private static final long serialVersionUID = 8636936447254687879L;
	
	private String token;
	private String perfil;
    
	public AuthDTO(String token, String perfil) {
		this.token = token;
		this.perfil = perfil;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
