<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>MANIPULAÇÃO DE CONTAS A RECEBER</title>
	</head>
	<body>
		<div align="center">
	 		<h1>MANIPULAÇÃO DE CONTAS A RECEBER</h1>
	 	</div>
	 	<div align="center">
	 		<h2>
	 			<a href="listContaReceber">CONTAS A RECEBER</a>
	 		</h2>
	 	</div>
	 	<div align="center">
	 		<c:if test="${contareceber != null}">
	 			<form action="updateContaReceber" method="post">
	        </c:if>
	        <c:if test="${contareceber == null}">
	  			<form action="insertContaReceber" method="post">
	        </c:if>
	        	<table border="1" cellpadding="5">
	        		<caption>
	             		<h2>
	              			<c:if test="${contareceber != null}">
	               				EDIÇÃO DE CONTA A RECEBER
	              			</c:if>
	              			<c:if test="${contareceber == null}">
	               				NOVO DE CONTA A RECEBER
	              			</c:if>
	             		</h2>
	            	</caption>
	          		<c:if test="${contareceber != null}">
	           			<input type="hidden" name="codigo" value="<c:out value='${contareceber.codigo}' />" />
	          		</c:if>            
	            	<tr>
	            		<th>EMISSÃO: </th>
	                	<td>
	                 		<input type="date" name="emissao" value="<c:out value='${contareceber.emissao}' />" />
	                	</td>
	           		</tr>
	            	<tr>
	            		<th>VENCIMENTO: </th>
	                	<td>
	                		<input type="date" name="vencimento" value="<c:out value='${contareceber.vencimento}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>PAGAMENTO: </th>
	                	<td>
	                		<input type="date" name="pagamento" value="<c:out value='${contareceber.pagamento}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>VALOR: </th>
	                	<td>
	                		<input type="number" name="valor" value="<c:out value='${contareceber.valor}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<td colspan="2" align="center">
	              			<input type="submit" value="Save" />
	             		</td>
	            	</tr>
	        	</table>
	        </form>
	    </div> 
	</body>
</html>