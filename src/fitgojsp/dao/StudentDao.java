package fitgojsp.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import fitgojsp.entities.Student;
 
public class StudentDao extends dao {
 
	public void alterar(Student student) {
		try {
			Connection conexao = getConexao();
 
			PreparedStatement pstmt = conexao
					.prepareStatement("Update student SET nome = ?, telefone = ?, email = ?, datacadastro = ?"
							+ " WHERE matricula = ? ");
			pstmt.setString(1, student.getNome());
			pstmt.setString(2, student.getTelefone());
			pstmt.setString(3, student.getEmail());
			pstmt.setLong(5, student.getMatricula());
			pstmt.execute();
			pstmt.close();
			conexao.close();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public void excluir(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	student where matricula = ? ");
			pstm.setLong(1, student.getMatricula());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public boolean existe(Student student) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from student where matricula =	?");
			pstm.setLong(1, student.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}
 
	public void inserir(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	student (matricula, nome, telefone, email) values	(?,?,?,?)");
			pstm.setLong(1, student.getMatricula());
			pstm.setString(2, student.getNome());
			pstm.setString(3, student.getTelefone());
			pstm.setString(4, student.getEmail());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public List<Student> listar() {
		List<Student> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from student");
			while (rs.next()) {
				Student student = new Student();
				student.setMatricula(rs.getLong("matricula"));
				student.setNome(rs.getString("nome"));
				student.setTelefone(rs.getString("telefone"));
				student.setEmail(rs.getString("email"));
				lista.add(student);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
 
	public Student consultar(Student student) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from student where matricula =	?");
			pstm.setLong(1, student.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				student.setMatricula(rs.getLong("matricula"));
				student.setNome(rs.getString("nome"));
				student.setTelefone(rs.getString("telefone"));
				student.setEmail(rs.getString("email"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}