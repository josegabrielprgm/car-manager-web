<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciar Carros</title>
</head>
<body>

	<form action="CarroServlet" method="get">

		<!-- Título -->
		<section>
			<h1 align="center">Gerenciamento de Carros</h1>
			<br> <br> <br>
		</section>

		<!-- Pesquisa -->
		<section>
			<fieldset>
				<legend>Pesquisar Carro</legend>

				<label for="placa">Placa:</label> <input type="text" id="placa"
					name="placa" placeholder="Digite a placa..." maxlength="14">

				<button type="submit">Pesquisar</button>

				<button type="button" onclick="location.href='AdicionarCarro.jsp'">
					Adicionar</button>

				<button type="button" onclick="location.href='MenuPrincipal.jsp'">
					Voltar ao Menu Principal</button>
				<br> <br>
			</fieldset>
		</section>
	</form>

	<!-- Lista -->
	<h2>Lista de Carros</h2>

	<table border="1" style="border-collapse: collapse; width: 100%">
		<thead>
			<tr>
				<th style="padding: 10px">Id</th>
				<th style="padding: 10px">CPF do Colecionador</th>
				<th style="padding: 10px">Apelido</th>
				<th style="padding: 10px">Ano de Fabricação</th>
				<th style="padding: 10px">Placa</th>
				<th style="padding: 10px">Editar</th>
				<th style="padding: 10px">Excluir</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="carro" items="${lista}">
				<tr>
					<td>${carro.id}</td>
					<td>${carro.cpf}</td>
					<td>${carro.apelido}</td>
					<td>${carro.anoFab}</td>
					<td>${carro.placa}</td>

					<td>
						<form action="AlterarCarroServlet" method="get">
							<input type="hidden" name="id" value="${carro.id}">
							<button type="submit" style="width: 100%; padding: 10px;">
								Editar</button>
						</form>
					</td>

					<td>
						<form action="ApagarCarroServlet" method="post">
							<input type="hidden" name="id" value="${carro.id}">
							<button type="submit" style="width: 100%; padding: 10px;">
								Apagar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>