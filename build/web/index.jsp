    <%-- 
    Document   : index
    Created on : 27 de set de 2021, 08:52:12
    Author     : gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>GW Trans</title> 
        <link href="index.css" rel="stylesheet">
        <meta charset="UTF-8"/>

    </head>  
    <body>

        <header>
            <div class="cabecalho">

                <h2 class="tituloheader">
                    <a class="tituloheader" href="TransportadoraControler?action=list">Transportadoras</a>
                </h2>

                <button class="botaocadastro" onclick="location.href = 'TransportadoraControler?action=new'" >Cadastre sua transportadora</button>


            </div>
        </header>       


        <section class="container">
            <div id="conteudo">

                <h1>Transportadoras</h1>

                <div id="menu-lateral">
                    <h3>Nome</h3>
                    <form id="buscanome" name="buscanome" action="TransportadoraControler?action=buscaCategoria&categoria=nome" method="post">
                        <label id="lname">Nome</label>
                        <input type="text" id="busca" name="busca" required="required"  >
                        <input type="submit" value="buscar" >
                    </form>

                </div>

                <div id="menu-lateral">
                    <h3>Localização (UFs)</h3>
                    <c:forEach var="trans" items="${ListarCategorias}">

                        <ul class="lista">
                            <li >
                                <a id="item-menu" id="busca" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=estado&busca=<c:out value="${trans.estado}"/>"  class="item-lista"> <c:out value="${trans.estado}"/> (<c:out value="${trans.contador}"/>) </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>

                <div id="menu-lateral">
                    <h3>Localização (Municipios)</h3>
                    <c:forEach var="trans" items="${ListarCategorias2}">

                        <ul class="lista">
                            <li >
                                <a id="item-menu" id="busca" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=cidade&busca=<c:out value="${trans.cidade}"/>" class="item-lista"> <c:out value="${trans.cidade}"/> (<c:out value="${trans.contador}"/>) </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>



                <div >
                    <h3>Modal</h3>
                    <c:forEach var="trans" items="${ListarCategorias3}">
                        
                        
                        <ul class="lista">
                            <li >
                                <a id="item-menu" id="busca" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=modal&busca=<c:out value="${trans.modal}"/>" class="item-lista"> <c:out value="${trans.modal}"/> (<c:out value="${trans.contador}"/>)  </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>



            </div>


            <div class="conteudo-principal">    
                   
                    <c:forEach var="trans" items="${ListarTrasnportadoras}">
                        <section class="conteudo-item">
                            <ul class="ul-style">
                                <li class="li-style"><a href="TransportadoraControler?action=edit&id=<c:out value="${trans.id}"/>"><c:out value="${trans.nome}"/></a></li> 
                                <li class="li-style"><c:out value="${trans.empresa}"/></li> 
                                                                
                            </ul>
                            <ul class="ul-style">
                                <li class="li-style"><c:out value="${trans.telefone}"/></li> 
                                <li class="li-style"><c:out value="${trans.email}"/></li> 
                                                              
                            </ul>           
                            <ul class="ul-style">                            
                                <li class="li-style">Fale agora: <c:out value="${trans.whatsapp}"/></li>  
                            </ul>           
                            
                            
                        </section>
                    </c:forEach>


            </div>
       
    </section>

      


</body>
</html>