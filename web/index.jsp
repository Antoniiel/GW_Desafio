<%-- 
    Document   : index
    Created on : 27 de set de 2021, 08:52:12
    Author     : gabriel
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
  <head>
    <title>GW Trans</title>
    <link href="index.css" rel="stylesheet">
    
  </head>  
  <body>
      
      <header>
          <div class="cabecalho">
              
                  <h2 class="tituloheader">Transportadoras</h2>
              
                  <button class="botaocadastro">Cadastre sua transportadora</button>
              
          </div>
      </header>
      
     
      <table>          
    <c:forEach var="trans" items="${ListTransportadoras}">
        
    <tr>
        <td><c:out value="${trans.nome}"/></td> 
        <td><c:out value="${trans.empresa}"/></td> 
        <td><c:out value="${trans.telefone}"/></td> 
        <td><c:out value="${trans.email}"/></td> 
        <td>Fale agora:<c:out value="${trans.whatsapp}"/></td> 
    
    </tr> 
    </c:forEach>
    </table>

</body>
</html>