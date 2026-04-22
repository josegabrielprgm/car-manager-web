<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Carro</title>
</head>

<body>

    <form action="AlterarCarroServlet" method="post" onsubmit="return validar()">

        <input type="hidden" name="id" value="${carro.id}">
        <br><br>

        <h2 align="center">Alteração de Carro</h2>
        <br><br>

        <div style="text-align: center;">

            <label>CPF do Colecionador:</label><br>
            <input type="text" name="cpf" value="${carro.cpf}" readonly>
            <br><br>

            <label>Apelido:</label><br>
            <input type="text" name="apelido" value="${carro.apelido}">
            <br><br>

            <label>Ano de Fabricação:</label><br>
            <input type="text" name="anoFab" maxlength="4" value="${carro.anoFab}">
            <br><br>

            <label>Placa:</label><br>
            <input type="text" name="placa" maxlength="15" value="${carro.placa}">
            <br><br>

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

            <button type="submit"
                style="width: 173px; height: 30px; font-size: 15px">
                Salvar Alteração
            </button>

            <br><br>

            <button type="button"
                onclick="location.href='Carro.jsp'"
                style="width: 173px; height: 30px; font-size: 15px">
                Cancelar
            </button>

        </div>

    </form>

</body>
</html>