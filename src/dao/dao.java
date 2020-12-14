package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
/**
 * Classe respons�vel pela Conex�o com o Banco de dados. � utilizada por outras
 * classes de persist�ncia de dados.
 * 
 */
public class dao {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "admin";
		String nomeBancoDados = "fitgo";
 
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					 usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}