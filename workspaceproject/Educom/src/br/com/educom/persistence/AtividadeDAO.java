package br.com.educom.persistence;

import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			pstm.setDate(3,(java.sql.Date) atividade.getDataEntrega());
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
		
	String sql = "DELETE FROM Atividades WHERE descricao = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 conn = ConnectionFactory.createConnectionToMySQL();
		 
		 pstm = conn.prepareStatement(sql);
		 
		 pstm.setString(1, descricao);
		 
		 pstm.execute();
		 
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }finally{
		 
		 try{
		 if(pstm != null){
		 
		 pstm.close();
		 }
		 
		 if(conn != null){
		 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 				
		 }
		 
		 }
		
	}
	
	public void update(Atividade atividade){
		 
		 String sql = "UPDATE Atividades SET descricao = ?, nota = ?, dataEntrega = ?" +
		 " WHERE tipo = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
			 
		 conn = ConnectionFactory.createConnectionToMySQL();
		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = conn.prepareStatement(sql);
		 
		 //Adiciona o valor do primeiro parâmetro da sql
		 pstm.setString(1, atividade.getDescricao());
		 //Adicionar o valor do segundo parâmetro da sql
		 pstm.setDouble(2, atividade.getNota());
		 //Adiciona o valor do terceiro parâmetro da sql
		 pstm.setDate(3, (java.sql.Date) new Date(atividade.getDataEntrega().getTime()));
		 
		 pstm.setString(4, atividade.getTipo());
		 
		 //Executa a sql para inserção dos dados
		 pstm.execute();
		 
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally{
		 
		 //Fecha as conexões
		 
		 try{
		 if(pstm != null){
		 
		 pstm.close();
		 }
		 
		 if(conn != null){
		 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 }
		 }
		 }
	
	public List<Atividade> getAtividades(){
		 
		 String sql = "SELECT * FROM Atividades";
		 
		 List<Atividade> atividade = new ArrayList<Atividade>();
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
		 conn = ConnectionFactory.createConnectionToMySQL();
		 
		 pstm = conn.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 //Enquanto existir dados no banco de dados, faça
		 while(rset.next()){
		 
		 Atividade atividade1 = new Atividade();
		 
		 
		 atividade1.setDescricao(rset.getString("descricao"));
		 
		
		 atividade1.setNota(rset.getDouble("nota"));
		 
		
		 atividade1.setDataEntrega(rset.getDate("nota"));
		 
		 
		 atividade1.setDataEntrega(rset.getDate("dataEntrega"));
		 
		 
		 atividade.add(atividade1);
		 }
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally{
		 
		 try{
		 
		 if(rset != null){
		 
		 rset.close();
		 }
		 
		 if(pstm != null){
		 
		 pstm.close();
		 }
		 
		 if(conn != null){
		 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 }
		 }
		 
		 return atividade;
		 }

}
