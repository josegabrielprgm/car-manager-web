package br.com.jose.cadcolweb.servlet.colecionador;

import java.io.IOException;

import br.com.jose.cadcolweb.domain.Colecionador;
import br.com.jose.cadcolweb.persistence.ColecionadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AlterarColecionadorServlet")
public class AlterarColecionadorServlet extends HttpServlet {

	private static final long serialVersionUID = -8763968288221039048L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String cpf = request.getParameter("cpf").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		Colecionador colecionador = colecionadorDAO.buscar(cpf);

		request.setAttribute("colecionador", colecionador);
		request.getRequestDispatcher("AlterarColecionador.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String cpf = request.getParameter("cpf").trim();
		String nome = request.getParameter("nome").trim();
		String idadeStr = request.getParameter("idade").trim();
		String telefone = request.getParameter("telefone").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		int idade = Integer.parseInt(idadeStr);

		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();

		Colecionador colecionador = new Colecionador();
		colecionador.setCpf(cpf);
		colecionador.setNome(nome);
		colecionador.setIdade(idade);
		colecionador.setTelefone(telefone);

		colecionadorDAO.atualizar(colecionador);

		response.sendRedirect("Colecionador.jsp");
	}
}