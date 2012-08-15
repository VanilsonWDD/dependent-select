<%-- 
    Document   : index
    Created on : 15/Ago/2012, 10:13:10
    Author     : Vanilson
--%>
<%@page import="java.util.List, selectsdependentes.modelo.Pais, selectsdependentes.dao.PaisDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selects dependentes com jquery e jsp</title>
        <script src = "jquery-1.7.1.js"></script>
        <script src = "ajax.js"></script>
    </head>
    <body>
        <form action ="#" method ="post">
            <ul>
                <li><label for ="nomepais">Nome do pais</label></li>
                <li><select name ="sltnomepais" id ="nomepais">
                        <option selected="">--Seleccione o nome do pais--</option>
                        <%
                            PaisDao pd = new PaisDao();
                            List<Pais> lp = pd.visualizar();
                            for (Pais p : lp) {
                        %>
                        <option value=<%=p.getCodigoPais()%>><%=p.getNomePais()%></option>
                        <%}%>
                    </select></li>
                <li><label for ="nomepais">Nome da provincia</label></li>
                <li><select name ="sltnomeprovincia" id ="nomeprovincia">
                        <option selected="selected">--Seleccione o da provincia--</option>
                    </select></li>
            </ul>
        </form>
    </body>
</html>
