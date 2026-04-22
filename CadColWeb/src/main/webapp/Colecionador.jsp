<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciar Colecionadores</title>
</head>

<body>

    <!-- Seção Principal -->
    <section>
        <h1 align="center">Gerenciamento de Colecionadores</h1>
        <br><br><br>
    </section>

    <!-- Formulário de Pesquisa -->
    <form action="ColecionadorServlet" method="get">
        <section>
            <fieldset>
                <legend>Pesquisar Colecionador</legend>

                <label for="cpf">CPF:</label>
                <input type="text" id="cpf" name="cpf"
                    placeholder="Digite o CPF..." maxlength="14">

                <button type="submit">Pesquisar</button>

                <!-- OK -->
                <button type="button" onclick="location.href='Adicionar.jsp'">
                    Adicionar Novo
                </button>

                <!-- OK -->
                <button type="button" onclick="location.href='MenuPrincipal.jsp'">
                    Voltar ao Menu
                </button>

                <br><br>
            </fieldset>
        </section>
    </form>

    <!-- Lista de Colecionadores -->
    <h2>Lista de Colecionadores</h2>

    <table border="1" style="border-collapse: collapse; width: 100%">
        <thead>
            <tr>
                <th style="padding: 10px">CPF</th>
                <th style="padding: 10px">Nome</th>
                <th style="padding: 10px">Idade</th>
                <th style="padding: 10px">Telefone</th>
                <th style="padding: 10px">Editar</th>
                <th style="padding: 10px">Excluir</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="colecionador" items="${lista}">
                <tr>
                    <td>${colecionador.cpf}</td>
                    <td>${colecionador.nome}</td>
                    <td>${colecionador.idade}</td>
                    <td>${colecionador.telefone}</td>

                    <td>
                        <form action="AlterarColecionadorServlet" method="get">
                            <input type="hidden" name="cpf" value="${colecionador.cpf}">
                            <button type="submit" style="width: 100%; padding: 10px;">
                                Editar
                            </button>
                        </form>
                    </td>

                    <td>
                        <form action="ApagarColecionadorServlet" method="post">
                            <input type="hidden" name="cpf" value="${colecionador.cpf}">
                            <button type="submit" style="width: 100%; padding: 10px;">
                                Excluir
                            </button>
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>