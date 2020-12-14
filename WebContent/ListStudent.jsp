<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head>
<body>
	<div align="center">
		<P>Lista de Alunos</P>
		<table border="1">
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>${student.matricula}</td>
					<td>${student.nome}</td>
					<td>${student.telefone}</td>
					<td><a href="StudentServlet?acao=Excluir&matricula=${student.matricula}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(studentList) > 0}">
   		Existem ${fn:length(studentList)} alunos!
 		</c:if><br> 		
	</div>
	<a href="index.jsp">Voltar</a>
 
</body>
</html>