<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Clientes</title>
	</head>
	<body>
		<div align="center">
			<h1>Clientes</h1>
	        <h2>
	        	<a href="newCliente">NOVO CLIENTE</a><br>
	        	<a href="index.jsp">VOLTAR</a>
	        </h2>
		</div>
	    <div align="center">
	        <table border="1">
	            <caption><h2>Lista de Clientes</h2></caption>
	            <tr>
	                <th>CODIGO</th>
	                <th>RAZAO</th>
	                <th>FANTASIA</th>
	                <th>CNPJ</th>
	                <th>IE</th>
	            </tr>
	            <c:forEach var="cliente" items="${listCliente}">
	                <tr>
	                    <td><c:out value="${cliente.codigo}" /></td>
	                    <td><c:out value="${cliente.razao}" /></td>
	                    <td><c:out value="${cliente.fantasia}" /></td>
	                    <td><c:out value="${cliente.cnpj}" /></td>
	                    <td><c:out value="${cliente.ie}" /></td>
	                    <td>
	                    	<a href="editCliente?codigo=<c:out value='${cliente.codigo}' />">EDITAR</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="deleteCliente?codigo=<c:out value='${cliente.codigo}' />">DELETAR</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	
	</body>
</html>