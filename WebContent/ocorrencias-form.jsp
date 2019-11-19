<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>MANIPULAÇÃO DE OCORRENCIAS</title>
	</head>
	<body>
		<div align="center">
	 		<h1>MANIPULAÇÃO DE OCORRENCIAS</h1>
	 	</div>
	 	<div align="center">
	 		<h2>
	 			<a href="listOcorrencias">LISTA DE OCORRENCIAS</a>
	 		</h2>
	 	</div>
	 	<div align="center">
	 		<c:if test="${ocorrencias != null}">
	 			<form action="updateOcorrencias" method="post">
	        </c:if>
	        <c:if test="${ocorrencias == null}">
	  			<form action="insertOcorrencias" method="post">
	        </c:if>
	        	<table border="1" cellpadding="5">
	        		<caption>
	             		<h2>
	              			<c:if test="${ocorrencias != null}">
	               				EDIÇÃO DE OCORRENCIA
	              			</c:if>
	              			<c:if test="${ocorrencias == null}">
	               				NOVO OCORRENCIA
	              			</c:if>
	             		</h2>
	            	</caption>
	          		<c:if test="${ocorrencias != null}">
	           			<input type="hidden" name="codigo" value="<c:out value='${ocorrencias.codigo}' />" />
	          		</c:if>            
	            	<tr>
	            		<th>DATA: </th>
	                	<td>
	                 		<input type="date" name="data" size="45" value="<c:out value='${ocorrencias.data}' />" />
	                	</td>
	           		</tr>
	            	<tr>
	            		<th>NOME DE USUARIO: </th>
	                	<td>
	                		<input type="text" name="nomeUsuario" size="45" value="<c:out value='${ocorrencias.nomeUsuario}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>DESCRIÇÃO: </th>
	                	<td>
	                		<input type="text" name="descricao" size="15" value="<c:out value='${ocorrencias.descricao}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>MOTIVO: </th>
	                	<td>
	                		<input type="text" name="motivo" size="15" value="<c:out value='${ocorrencias.motivo}' />" />
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