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
            String fruta = request.getParameter("fruta");
            session.setAttribute("fruta", fruta);
        %>
        <p>Voc&ecirc; pediu <%=fruta%></p>
        <p><a href="index.jsp">Cancelar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="confirma.jsp">Confirmar</a></p>
    </body>
</html>
