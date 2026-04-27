package model;

import java.time.LocalDate;

public class JavaBeans {
	private String idcon;
	private String nome;
	private LocalDate fabricacao;
	private String categoria;
	private String faixaE;
	private String preco;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcon,String nome,LocalDate fabricacao,String categoria,String faixaE,String preco) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fabricacao = fabricacao;
		this.categoria = categoria;
		this.faixaE = faixaE;
		this.preco = preco;
	}
	
	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(LocalDate date) {
		this.fabricacao = date;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFaixaE() {
		return faixaE;
	}
	public void setFaixaE(String faixaE) {
		this.faixaE = faixaE;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}

	

}
