<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Ocorrencias</title>
	</head>
	<body>
		<div align="center">
			<h1>Ocorrencias</h1>
	        <h2>
	        	<a href="newOcorrencias">NOVA OCORRENCIA</a><br>
	        	<a href="index.jsp">VOLTAR</a>
	        </h2>
		</div>
	    <div align="center">
	        <table border="1">
	            <caption><h2>Lista de Ocorrencias</h2></caption>
	            <tr>
	                <th>CODIGO</th>
	                <th>DATA</th>
	                <th>NOME DE USUARIO</th>
	                <th>DESCRIÇÃO</th>
	                <th>MOTIVO</th>
	            </tr>
	            <c:forEach var="ocorrencia" items="${listOcorrencias}">
	                <tr>
	                    <td><c:out value="${ocorrencia.codigo}" /></td>
	                    <td><c:out value="${ocorrencia.data}" /></td>
	                    <td><c:out value="${ocorrencia.nomeUsuario}" /></td>
	                    <td><c:out value="${ocorrencia.descricao}" /></td>
	                    <td><c:out value="${ocorrencia.motivo}" /></td>
	                    <td>
	                    	<a href="editOcorrencias?codigo=<c:out value='${ocorrencia.codigo}' />">EDITAR</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="deleteOcorrencias?codigo=<c:out value='${ocorrencia.codigo}' />">DELETAR</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	
	</body>
</html>