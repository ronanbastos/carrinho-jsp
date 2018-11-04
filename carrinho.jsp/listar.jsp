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
    <ul>
        <%
            ArrayList compras = (ArrayList)session.getAttribute("compras");
            for(int i=0; i<compras.size(); i++){
        %>
        <li><%=compras.get(i).toString()%></li>
        <%
            }
        %>
    </ul>
        <p><a href="index.jsp">Comprar Mais</a></p>
    </body>
</html>
