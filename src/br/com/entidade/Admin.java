package br.com.entidade;

public class Admin {

	private int idadmin;
	private String nome;
	private String login;
	private String senha;

	
	public Admin() {
		
	}

	public Admin(String login, String senha) {
		super();		
		this.login = login;
		this.senha = senha;
		
	}

	public int getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}

	/*
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}*/

	

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
	
	

}
