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
		<P>Lista de Modalidades</P>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>Nome</td>
			</tr>
			<c:forEach var="modality" items="${modalityList}">
				<tr>
					<td>${modality.nome}</td>
					<td><a href="ModalityServlet?acao=Excluir&id=${student.modality}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(studentList) > 0}">
   		Existem ${fn:length(modalityList)} alunos!
 		</c:if><br> 		
	</div>
	<a href="index.jsp">Voltar</a>
 
</body>
</html>