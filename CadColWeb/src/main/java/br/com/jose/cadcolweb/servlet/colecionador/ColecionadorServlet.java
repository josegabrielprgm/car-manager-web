package br.com.jose.cadcolweb.servlet.colecionador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.jose.cadcolweb.domain.Colecionador;
import br.com.jose.cadcolweb.persistence.ColecionadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ColecionadorServlet")
public class ColecionadorServlet extends HttpServlet {

	private static final long serialVersionUID = 7625514510787934789L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String cpf = request.getParameter("cpf").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();

		List<Colecionador> lista;

		if (cpf.isEmpty()) {

			lista = colecionadorDAO.listar();

		} else {

			lista = new ArrayList<>();

			Colecionador colecionador = colecionadorDAO.buscar(cpf);

			if (colecionador != null) {
				lista.add(colecionador);
			}
		}

		request.setAttribute("lista", lista);
		request.getRequestDispatcher("Colecionador.jsp").forward(request, response);
	}
}