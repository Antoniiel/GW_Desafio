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

                <h2 class="tituloheader">
                    <a class="tituloheader" href="TransportadoraControler?action=list">Transportadoras</a>
                </h2>

                <button class="botaocadastro" onclick="location.href = 'TransportadoraControler?action=new'" >Cadastre sua transportadora</button>


            </div>
        </header>       


        <section class="container">
            <div id="conteudo">

                <h1>Transportadoras</h1>

                <div id="busca">
                    <h3>Nome</h3>
                    <form id="buscanome" name="buscanome" action="TransportadoraControler?action=buscaNome" method="post">
                        <label id="lname">Nome</label>
                        <input type="text" id="nome" name="nome" required="required"  >
                        <input type="submit" value="buscar" >
                    </form>

                </div>

                <div id="busca">
                    <h3>Localização (UFs)</h3>
                    <c:forEach var="trans" items="${ListarTrasnportadoras}">

                        <ul class="lista">
                            <li class="item-lista"><c:out value="${trans.estado}"/></li>
                        </ul>                                                 


                    </c:forEach>
                </div>

                <div id="busca">
                    <h3>Localização (Municipios)</h3>
                    <c:forEach var="trans" items="${ListarTrasnportadoras}">

                        <ul class="lista">
                            <li class="item-lista"><c:out value="${trans.cidade}"/></li>
                        </ul>                                                 


                    </c:forEach>
                </div>

                <div id="busca">

                    <div id="busca">
                        <h3>Modal</h3>
                        <c:forEach var="trans" items="${ListarTrasnportadoras}">

                            <ul class="lista">
                                <li class="item-lista"><c:out value="${trans.modal}"/></li>
                            </ul>                                                 


                        </c:forEach>
                    </div>
                </div>


            </div>


            <div class="conteudo-principal">
                <table class="tabela">     
                    <c:forEach var="trans" items="${ListarTrasnportadoras}">
                        <section class="conteudo-item">
                            <tr>
                                <td class="espacamentotabela"><a href="TransportadoraControler?action=edit&id=<c:out value="${trans.id}"/>"><c:out value="${trans.nome}"/></a></td> 
                                <td class="espacamentotabela"><c:out value="${trans.telefone}"/></td> 
                                <td class="espacamentotabela">Fale agora: <c:out value="${trans.whatsapp}"/></td> 
                            </tr> 
                            <tr> 
                                <td class="espacamentotabela2"><c:out value="${trans.empresa}"/></td> 

                                <td class="espacamentotabela2"><c:out value="${trans.email}"/></td> 
                            </tr>                
                        </section>
                    </c:forEach>


            </div>

        </table>



    </section>



</body>
</html>