<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>MANIPULAÇÃO DE PROTOCOLOS</title>
	</head>
	<body>
		<div align="center">
	 		<h1>MANIPULAÇÃO DE PROTOCOLOS</h1>
	 	</div>
	 	<div align="center">
	 		<h2>
	 			<a href="listProtocolos">LISTA DE PROTOCOLOS</a>
	 		</h2>
	 	</div>
	 	<div align="center">
	 		<c:if test="${protocolo != null}">
	 			<form action="updateProtocolo" method="post">
	        </c:if>
	        <c:if test="${protocolo == null}">
	  			<form action="insertProtocolo" method="post">
	        </c:if>
	        	<table border="1" cellpadding="5">
	        		<caption>
	             		<h2>
	              			<c:if test="${protocolo != null}">
	               				EDIÇÃO DE PROTOCOLO
	              			</c:if>
	              			<c:if test="${protocolo == null}">
	               				NOVO PROTOCOLO
	              			</c:if>
	             		</h2>
	            	</caption>
	          		<c:if test="${protocolo != null}">
	           			<input type="hidden" name="codigo" value="<c:out value='${protocolo.codigo}' />" />
	          		</c:if>            
	            	<tr>
	            		<th>PROBLEMA: </th>
	                	<td>
	                 		<input type="text" name="problema" size="45" value="<c:out value='${protocolo.problema}' />" />
	                	</td>
	           		</tr>
	            	<tr>
	            		<th>RESOLUÇÃO: </th>
	                	<td>
	                		<input type="text" name="resolucao" size="45" value="<c:out value='${protocolo.resolucao}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>DATA DE ABERTURA: </th>
	                	<td>
	                		<input type="date" name="dataAbertura" size="15" value="<c:out value='${protocolo.dataAbertura}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>DATA DE FECHAMENTO: </th>
	                	<td>
	                		<input type="date" name="dataFechamento" size="15" value="<c:out value='${protocolo.dataFechamento}' />" />
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