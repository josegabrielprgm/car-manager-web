package br.com.jose.cadcolweb.servlet.colecionador;

import java.io.IOException;

import br.com.jose.cadcolweb.persistence.CarroDAO;
import br.com.jose.cadcolweb.persistence.ColecionadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApagarColecionadorServlet")
public class ApagarColecionadorServlet extends HttpServlet {

	private static final long serialVersionUID = -4826615835875370121L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String cpf = request.getParameter("cpf").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		ColecionadorDAO colecionadorDAO = new ColecionadorDAO();
		CarroDAO carroDAO = new CarroDAO();

		carroDAO.apagarByCpf(cpf);
		colecionadorDAO.apagar(cpf);

		response.sendRedirect("Colecionador.jsp");
	}
}