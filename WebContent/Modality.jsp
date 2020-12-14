ModalityDao<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Modalide</title>
</head>
<body>
	<div align="center">
		<form method="post" action="ModalityServlet">
			<fieldset>
				<legend>Cadastro de Modalides</legend>
				<label>Name:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${modality.nome}"/><br />
 
			<br /> <label>Ação</label> <select
					name="acao" required>
					<option selected value="Incluir">Incluir</option>
					<option value="Alterar">Alterar</option>
					<option value="Excluir">Excluir</option>
					<option value="Consultar">Consultar</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>