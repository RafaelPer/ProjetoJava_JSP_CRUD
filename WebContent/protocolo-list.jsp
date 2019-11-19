<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Protocolos</title>
	</head>
	<body>
		<div align="center">
			<h1>Protocolos</h1>
	        <h2>
	        	<a href="newProtocolo">NOVO PROTOCOLO</a><br>
	        	<a href="index.jsp">VOLTAR</a>
	        </h2>
		</div>
	    <div align="center">
	        <table border="1">
	            <caption><h2>Lista de Protocolos</h2></caption>
	            <tr>
	                <th>CODIGO</th>
	                <th>PROBLEMA</th>
	                <th>RESOLUÇÃO</th>
	                <th>DATA DE ABERTURA</th>
	                <th>DATA DE FECHAMENTO</th>
	            </tr>
	            <c:forEach var="protocolo" items="${listProtocolos}">
	                <tr>
	                    <td><c:out value="${protocolo.codigo}" /></td>
	                    <td><c:out value="${protocolo.problema}" /></td>
	                    <td><c:out value="${protocolo.resolucao}" /></td>
	                    <td><c:out value="${protocolo.dataAbertura}" /></td>
	                    <td><c:out value="${protocolo.dataFechamento}" /></td>
	                    <td>
	                    	<a href="editProtocolo?codigo=<c:out value='${protocolo.codigo}' />">EDITAR</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="deleteProtocolo?codigo=<c:out value='${protocolo.codigo}' />">DELETAR</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	
	</body>
</html>