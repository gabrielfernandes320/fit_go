package fitgojsp.servelts;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import fitgojsp.dao.ModalityDao;
import fitgojsp.entities.Modality;
 
@WebServlet("/ModalityServlet")
public class ModalityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		List<Modality> lista = new ArrayList<>();
 
 
		Modality aluno = new Modality();
		ModalityDao dao = new ModalityDao();
 
		try {
 
			//Se a a��o for DIFERENTE de Listar s�o lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				if(request.getParameter("id") != null) {
					aluno.setMatricula(Long.parseLong(request.getParameter("id")));
				}
				aluno.setNome(request.getParameter("nome"));
 
			}
 
			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matr�cula informada j� existe no Banco de Dados
				// Se existir enviar uma mensagem sen�o faz a inclus�o
				if (dao.existe(aluno)) {
					mensagem = "Matr�cula informada j� existe!";
				} else {
					dao.inserir(aluno);
				}
			} else if (acao.equalsIgnoreCase("Alterar")) {
				dao.alterar(aluno);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(aluno);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("aluno", aluno);
				aluno = dao.consultar(aluno);
				destino = "aluno.jsp";
			}
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
 
		// Se a mensagem estiver vazia significa que houve sucesso!
		// Sen�o ser� exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Modality Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("modalityList", lista);
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("pagina", "ListModality.jsp");

 
		//O sistema � direcionado para a p�gina 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}