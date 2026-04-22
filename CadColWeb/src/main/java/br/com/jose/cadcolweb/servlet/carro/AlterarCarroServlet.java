package br.com.jose.cadcolweb.servlet.carro;

import java.io.IOException;

import br.com.jose.cadcolweb.domain.Carro;
import br.com.jose.cadcolweb.persistence.CarroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AlterarCarroServlet")
public class AlterarCarroServlet extends HttpServlet {

	private static final long serialVersionUID = 2998354104027828164L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String id = request.getParameter("id").trim();

		CarroDAO carroDAO = new CarroDAO();
		Carro carro = carroDAO.buscar(id);

		request.setAttribute("carro", carro);
		request.getRequestDispatcher("AlterarCarro.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		CarroDAO carroDAO = new CarroDAO();

		String id = request.getParameter("id").trim();

		String cpf = request.getParameter("cpf").trim();
		String apelido = request.getParameter("apelido").trim();
		String anoFabStr = request.getParameter("anoFab").trim();
		String placa = request.getParameter("placa").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		int anoFab = Integer.parseInt(anoFabStr);

		Carro carro = carroDAO.buscar(id);
		carro.setCpf(cpf);
		carro.setApelido(apelido);
		carro.setAnoFab(anoFab);
		carro.setPlaca(placa);

		carroDAO.atualizar(carro);

		response.sendRedirect("Carro.jsp");
	}
}