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
                        <form  id="formularioInsert" name="formulario" action="TransportadoraControler?action=insert" method="post">
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${trans != null}">
                                    <div id="cabecalho-form">
                                        <a href="TransportadoraControler?action=list">Voltar</a>
                                        <h4>Editar transportadora</h4>
                                    </div>
                                </c:if>
                                <c:if test="${trans == null}">
                                    <div id="cabecalho-form">
                                        <a href="TransportadoraControler?action=list">Voltar</a>
                                        <h4>Cadastrar nova transportadora</h4>
                                    </div>
                                </c:if>
                            </h2>
                        </caption>
                        <c:if test="${trans != null}">
                            <input type="hidden" name="id" value="<c:out value='${trans.id}' />" />
                        </c:if>

                        <label id="lname">E-mail:</label>
                        <input type="email" id="campo-cadastro" required="required" name="email" value="<c:out value="${trans.email}"/>" ><br>
                        <label id="lname">Nome:</label>
                        <input type="text" id="campo-cadastro" required="required" name="nome" value="<c:out value="${trans.nome}"/>"><br>
                        <label id="lname">CNPJ:</label>
                        <input type="text" id="campo-cadastro" required="required" name="empresa" value="<c:out value="${trans.empresa}"/>" ><br>
                        <label id="lname">Telefone:</label>
                        <input type="text" id="campo-cadastro" required="required" onkeypress="mask(this, mphone);" onblur="mask(this, mphone);" name="telefone" value="<c:out value="${trans.telefone}"/>" ><br>
                        <label id="lname">Celular:</label>
                        <input type="text" id="campo-cadastro" required="required" name="celular" onkeypress="mask(this, mphone);" onblur="mask(this, mphone);" value="<c:out value="${trans.celular}"/>"><br>
                        <label id="lname">Whatsapp:</label>
                        <input type="text" id="campo-cadastro" required="required" name="whatsapp" onkeypress="mask(this, mphone);" onblur="mask(this, mphone);" value="<c:out value="${trans.whatsapp}"/>"><br>
                        <label id="id-modal">Modal:</label>                        
                        <select id="id-modal" name="modal" required value="<c:out value="${trans.modal}"/>">
                            <option  value="">Selecione</option>
                            <option value="Rodoviario" >Rodovi??rio</option>
                            <option value="Aquaviario">Aquavi??rio</option>
                            <option value="Aereo">A??reo</option>
                        </select><br>
                        <label id="lanem">Cep:</label>
                        <input type="text" id="cep" required="required" name="cep" value="<c:out value="${trans.cep}"/>" ><br>
                        <label id="lname">Estado:</label>                       
                        <input type="text" id="estado" required="required" name="estado" value="<c:out value="${trans.estado}"/>" ><br>                        
                        <label id="lname">Cidade:</label>
                        <input type="text" id="cidade" required="required" name="cidade" value="<c:out value="${trans.cidade}"/>" ><br>
                        <label id="lname">Bairro:</label>
                        <input type="text" id="bairro" required="required" name="bairro" value="<c:out value="${trans.bairro}"/>" ><br>
                        <label id="lname">Rua / Avenida:</label>
                        <input type="text" id="rua" required="required" name="rua" value="<c:out value="${trans.rua}"/>" ><br>
                        <label id="lname">N??mero:</label>
                        <input type="text" id="campo-cadastro" required="required" name="numero" value="<c:out value="${trans.numero}"/>"><br>

                        <c:if test="${trans != null}">
                            <div id="agrupamento-botoes">
                                <input class="botaocadastro" id="botaoEdit" type="submit" value="Atualizar">                            
                                <a id="deletar" href="TransportadoraControler?action=delete&id=<c:out value="${trans.id}"/>">
                                    <input class="botaocadastro"  id="botaoEdit" type="button" onclick="VerificaDelete()" value="Deletar">
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${trans == null}">
                            <input type="checkbox" name="terms" id="terms" >
                            <label for="terms" id="terms">Eu aceito os termos de servi??o</label><br>
                            <input class="termos" onclick="Validar()" id="botaoPadrao" name="cadastrar" type="Button" value="Cadastrar-se agora!" ">
                        </c:if>
                    </form>                            

                    <script>
                        function VerificaDelete() {
                            var resultado = confirm("Excluir transportadora?");
                            if (resultado == true) {
                                Alert("Transportadora excluida");
                            } else {
                                document.getElementById('deletar').href = "";
                                alert("Opera????o cancelada");
                            }
                        }

                        function Validar() {
                            let campo = document.getElementById("terms");
                            if (campo.checked) {
                                document.getElementById("formularioInsert").submit();
                            } else {
                                alert('Voce precisa aceitar os termos');
                            }

                        }

                        function check() {
                            let checkbox = document.getElementbyId("terms");
                            if (checkbox.checked) {
                                alert('teste')


                            }
                        }

                        function mask(o, f) {
                            setTimeout(function () {
                                var v = mphone(o.value);
                                if (v != o.value) {
                                    o.value = v;
                                }
                            }, 1);
                        }

                        function mphone(v) {
                            var r = v.replace(/\D/g, "");
                            r = r.replace(/^0/, "");
                            if (r.length > 10) {
                                r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
                            } else if (r.length > 5) {
                                r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
                            } else if (r.length > 2) {
                                r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
                            } else {
                                r = r.replace(/^(\d*)/, "($1");
                            }
                            return r;
                        }

                        $(document).ready(function () {

                            function limpa_formul??rio_cep() {
                                // Limpa valores do formul??rio de cep.
                                $("#rua").val("");
                                $("#bairro").val("");
                                $("#cidade").val("");
                                $("#estado").val("");
                            }

                            //Quando o campo cep perde o foco.
                            $("#cep").blur(function () {

                                //Nova vari??vel "cep" somente com d??gitos.
                                var cep = $(this).val().replace(/\D/g, '');

                                //Verifica se campo cep possui valor informado.
                                if (cep != "") {

                                    //Express??o regular para validar o CEP.
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
                                                //CEP pesquisado n??o foi encontrado.
                                                limpa_formul??rio_cep();
                                                alert("CEP n??o encontrado.");
                                            }
                                        });
                                    } //end if.
                                    else {
                                        //cep ?? inv??lido.
                                        limpa_formul??rio_cep();
                                        alert("Formato de CEP inv??lido.");
                                    }
                                } //end if.
                                else {
                                    //cep sem valor, limpa formul??rio.
                                    limpa_formul??rio_cep();
                                }
                            });
                        });



                    </script>
            </div>
        </div>
    </body>
</html>
