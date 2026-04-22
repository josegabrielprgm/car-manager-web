package br.com.jose.cadcolweb.servlet.carro;

import java.io.IOException;

import br.com.jose.cadcolweb.domain.Carro;
import br.com.jose.cadcolweb.persistence.CarroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarCarroServlet")
public class AdicionarCarroServlet extends HttpServlet {

	private static final long serialVersionUID = -2946641090553717108L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		CarroDAO carroDAO = new CarroDAO();

		String cpf = request.getParameter("cpf").trim();
		String apelido = request.getParameter("apelido").trim();
		String anoFabStr = request.getParameter("anoFab").trim();
		String placa = request.getParameter("placa").trim();

		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "").replace("_", "");

		int anoFab = Integer.parseInt(anoFabStr);

		Carro carro = new Carro();
		
		carro.setCpf(cpf);
		carro.setApelido(apelido);
		carro.setAnoFab(anoFab);
		carro.setPlaca(placa);

		carroDAO.criar(carro);

		response.sendRedirect("Carro.jsp");
	}
}