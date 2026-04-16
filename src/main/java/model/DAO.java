package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Módulo de conexão com o banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/centertoys?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	
	//Testando conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*CRUD CREATE*/
	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos=new ArrayList<>();
		
		String read ="select * from brinquedos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon =rs.getString(1);
				String nome = rs.getString(2);
				String fabricacao =rs.getString(3);
				String categoria = rs.getString(4);
				String faixaE = rs.getString(5);
				String preco = rs.getString(6);
				
				produtos.add(new JavaBeans(idcon,nome,fabricacao,categoria,faixaE,preco));
				
			}
			con.close();
			return produtos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
		
		
		/*CRUF UPDATE*/
		
		
	}
	
	public void inserirProduto(JavaBeans produto) {
		String create ="insert into brinquedos(nome,fabricacao,categoria,faixa_etaria,preco) values (?,?,?,?,?)";
		
		//Coloca as coisas dentro do banco, executando o "insert into"
		try {
			Connection con =conectar();
			PreparedStatement pst =con.prepareStatement(create);	
			
			//Substituir o (?,?,?)
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getFabricacao());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getFaixaE());
			pst.setString(5, produto.getPreco());
			
			pst.executeUpdate();
			
			con.close();//fechar a conexão com o banco de dados
			} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
