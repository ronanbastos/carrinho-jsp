<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Controle Produto</title>
</head>
<body>
<form id="cadastro" method="post" action="cadastrarproduto.html">
   
	    Nome do Produto:
	    <input type="text" name="nome" id="nome"><br>
	    foto:
	    <input type="text" name="foto"  id="foto"><br>
	    Descrição:
	    <textarea id="descricao" name="descricao"></textarea><br>
	    
	    Quantidade:
	    <input type="number" name="quantidade"   id="quantidade"><br>
	    valor:
	    <input type="text" name="preco"  id="preco"><br>
	    
	    
	<input type="submit" value="Cadastrar Produto" >
		
</form> 
</body>
</html>