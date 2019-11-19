<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Contas a Receber</title>
	</head>
	<body>
		<div align="center">
			<h1>Contas a Pagar</h1>
	        <h2>
	        	<a href="newContaReceber">NOVA CONTA A PAGAR</a><br>
	        	<a href="index.jsp">VOLTAR</a>
	        </h2>
		</div>
	    <div align="center">
	        <table border="1">
	            <caption><h2>Lista de Contas a Pagar</h2></caption>
	            <tr>
	                <th>CODIGO</th>
	                <th>EMISSÃO</th>
	                <th>VENCIMENTO</th>
	                <th>PAGAMENTO</th>
	                <th>VALOR</th>
	            </tr>
	            <c:forEach var="contareceber" items="${listContasReceber}">
	                <tr>
	                    <td><c:out value="${contareceber.codigo}" /></td>
	                    <td><c:out value="${contareceber.emissao}" /></td>
	                    <td><c:out value="${contareceber.vencimento}" /></td>
	                    <td><c:out value="${contareceber.pagamento}" /></td>
	                    <td><c:out value="${contareceber.valor}" /></td>
	                    <td>
	                    	<a href="editContaReceber?codigo=<c:out value='${contareceber.codigo}' />">EDITAR</a>
	                    	&nbsp;&nbsp;&nbsp;&nbsp;
	                    	<a href="deleteContaReceber?codigo=<c:out value='${contareceber.codigo}' />">DELETAR</a>                    	
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	
	</body>
</html>