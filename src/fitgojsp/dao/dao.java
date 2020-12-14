package fitgojsp.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
 

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