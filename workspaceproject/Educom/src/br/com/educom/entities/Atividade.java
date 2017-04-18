package br.com.educom.entities;
import java.util.Date;

public class Atividade {

	private String descricao;
	private double nota;
	private Date dataEntrega;
	private String tipo;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
