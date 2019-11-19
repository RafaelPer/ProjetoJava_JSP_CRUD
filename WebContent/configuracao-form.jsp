<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>MANIPULAÇÃO DE CONFIGURACAO</title>
	</head>
	<body>
		<div align="center">
	 		<h1>MANIPULAÇÃO DE CONFIGURACAO</h1>
	 	</div>
	 	<div align="center">
	 		<h2>
	 			<a href="listConfiguracao">LISTA DE CONFIGURACÕES</a>
	 		</h2>
	 	</div>
	 	<div align="center">
	 		<c:if test="${configuracao != null}">
	 			<form action="updateConfiguracao" method="post">
	        </c:if>
	        <c:if test="${configuracao == null}">
	  			<form action="insertConfiguracao" method="post">
	        </c:if>
	        	<table border="1" cellpadding="5">
	        		<caption>
	             		<h2>
	              			<c:if test="${configuracao != null}">
	               				EDIÇÃO DE CONFIGURAÇÃO
	              			</c:if>
	              			<c:if test="${configuracao == null}">
	               				NOVO CONFIGURAÇÃO
	              			</c:if>
	             		</h2>
	            	</caption>
	          		<c:if test="${configuracao != null}">
	           			<input type="hidden" name="codigo" value="<c:out value='${configuracao.codigo}' />" />
	          		</c:if>            
	            	<tr>
	            		<th>MENSAGEM 1: </th>
	                	<td>
	                 		<input type="text" name="mensagem1" size="255" value="<c:out value='${configuracao.mensagem1}' />" />
	                	</td>
	           		</tr>
	            	<tr>
	            		<th>MENSAGEM 2: </th>
	                	<td>
	                		<input type="text" name="mensagem2" size="255" value="<c:out value='${configuracao.mensagem2}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>MENSAGEM 3: </th>
	                	<td>
	                		<input type="text" name="mensagem3" size="255" value="<c:out value='${configuracao.mensagem3}' />" />
	                	</td>
	            	</tr>
	            	<tr>
	            		<th>MENSAGEM 4: </th>
	                	<td>
	                		<input type="text" name="mensagem4" size="255" value="<c:out value='${configuracao.mensagem4}' />" />
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