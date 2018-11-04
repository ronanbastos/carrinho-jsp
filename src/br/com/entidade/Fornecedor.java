package br.com.entidade;

public class Fornecedor {
private int idfornecedor;



public Fornecedor() {
	
}

public Fornecedor(int idfornecedor, String nomefornecedor,String  cnpj,String telefone,String email,String endereco) {
	super();		

	this.idfornecedor = idfornecedor;
	this.nomefornecedor = nomefornecedor;
	 this.cnpj = cnpj;
	 this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
}




public int getIdfornecedor() {
	return idfornecedor;
}
public void setIdfornecedor(int idfornecedor) {
	this.idfornecedor = idfornecedor;
}
public String getNomefornecedor() {
	return nomefornecedor;
}
public void setNomefornecedor(String nomefornecedor) {
	this.nomefornecedor = nomefornecedor;
}
public String getCnpj() {
	return cnpj;
}
public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
private String nomefornecedor;
private String cnpj;
private String telefone;
private String email;
private String endereco;

}
