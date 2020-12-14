package fitgojsp.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import fitgojsp.entities.Modality;
 
public class ModalityDao extends dao {
 
	public void alterar(Modality modality) {
		try {
			Connection conexao = getConexao();
 
			PreparedStatement pstmt = conexao
					.prepareStatement("Update modality SET nome = ?"
							+ " WHERE id = ? ");
			pstmt.setString(1, modality.getNome());
			pstmt.setLong(2, modality.getMatricula());
			pstmt.execute();
			pstmt.close();
			conexao.close();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public void excluir(Modality modality) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	modality where id = ? ");
			pstm.setLong(1, modality.getMatricula());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public boolean existe(Modality modality) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from modality where nome =	?");
			pstm.setString(1, modality.getNome());
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
 
	public void inserir(Modality modality) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	modality (nome) values	(?)");
			pstm.setString(1, modality.getNome());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public List<Modality> listar() {
		List<Modality> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from modality");
			while (rs.next()) {
				Modality modality = new Modality();
				modality.setMatricula(rs.getLong("id"));
				modality.setNome(rs.getString("nome"));
				lista.add(modality);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
 
	public Modality consultar(Modality modality) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from modality where id =?");
			pstm.setLong(1, modality.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				modality.setMatricula(rs.getLong("id"));
				modality.setNome(rs.getString("nome"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modality;
	}
}