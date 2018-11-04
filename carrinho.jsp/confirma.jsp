<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sess&otilde;es e ArrayList</title>
    </head>
    <body>
        <h1>Sess&otilde;es e ArrayList</h1>
        <%
            String fruta = session.getAttribute("fruta").toString();
            ArrayList compras = (ArrayList)session.getAttribute("compras");
            if(compras == null){
                compras = new ArrayList();
            }
            compras.add(fruta);
            session.setAttribute("compras", compras);
        %>
        <p>Produto adicionado!</p>
        <p><a href="listar.jsp">Ver Compras</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">Comprar Mais</a></p>
    </body>
</html>
