package br.com.entidade;

public class Produto {
	//declara as visibilidades e os tipos das variáveis
private int idprod;
public int getIdprod() {
	return idprod;
}


public void setIdprod(int idprod) {
	this.idprod = idprod;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public String getFoto1() {
	return foto1;
}


public void setFoto1(String foto1) {
	this.foto1 = foto1;
}


public String getFoto2() {
	return foto2;
}


public void setFoto2(String foto2) {
	this.foto2 = foto2;
}


public String getFoto3() {
	return foto3;
}


public void setFoto3(String foto3) {
	this.foto3 = foto3;
}


public String getFoto4() {
	return foto4;
}


public void setFoto4(String foto4) {
	this.foto4 = foto4;
}


public int getQtdprod() {
	return qtdprod;
}


public void setQtdprod(int qtdprod) {
	this.qtdprod = qtdprod;
}


public double getPreco() {
	return preco;
}


public void setPreco(double preco) {
	this.preco = preco;
}
private String nome;
private String descricao;
private String foto1;
private String foto2;
private String foto3;
private String foto4;
private int qtdprod;
private double preco;

 
 
 
//constrói o método construtor


//constrói o método construtor com seus objetos encapsulados = this
public Produto(int idprod,String nome,String descricao,String foto1,String foto2,String foto3,String foto4, int qtdprod,double preco) {
		
	super(); //herdar as informações da Servlet
	this.idprod=idprod;
	this.nome=nome;
	this.descricao=descricao;
	this.foto1=foto1;
	this.foto2=foto2;
	this.foto3=foto3;
	this.foto4=foto4;
	this.qtdprod=qtdprod;
	this.preco=preco;
	
	
}


public Produto() {
	// TODO Auto-generated constructor stub
}
private String isDados() {
    String erros = "";

    

    if (nome.equals("")) {
        erros += "Nome em branco. \n";
    }
    if (descricao.equals("")) {
        erros += "Descricao em branco. \n";
    }
    if (foto1.equals("")) {
        erros += "foto em branco. \n";
    }
    if (foto2.equals("")) {
        erros += "foto em branco. \n";
    }
    if (foto3.equals("")) {
        erros += "foto em branco. \n";
    }
    if (foto4.equals("")) {
        erros += "foto em branco. \n";
    }
    if (qtdprod <= 0) {
        erros += "Quantidade menor que 0 ou  em branco. \n";
    }
    if (preco <= 0) {
        erros += "Preço menor que 0 ou  em branco. \n";
    }

    return erros;
}
public void validar() throws Exception {
    String erros = isDados();
    if (!erros.equals("")) {
        throw new Exception(erros);
    }
}






}





