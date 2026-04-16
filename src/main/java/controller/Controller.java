package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet({"/main","/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();//Teste com o Banco
	JavaBeans produto = new JavaBeans();
	

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.testeConexao();
		
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")) {
			produtos(request,response);
		}else if(action.equals("/insert")){
			inserirProduto(request,response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//response.sendRedirect("agenda.jsp");
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("tabela.jsp");
		rd.forward(request, response);
		
		//Teste de recebimwnto da lista
		/*for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista);
			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFabricacao());
			System.out.println(lista.get(i).getCategoria());
			System.out.println(lista.get(i).getFaixaE());
			System.out.println(lista.get(i).getPreco());
		}*/
	}
	
	protected void inserirProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // pegar dados do formulário
	    String nome = request.getParameter("nome");
	    String fab = request.getParameter("fab");
	    String categoriaStr = request.getParameter("categoria");
	    String faixaE = request.getParameter("faixa");
	    String preco = request.getParameter("preco");
	    
	    //conversão
	    String categoriaEnum = String.valueOf(categoriaStr);

	    // setar no bean
	    JavaBeans produto = new JavaBeans();
	    produto.setNome(nome);
	    produto.setFabricacao(fab);
	    produto.setCategoria(categoriaEnum);
	    produto.setFaixaE(faixaE);
	    produto.setPreco(preco);

	    // enviar para o DAO
	    dao.inserirProduto(produto);

	    // redirecionar
	    response.sendRedirect("main");
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
