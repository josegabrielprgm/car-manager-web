<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Colecionador</title>
</head>

<body>

    <form action="AlterarColecionadorServlet" method="post" onsubmit="return validar()">

        <!-- Título -->
        <h2 align="center">Alteração de Colecionador</h2>
        <br><br><br>

        <!-- Formulário -->
        <div style="text-align: center;">

            <label>CPF:</label><br>
            <input type="text" name="cpf" value="${colecionador.cpf}" readonly>
            <br><br>

            <label>Nome:</label><br>
            <input type="text" name="nome" value="${colecionador.nome}">
            <br><br>

            <label>Idade:</label><br>
            <input type="text" name="idade" maxlength="3"
                   value="${colecionador.idade}">
            <br><br>

            <label>Telefone:</label><br>
            <input type="tel" name="telefone" maxlength="15"
                   value="${colecionador.telefone}">
            <br><br>

<script >

	function validar() {
		
		let cpf = document.getElementsByName("cpf")[0].value.trim();
		let nome = document.getElementsByName("nome")[0].value.trim();
		let idade = document.getElementsByName("idade")[0].value.trim();
		let telefone = document.getElementsByName("telefone")[0].value.trim();
		
		if (cpf === "") {
			alert("CPF é obrigatório!");
			return false;
		}
		if (nome === "") {
			alert("nome é obrigatório!");
			return false;
		}
		if (idade === "") {
			alert("Idade é obrigatório!");
			return false;
		}		
		if (telefone === "") {
			alert("Telefone é obrigatório!");
			return false;
		}
		return true;
			
	}
	
</script>

            <!-- Botões -->
            <button type="submit"
                style="width: 173px; height: 30px; font-size: 15px">
                Salvar Alteração
            </button>

            <br><br>

            <button type="button"
                onclick="location.href='Colecionador.jsp'"
                style="width: 173px; height: 30px; font-size: 15px">
                Cancelar
            </button>

        </div>

    </form>

</body>
</html>