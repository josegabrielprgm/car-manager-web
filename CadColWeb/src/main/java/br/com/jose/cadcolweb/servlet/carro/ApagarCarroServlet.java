package br.com.jose.cadcolweb.servlet.carro;

import java.io.IOException;

import br.com.jose.cadcolweb.persistence.CarroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApagarCarroServlet")
public class ApagarCarroServlet extends HttpServlet {

	private static final long serialVersionUID = 4424557612864783850L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String id = request.getParameter("id").trim();

		CarroDAO carroDAO = new CarroDAO();
		carroDAO.apagar(id);

		response.sendRedirect("Carro.jsp");
	}
}