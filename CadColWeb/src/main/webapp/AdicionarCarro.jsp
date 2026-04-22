<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Carro</title>
</head>

<body>

    <form action="AdicionarCarroServlet" method="post" onsubmit="return validar()">

        <!-- Título -->
        <h2 align="center">Cadastro de Carro</h2>
        <br><br><br>

        <!-- Formulário -->
        <div style="text-align: center;">

            <label>CPF do Colecionador:</label><br>
            <input type="text" name="cpf" maxlength="11">
            <br><br>

            <label>Apelido:</label><br>
            <input type="text" name="apelido">
            <br><br>

            <label>Ano de Fabricação:</label><br>
            <input type="text" name="anoFab" maxlength="4">
            <br><br>

            <label>Placa:</label><br>
            <input type="text" name="placa" maxlength="15">
            <br><br>

            <!-- Botões -->
            <button type="submit"
                style="width: 173px; height: 30px; font-size: 15px">
                Adicionar
            </button>

            <br><br>

            <button type="button"
                onclick="location.href='Carro.jsp'"
                style="width: 173px; height: 30px; font-size: 15px">
                Cancelar
            </button>

        </div>

    </form>

    <script>
        function validar() {
            let cpf = document.getElementsByName("cpf")[0].value.trim();
            let apelido = document.getElementsByName("apelido")[0].value.trim();
            let anoFab = document.getElementsByName("anoFab")[0].value.trim();
            let placa = document.getElementsByName("placa")[0].value.trim();

            if (cpf === "") {
                alert("CPF é obrigatório!");
                return false;
            }

            if (apelido === "") {
                alert("Apelido é obrigatório!");
                return false;
            }

            if (anoFab === "") {
                alert("Ano de Fabricação é obrigatório!");
                return false;
            }

            if (placa === "") {
                alert("Placa é obrigatória!");
                return false;
            }

            return true;
        }
    </script>

</body>
</html>