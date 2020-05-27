package com.github.linsfilipe.domains.dtos;

public class CredentialsDTO extends BaseDTO {

	private static final long serialVersionUID = -806416319783429841L;
	
	private String login;
    private String senha;
    
    public CredentialsDTO() {
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
	public void setPassword(String senha) {
		this.senha = senha;
	}

}
