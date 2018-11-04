package br.com.entidade;

public class Funcionario {
	private int codfuncionario;
	public int getCodfuncionario() {
		return codfuncionario;
	}
//--------------------------------------------------------------------------------------------------------------------------	
	private String nomefuncionario;
	private String cargo;
	private String cpf;
	private String login;
	private String senha;
	
	public Funcionario() {
		
	}
	
	public Funcionario(int codfuncionario, String nomefuncionario,String cargo, String cpf, String login, String senha ) {
		this.codfuncionario=codfuncionario;
		this.nomefuncionario=nomefuncionario;
		this.cargo=cargo;
		this.cpf=cpf;
		this.login=login;
		this.senha=senha;
	}

//--------------------------------------------------------------------------------------------------------------------------
	public void setCodfuncionario(int codfuncionario) {
		this.codfuncionario = codfuncionario;
	}

	public String getNomefuncionario() {
		return nomefuncionario;
	}

	public void setNomefuncionario(String nomefuncionario) {
		this.nomefuncionario = nomefuncionario;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
