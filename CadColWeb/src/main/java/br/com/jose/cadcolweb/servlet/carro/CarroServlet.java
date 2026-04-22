package br.com.jose.cadcolweb.servlet.carro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.jose.cadcolweb.domain.Carro;
import br.com.jose.cadcolweb.persistence.CarroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CarroServlet")
public class CarroServlet extends HttpServlet {

	private static final long serialVersionUID = -8059096755505068821L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String placa = request.getParameter("placa").trim();

		CarroDAO carroDAO = new CarroDAO();

		List<Carro> lista;

		if (placa.isEmpty()) {

			lista = carroDAO.listar();

		} else {

			lista = new ArrayList<>();

			Carro carro = carroDAO.buscarPelaPlaca(placa);

			if (carro != null) {
				lista.add(carro);
			}
		}

		request.setAttribute("lista", lista);
		request.getRequestDispatcher("Carro.jsp").forward(request, response);
	}
}