<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Configurações</title>
	</head>
	<body>
		<div align="center">
			<h1>Configurações</h1>
	        <h2>
	        	<a href="newConfiguracao">NOVO CONFIGURAÇÃO</a><br>
	        	<a href="index.jsp">VOLTAR</a>
	        </h2>
		</div>
	    <div align="center">
	        <table border="1">
	            <caption><h2>Lista de Configurações</h2></caption>
	            <tr>
	                <th>CODIGO</th>
	                <th>MENSAGEM1</th>
	                <th>MENSAGEM2</th>
	                <th>MENSAGEM3</th>
	                <th>MENSAGEM4</th>
	            </tr>
	            <c:forEach var="configuracao" items="${listConfiguracoes}">
	                <tr>
	                    <td><c:out value="${configuracao.codigo}" /></td>
	                    <td><c:out value="${configuracao.mensagem1}" /></td>
	                    <td><c:out value="${configuracao.mensagem2}" /></td>
	                    <td><c:out value="${configuracao.mensagem3}" /></td>
	                    <td><c:out value="${configuracao.mensagem4}" /></td>
	                    <td>
	                    	<a href="editConfiguracao?codigo=<c:out value='${configuracao.codigo}' />">EDITAR</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="deleteConfiguracao?codigo=<c:out value='${configuracao.codigo}' />">DELETAR</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	
	</body>
</html>