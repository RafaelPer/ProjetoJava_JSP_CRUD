<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>MANIPULAÇÃO DE CLIENTES</title>
	</head>
	<body>
		<div align="center">
	 		<h1>MANIPULAÇÃO DE CLIENTES</h1>
	 	</div>
	 	<div align="center">
	 		<h2>
	 			<a href="listCliente">LISTA DE CLIENTES</a>
	 		</h2>
	 	</div>
	 	<div align="center">
	 		<c:if test="${cliente != null}">
	 			<form action="updateCliente" method="post">
	        </c:if>
	        <c:if test="${cliente == null}">
	  			<form action="insertCliente" method="post">
	        </c:if>
	        	<table border="1" cellpadding="5">
	        		<caption>
	             		<h2>
	              			<c:if test="${cliente != null}">
	               				EDIÇÃO DE CLIENTE
	              			</c:if>
	              			<c:if test="${cliente == null}">
	               				NOVO CLIENTE
	              			</c:if>
	             		</h2>
	            	</caption>
	          		<c:if test="${cliente != null}">
	           			<input type="hidden" name="codigo" value="<c:out value='${cliente.codigo}' />" />
	          		</c:if>            
	            	<tr>
	            		<th>RAZÃO: </th>
	                	<td>
	                 		<input type="text" name="razao" size="45" value="<c:out value='${cliente.razao}' />" />
	                	</td>
	           		</tr>
	            	<tr>
	            		<th>FANTASIA: </th>
	                	<td>
	                		<input type="text" name="fantasia" size="45" value="<c:out value='${cliente.fantasia}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>CNPJ: </th>
	                	<td>
	                		<input type="text" name="cnpj" size="15" value="<c:out value='${cliente.cnpj}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>IE: </th>
	                	<td>
	                		<input type="text" name="ie" size="15" value="<c:out value='${cliente.ie}' />" />
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