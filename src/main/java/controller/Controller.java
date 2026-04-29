package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

//import com.itextpdf.text.Document; 
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
@WebServlet({ "/main", "/insert", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();// Teste com o Banco
	JavaBeans produto = new JavaBeans();

	/**
	 * Default constructor.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.testeConexao();

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			inserirProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request,response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request,response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("tabela.jsp");
		ArrayList<JavaBeans> lista = dao.listarProdutos();

		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("tabela.jsp");
		rd.forward(request, response);

		// Teste de recebimwnto da lista
		/*
		 * for (int i = 0; i < lista.size(); i++) { System.out.println(lista);
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFabricacao());
		 * System.out.println(lista.get(i).getCategoria());
		 * System.out.println(lista.get(i).getFaixaE());
		 * System.out.println(lista.get(i).getPreco()); }
		 */
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getFabricacao());
		}
	}

	protected void inserirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// pegar dados do formulário
		String nome = request.getParameter("nome");
		String fab = request.getParameter("fab");
		System.out.println(fab + " ###############");
		// Data
		/*
		 * String dataTexto = request.getParameter("fab");
		 * 
		 * DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		 * LocalDate data = LocalDate.parse(dataTexto, formatoEntrada);
		 */

		String categoriaStr = request.getParameter("categoria");
		String faixaE = request.getParameter("faixa");
		String preco = request.getParameter("preco");

		// conversão categoria e data
		String categoriaEnum = String.valueOf(categoriaStr);

		/*
		 * DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * LocalDate data = LocalDate.parse(fab, formatoEntrada);
		 * 
		 * String dataFormatada = data.toString(); // yyyy-MM-dd
		 */

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

		// System.out.println("ANTES: " + fab);
		// System.out.println("DEPOIS: " + data);
	}

	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		// System.out.println(idcon);
		produto.setIdcon(idcon);
		dao.selecionarProduto(produto);

		/*
		 * System.out.println(contato.getIdcon());
		 * System.out.println(contato.getNome()); System.out.println(contato.getFone());
		 * System.out.println(contato.getEmail());
		 */

		/*
		 * String fab = produto.getFabricacao(); DateTimeFormatter formatoTela =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * 
		 * String dataFormatada = data.format(formatoTela);
		 */

		// request.setAttribute("fab", dataFormatada);

		request.setAttribute("idcon", produto.getIdcon());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("fab", produto.getFabricacao());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("faixa", produto.getFaixaE());
		request.setAttribute("preco", produto.getPreco());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * System.out.println(request.getParameter("idcon"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */

		/*String dataTexto = request.getParameter("fab");

		DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataTexto, formatoEntrada);*/

		produto.setNome(request.getParameter("nome"));
		produto.setFabricacao(request.getParameter("fab"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setFaixaE(request.getParameter("faixa"));
		produto.setPreco(request.getParameter("preco"));

		dao.alterarProduto(produto);
		response.sendRedirect("main");
	}

	// Deletar
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		System.out.println(idcon);
		
		produto.setIdcon(idcon);
		dao.deletarProduto(produto);
		response.sendRedirect("main");
		 
	}
	

	//Gerar Relatório PDF
			protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Document documento = new Document();
				
				try {
					response.setContentType("aplication/pdf");
					response.addHeader("Content-Disposition", "inline; filemane=" + "center_toys.pdf");
					
					PdfWriter.getInstance(documento, response.getOutputStream());
					// 🔽 AQUI entra a imagem
					String caminhoImagem = getServletContext().getRealPath("/img/logo.png");
					Image imagem = Image.getInstance(caminhoImagem);

					// ajustar tamanho
					imagem.scaleToFit(120, 120);
					imagem.setAlignment(Element.ALIGN_CENTER);

					// adiciona no PDF
					
					documento.open();
					documento.add(new Paragraph(" "));
					
					PdfPTable tabela = new PdfPTable(5);
					
					Font fonteCabecalho = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
					BaseColor corFundo = new BaseColor(0, 102, 204);
					 
					PdfPCell col1 = new PdfPCell(new Paragraph("Nome", fonteCabecalho));
					PdfPCell col2 = new PdfPCell(new Paragraph("Data da fabricação", fonteCabecalho));
					PdfPCell col3 = new PdfPCell(new Paragraph("Categoria", fonteCabecalho));
					PdfPCell col4 = new PdfPCell(new Paragraph("Faixa Etaria", fonteCabecalho));
					PdfPCell col5 = new PdfPCell(new Paragraph("Preço", fonteCabecalho));
					
					
					/*tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					tabela.addCell(col5);*/
					PdfPCell[] colunas = {col1, col2, col3, col4, col5};

			        for (PdfPCell col : colunas) {
			            col.setBackgroundColor(corFundo);
			            col.setHorizontalAlignment(Element.ALIGN_CENTER);
			            col.setPadding(5);
			            tabela.addCell(col);
			        }
					
					ArrayList<JavaBeans> lista = dao.listarProdutos();
					for(int i = 0; i < lista.size(); i++) {
						tabela.addCell(lista.get(i).getNome());
						tabela.addCell(lista.get(i).getFabricacao());
						tabela.addCell(lista.get(i).getCategoria());
						tabela.addCell(lista.get(i).getFaixaE());
						tabela.addCell(lista.get(i).getPreco());
					}
					
					documento.add(imagem);
					documento.add(tabela);	
					documento.close();
					
				} catch (Exception e) {
					System.out.println(e);
					documento.close();				
				}
			}
	}
