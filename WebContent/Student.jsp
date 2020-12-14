StudentDao<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Aluno</title>
</head>
<body>
	<div align="center">
		<form method="post" action="StudentServlet">
			<fieldset>
				<legend>Cadastro de Alunos</legend>
				<label>Matrícula: </label><input name="matricula" required
				    value="${student.matricula}"
					placeholder="2236541" /><br /> 
				<label>Name:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${student.nome}"/><br />
 
				 <label>Telefone:</label><input
					type="tel" name="telefone" placeholder="9999-9999" value="${student.telefone}" /><br />
				 <label>Email:</label><input
					type="email" name="email" placeholder="seuemail@dominio.com.br"  value="${student.email}"/><br />	
					placeholder="10/10/2014" /><br /> <label>Ação</label> <select
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