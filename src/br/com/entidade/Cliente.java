package br.com.entidade;

public class Cliente {
	
	private int idcli;
	public int getIdcli() {
		return idcli;
	}

	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	private String nome;
	private String senha;
	private String email;
	private String datanasc;
	private String endereco;
	private String cidade;
	private String tel;
	private String cep;
	private String cpf; 
	private String ativo;
		
	
		

		public Cliente() {

		}
		
		public Cliente(String login, String senha) {
			this.email = login;
			this.senha = senha;
		}

		public Cliente(int idcli, String nome, String senha, String email, String datanasc,String endereco,String cidade, String tel,String cep, String cpf,String ativo) {
			super();
			this.idcli = idcli;
			this.nome = nome;
			this.senha = senha;
			this.email = email;
			this.datanasc = datanasc;
			this.endereco = endereco;
			this.cidade = cidade;
			this.tel = tel;
			this.cep = cep;
			this.cpf = cpf;
			this.ativo = ativo;
		}

		

		
		
		 private String isDados() {
		        String erros = "";

		        if (nome.equals("")) {
		            erros += "Nome do perfil em branco. \n";
		        }

		        if (cpf.equals("")) {
		            erros += "Cpf em branco. \n";
		        }

		        if (email.equals("")) {
		            erros += "E-mail em branco.\n";
		        } else if (email.length() < 5) {
		            erros += "E-mail invalido. E-mail muito curto. \n";
		        } else if ((!email.contains("@")) || (email.indexOf(".") == -1) ) {
		            erros += "E-mail invalido. \n";
		        }

		        if (tel.equals("")) {
		            erros += "Numero em branco. \n";
		        }

		        if (datanasc == null) {
		            erros += "Data de nascimento invalida ou em branco. \n";
		        }
		        if (senha.equals("")) {
		            erros += "Senha em branco.\n";
		        } else if (senha.length() < 6) {
		            erros += "Senha muito curta. Mínimo de 6 caracteres.\n";
		        }
		        
		        
		        return erros;
		    }

		    private String isSenha(String confSenha) {
		        String erros = "";
		        if (senha.equals("")) {
		            erros += "Senha em branco.\n";
		        } else if (senha.length() < 6) {
		            erros += "Senha muito curta. Mínimo de 6 caracteres.\n";
		        } else if (!senha.equals(confSenha)) {
		            erros += "Senhas diferentes.\n";
		        }
		        return erros;
		    }

		    public void validar() throws Exception {
		        String erros = isDados();
		        if (!erros.equals("")) {
		            throw new Exception(erros);
		        }
		    }

		    public void validar(String confSenha) throws Exception {
		        String erros = isDados() + isSenha(confSenha);
		        if (!erros.equals("")) {
		            throw new Exception(erros);
		        }
		    }
}
