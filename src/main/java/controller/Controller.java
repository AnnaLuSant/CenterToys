package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet({"/main","/insert","/select","/update","/delete","report"})
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
		}else if (action.equals("/select")) {
			listarContato(request,response);
		}else if(action.equals("/update")){
			editarProduto(request,response);
		}else if (action.equals("/delete")){
			removerContato(request,response);
		}/*else if (action.equals("/report")){
			gerarRelatorio(request,response);
		}*/
		else {
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
		for (int i = 0; i < lista.size(); i++) {
		System.out.println(lista.get(i).getFabricacao());
		}
	}
	
	protected void inserirProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // pegar dados do formulário
	    String nome = request.getParameter("nome");
	    
	    //Data
	    String dataTexto = request.getParameter("fab");
	    DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate data = LocalDate.parse(dataTexto, formatoEntrada);
		
	    String categoriaStr = request.getParameter("categoria");
	    String faixaE = request.getParameter("faixa");
	    String preco = request.getParameter("preco");
	    
	    //conversão categoria e data
	    String categoriaEnum = String.valueOf(categoriaStr);
	    
	    
	    /*DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate data = LocalDate.parse(fab, formatoEntrada);

	    String dataFormatada = data.toString(); // yyyy-MM-dd*/

	    // setar no bean
	    JavaBeans produto = new JavaBeans();
	    produto.setNome(nome);
	    produto.setFabricacao(data);
	    produto.setCategoria(categoriaEnum);
	    produto.setFaixaE(faixaE);
	    produto.setPreco(preco);

	    // enviar para o DAO
	    dao.inserirProduto(produto);

	    // redirecionar
	    response.sendRedirect("main");
	    
	    //System.out.println("ANTES: " + fab);
	    System.out.println("DEPOIS: " + data);
	}
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		//System.out.println(idcon);
		produto.setIdcon(idcon);
		dao.selecionarProduto(produto);
		/*System.out.println(contato.getIdcon());
		System.out.println(contato.getNome());
		System.out.println(contato.getFone());
		System.out.println(contato.getEmail());*/
		
		LocalDate data = produto.getFabricacao();
		DateTimeFormatter formatoTela = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String dataFormatada = data.format(formatoTela);

		;

		request.setAttribute("fab", dataFormatada);
		
		request.setAttribute("idcon", produto.getIdcon());
		request.setAttribute("nome", produto.getNome());
		//request.setAttribute("fab", produto.getFabricacao());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("faixa", produto.getFaixaE());
		request.setAttribute("preco", produto.getPreco());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("idcon"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));*/
		
		String dataTexto = request.getParameter("fab");

		DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataTexto, formatoEntrada);

		
		produto.setNome(request.getParameter("nome"));
		produto.setFabricacao(data);
	    produto.setCategoria(request.getParameter("categoria"));
	    produto.setFaixaE(request.getParameter("faixa"));
	    produto.setPreco(request.getParameter("preco"));
		
		dao.alterarProduto(produto);
		response.sendRedirect("main");
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		//System.out.println(idcon);
		
		produto.setIdcon(idcon);
		dao.deletarProduto(produto);
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
