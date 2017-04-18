package br.com.educom.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import br.com.educom.persistence.ConnectionFactory;
import br.com.educom.entities.Atividade;

public class AtividadeDAO {
	
	public void inserir(Atividade atividade) {
		
		String sql = "INSERT INTO Atividades(descricao,nota,dataEntrega,tipo)" + "VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, atividade.getDescricao());
			pstm.setDouble(2, atividade.getNota());
			pstm.setDate(3, (Date) atividade.getDataEntrega());
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void removerPelaDescricao(String descricao) {
		
	}

}
