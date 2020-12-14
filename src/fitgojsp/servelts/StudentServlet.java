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
 
import fitgojsp.dao.StudentDao;
import fitgojsp.entities.Student;
 
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
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
		List<Student> lista = new ArrayList<>();
 
 
		Student aluno = new Student();
		StudentDao dao = new StudentDao();
 
		try {
 
			//Se a ação for DIFERENTE de Listar são lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				aluno.setMatricula(Long.parseLong(request.getParameter("matricula")));
				aluno.setNome(request.getParameter("nome"));
				aluno.setTelefone(request.getParameter("telefone"));
				aluno.setEmail(request.getParameter("email"));
 
			}
 
			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matrícula informada já existe no Banco de Dados
				// Se existir enviar uma mensagem senão faz a inclusão
				if (dao.existe(aluno)) {
					mensagem = "Matrícula informada já existe!";
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
		// Senão será exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Student Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("studentList", lista);
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("pagina", "ListStudent.jsp");

 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}