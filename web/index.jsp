<%-- 
Document   : index
Created on : 27 de set de 2021, 08:52:12
Author     : gabriel
--%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>GW Trans</title> 
        <link href="index.css" rel="stylesheet">
        <meta charset="utf-8"/>

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
                <div id="menu-lateral1">                    
                    <h1>Transportadoras</h1>
                </div>

                <div id="menu-lateral">
                    <h3>Nome</h3>
                    <form id="buscanome" name="buscanome" action="TransportadoraControler?action=buscaCategoria&categoria=nome" method="post">                        
                        <input type="text" id="busca" name="busca" required="required"  >
                        <input type="submit" value="buscar" >
                    </form>

                </div>

                <div id="menu-lateral">
                    <h3>Localização (UFs)</h3>
                    <c:forEach var="trans" items="${ListarCategorias}">
                        <ul class="lista">
                            <li id="busca">
                                <a  id="link-filtro" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=estado&busca=<c:out value="${trans.estado}"/>" 
                                   class="item-lista"> <c:out value="${trans.estado}"/> (<c:out value="${trans.contador}"/>) </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>

                <div id="menu-lateral">
                    <h3>Localização (Municipios)</h3>
                    <c:forEach var="trans" items="${ListarCategorias2}">
                        <ul class="lista">
                            <li id="busca">
                                <a id="link-filtro" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=cidade&busca=<c:out value="${trans.cidade}"/>" 
                                   class="item-lista"> <c:out value="${trans.cidade}"/> (<c:out value="${trans.contador}"/>) </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>



                <div >
                    <h3>Modal</h3>
                    <c:forEach var="trans" items="${ListarCategorias3}">
                        <ul class="lista">
                            <li id="busca">
                                <a  id="link-filtro" name="busca" href="TransportadoraControler?action=buscaCategoria&categoria=modal&busca=<c:out value="${trans.modal}"/>" 
                                   class="item-lista"> <c:out value="${trans.modal}"/> (<c:out value="${trans.contador}"/>)  </a>
                            </li>
                        </ul>                                                 


                    </c:forEach>
                </div>



            </div>


            <div class="conteudo-principal">    

                <c:forEach var="trans" items="${ListarTransportadoras}">
                    <section class="conteudo-item">
                        <ul class="ul-style">
                            <li class="li-style"><a href="TransportadoraControler?action=edit&id=<c:out value="${trans.id}"/>"><c:out value="${trans.nome}"/></a></li> 
                            <li class="li-style"><c:out value="${trans.empresa}"/></li> 

                        </ul>
                        <ul class="ul-style">
                            <li class="li-style"><c:out value="${trans.telefone}"/> / <c:out value="${trans.celular}"/> </li> 
                            <li class="li-style"><c:out value="${trans.email}"/></li> 

                        </ul>           
                        <ul class="ul-style">                            
                            <li class="li-style">Fale agora: 
                            <a  target="blank" href="https://api.whatsapp.com/send?phone=<c:out value="${trans.whatsapp}"/>">
                                <c:out value="${trans.whatsapp}"/></li>  
                             </a>
                        </ul>           


                    </section>
                </c:forEach>


            </div>

        </section>




    </body>
</html>