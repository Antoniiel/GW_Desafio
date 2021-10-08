<%-- 
    Document   : form
    Created on : 29 de set de 2021, 12:36:14
    Author     : gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="form.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="box">
                 
               <c:if test="${trans != null}">
                    <form id="formulario" name="formulario" action="TransportadoraControler?action=update" method="post">
                    </c:if>
                    <c:if test="${trans == null}">
                        <form  id="formulario" name="formulario" action="TransportadoraControler?action=insert" method="post">
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${trans != null}">
                                    <a href="TransportadoraControler?action=list">Voltar</a>
                                    Editar transportadora
                                </c:if>
                                <c:if test="${trans == null}">
                                    <a href="TransportadoraControler?action=list">Voltar</a>
                                    Cadastrar nova transportadora
                                </c:if>
                            </h2>
                        </caption>
                        <c:if test="${trans != null}">
                            <input type="hidden" name="id" value="<c:out value='${trans.id}' />" />
                        </c:if>

                        <label id="lname">E-mail:</label>
                        <input type="text" id="fname" name="email" value="<c:out value="${trans.email}"/>" ><br>
                        <label id="lname">Nome:</label>
                        <input type="text" id="iname" name="nome" value="<c:out value="${trans.nome}"/>"><br>
                        <label id="lname">Empresa:</label>
                        <input type="text" id="iname" name="empresa" value="<c:out value="${trans.empresa}"/>" ><br>
                        <label id="lname">Telefone:</label>
                        <input type="text" id="iname" name="telefone" value="<c:out value="${trans.telefone}"/>" ><br>
                        <label id="lname">Celular:</label>
                        <input type="text" id="iname" name="celular" value="<c:out value="${trans.celular}"/>"><br>
                        <label id="lname">Whatsapp:</label>
                        <input type="text" id="iname" name="whatsapp" value="<c:out value="${trans.whatsapp}"/>"><br>
                        <label id="lname">Modal:</label>                        
                        <select name="modal" value="<c:out value="${trans.modal}"/>">
                            <option >Selecione</option>
                            <option value="Rodoviario" >Rodoviário</option>
                            <option value="Aquaviario">Aquaviário</option>
                            <option value="Aereo">Aéreo</option>
                        </select>
                        <label id="lname">cep</label>
                        <input type="text" id="lname" name="cep" value="<c:out value="${trans.cep}"/>" ><br>
                        <label id="lname">Estado:</label>                       
                        <select name="estado" value="<c:out value="${trans.estado}"/>">
                            <option>Selecione</option>
                            <option>PE</option>
                        </select>
                        <label id="lname">Cidade:</label>
                        <input type="text" id="lname" name="cidade" value="<c:out value="${trans.cidade}"/>" ><br>
                        <label id="lname">Bairro:</label>
                        <input type="text" id="lname" name="bairro" value="<c:out value="${trans.bairro}"/>" ><br>
                        <label id="lname">Rua / Avenida:</label>
                        <input type="text" id="lname" name="rua" value="<c:out value="${trans.rua}"/>" ><br>
                        <label id="lname">Número:</label>
                        <input type="text" id="lname" name="numero" value="<c:out value="${trans.numero}"/>"><br>
                        <input type="checkbox" name="terms" id="terms" >
                        <label for="terms" id="terms">Eu aceito os termos de serviço</label><br>


                        <c:if test="${trans != null}">
                                

                            <input class="botaocadastro" type="submit" value="Atualizar">                            
                            <a href="TransportadoraControler?action=delete&id=<c:out value="${trans.id}"/>"> 
                                <input class="botaocadastro"  type="button" value="Deletar">
                            </a>

                        </c:if>
                        <c:if test="${trans == null}">
                            <input class="botaocadastro" id="cadastrar" name="cadastrar" type="submit" value="Cadastrar-se agora!" ">
                                                          
                                                              
                        </c:if>
                    </form>
                         <script>
                                                         
                             function Validar(){
                                 let campo = document.getElementById("terms");
                                if(campo.checked){                                    
                                    ("formulario").submit();                          
                                }else{
                                    alert('Voce precisa aceitar os termos');
                                }
                                    
                             }
                             </script>
            </div>
        </div>
    </body>
</html>
