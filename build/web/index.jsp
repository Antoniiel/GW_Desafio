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

                <button class="botaocadastro" onclick="location.href='TransportadoraControler?action=new'" >Cadastre sua transportadora</button>
                
                
            </div>
        </header>       
       

        <section class="container">
            <div id="conteudo">

                <h1>Menu </h1>



                <div id="menu">
                    <ul>
                        <li><a href="link1.htm">link1</a></li>
                        <li><a href="link2.htm">link2</a></li>
                        <li><a href="link3.htm">link3</a></li>
                        <li><a href="link4.htm">link4</a></li>
                        <li><a href="link5.htm">link5</a></li>
                    </ul>
                </div>
            </div>


            <div class="conteudo-principal">
                <table class="tabela">          
                    <c:forEach var="trans" items="${ListarTrasnportadoras}">
                        
                            <tr>
                                <td class="espacamentotabela"><a href=""><c:out value="${trans.nome}"/></a></td> 
                                <td class="espacamentotabela"><c:out value="${trans.telefone}"/></td> 
                                <td class="espacamentotabela">Fale agora: <c:out value="${trans.whatsapp}"/></td> 
                                <td class="espacamentotabela"><c:out value="${trans.id}"/></td> 
                                <td><a href="action=delete?id=<c:out value="${trans.id}"/>"> deletar </a></td>
                                
                            </tr> 

                            <tr> 
                                <td class="espacamentotabela2"><c:out value="${trans.empresa}"/></td> 

                                <td class="espacamentotabela2"><c:out value="${trans.email}"/></td> 
                            </tr>                             
                        </div>


                            </c:forEach>
                            </table>

                        

                        </section>



                        </body>
                        </html>