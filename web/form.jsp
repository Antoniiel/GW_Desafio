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
        <script src="app.js"></script>        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
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
                        <input type="email" id="email" required="required" name="email" value="<c:out value="${trans.email}"/>" ><br>
                        <label id="lname">Nome:</label>
                        <input type="text" id="email" required="required" name="nome" value="<c:out value="${trans.nome}"/>"><br>
                        <label id="lname">Empresa:</label>
                        <input type="text" id="empresa" required="required" name="empresa" value="<c:out value="${trans.empresa}"/>" ><br>
                        <label id="lname">Telefone:</label>
                        <input type="text" id="telefone" required="required" name="telefone" value="<c:out value="${trans.telefone}"/>" ><br>
                        <label id="lname">Celular:</label>
                        <input type="text" id="celular" required="required" name="celular" value="<c:out value="${trans.celular}"/>"><br>
                        <label id="lname">Whatsapp:</label>
                        <input type="text" id="whatsapp" required="required" name="whatsapp" value="<c:out value="${trans.whatsapp}"/>"><br>
                        <label id="lname">Modal:</label>                        
                        <select name="modal" value="<c:out value="${trans.modal}"/>">
                            <option >Selecione</option>
                            <option value="Rodoviario" >Rodoviário</option>
                            <option value="Aquaviario">Aquaviário</option>
                            <option value="Aereo">Aéreo</option>
                        </select>
                        <label id="icep">cep</label>
                        <input type="text" id="cep" required="required" name="cep" value="<c:out value="${trans.cep}"/>" ><br>
                        <label id="lname">Estado:</label>                       
                        <input type="text" id="estado" required="required" name="estado" value="<c:out value="${trans.estado}"/>" ><br>                        
                        <label id="lname">Cidade:</label>
                        <input type="text" id="cidade" required="required" name="cidade" value="<c:out value="${trans.cidade}"/>" ><br>
                        <label id="lname">Bairro:</label>
                        <input type="text" id="bairro" required="required" name="bairro" value="<c:out value="${trans.bairro}"/>" ><br>
                        <label id="lname">Rua / Avenida:</label>
                        <input type="text" id="rua" required="required" name="rua" value="<c:out value="${trans.rua}"/>" ><br>
                        <label id="lname">Número:</label>
                        <input type="text" id="numero" required="required" name="numero" value="<c:out value="${trans.numero}"/>"><br>
                       
                        



                        <c:if test="${trans != null}">
                            <input class="botaocadastro" type="submit" value="Atualizar">                            
                            <a id="deletar" href="TransportadoraControler?action=delete&id=<c:out value="${trans.id}"/>">
                                <input class="botaocadastro"  id="deletar" type="button" onclick="Teste()" value="Deletar">
                            </a>

                        </c:if>
                        <c:if test="${trans == null}">
                             <input type="checkbox" name="terms" id="terms" >
                            <label for="terms" id="terms">Eu aceito os termos de serviço</label><br>
                            <input class="botaocadastro" onclick="check()" id="cadastrar" name="cadastrar" type="submit" value="Cadastrar-se agora!" ">
                        </c:if>
                    </form>                            

                    <script>
                        function Teste(){
                          var resultado = confirm("Excluir transportadora?");
                          if(resultado == true){                                                       
                             Alert("Transportadora excluida");
                          }else{
                              document.getElementById('deletar').href="";     
                              alert("Operação cancelada");
                          }
                        }
                        
                        function check(){
                            let checkbox = document.getElementbyId("terms");
                            chebox.checked = true;
                            if(checkbox == false){
                                document.getElementById('cadastrar'.type="");
                                Alert("Você precisa aceitar os termos");
                            }
                        }



                        $(document).ready(function () {

                            function limpa_formulário_cep() {
                                // Limpa valores do formulário de cep.
                                $("#rua").val("");
                                $("#bairro").val("");
                                $("#cidade").val("");
                                $("#estado").val("");
                            }

                            //Quando o campo cep perde o foco.
                            $("#cep").blur(function () {

                                //Nova variável "cep" somente com dígitos.
                                var cep = $(this).val().replace(/\D/g, '');

                                //Verifica se campo cep possui valor informado.
                                if (cep != "") {

                                    //Expressão regular para validar o CEP.
                                    var validacep = /^[0-9]{8}$/;

                                    //Valida o formato do CEP.
                                    if (validacep.test(cep)) {

                                        //Preenche os campos com "..." enquanto consulta webservice.
                                        $("#rua").val("...");
                                        $("#bairro").val("...");
                                        $("#cidade").val("...");
                                        $("#estado").val("...");

                                        //Consulta o webservice viacep.com.br/
                                        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                                            if (!("erro" in dados)) {
                                                //Atualiza os campos com os valores da consulta.
                                                $("#rua").val(dados.logradouro);
                                                $("#bairro").val(dados.bairro);
                                                $("#cidade").val(dados.localidade);
                                                $("#estado").val(dados.uf);

                                                console.log(dados)
                                            } //end if.
                                            else {
                                                //CEP pesquisado não foi encontrado.
                                                limpa_formulário_cep();
                                                alert("CEP não encontrado.");
                                            }
                                        });
                                    } //end if.
                                    else {
                                        //cep é inválido.
                                        limpa_formulário_cep();
                                        alert("Formato de CEP inválido.");
                                    }
                                } //end if.
                                else {
                                    //cep sem valor, limpa formulário.
                                    limpa_formulário_cep();
                                }
                            });
                        });


                        function Validar() {
                            let campo = document.getElementById("terms");
                            if (campo.checked) {
                                ("formulario").submit();
                            } else {
                                alert('Voce precisa aceitar os termos');
                            }

                        }
                    </script>
            </div>
        </div>
    </body>
</html>
