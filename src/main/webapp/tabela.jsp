<%@page import="model.JavaBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
//teste de recebimento 
/*for(int i = 0; i < lista.size(); i++){
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getFabricacao());
	out.println(lista.get(i).getCategoria());
	out.println(lista.get(i).getFaixaE());
	out.println(lista.get(i).getPreco());
	}*/
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="img/logo_personagem.png"
	type="image/x-icon">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300..700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/style.css">

<title>Produtos - Center Toys</title>

</head>

<body id="interface">

	<div class="container py-4">

		<header
			class="d-flex flex-column flex-md-row align-items-center justify-content-center mb-4 gap-md-4">

			<img id="logo" src="img/logo_personagem.png" alt="Logo Center Toys"
				class="img-fluid">
			<h1 class="fw-bold titulo-pagina mb-0">Produtos</h1>

		</header>

		<main
			class="bg-white p-3 p-md-4 rounded-4 shadow-sm mb-4 border-tabela">

			<div class="table-responsive">

				<table class="table table-hover align-middle text-center mb-0">

					<thead>

						<tr>

							<th scope="col">ID</th>
							<th scope="col">Nome</th>
							<th scope="col">Data de Fabricação</th>
							<th scope="col">Categoria</th>
							<th scope="col">Faixa Etária</th>
							<th scope="col">Preço</th>
							<th scope="col"></th>
							<th scope="col"></th>

						</tr>

					</thead>

					<tbody>
					<% for (int i = 0; i< lista.size(); i++){ %>

						<tr>

							<td><%= lista.get(i).getIdcon()%></td>
							<td><%= lista.get(i).getNome()%></td>
							<td><%= lista.get(i).getFabricacao()%></td>
							<td><%= lista.get(i).getCategoria()%></td>
							<td><%= lista.get(i).getFaixaE()%></td>
							<td><%= lista.get(i).getPreco()%></td>

							<td> <a href="select?idcon=<%= lista.get(i).getIdcon() %>" class="btn fw-bold w-100" id="botaoAmarelo"> Editar </a>
								

							<td><a href="javascript:confirmar(<%= lista.get(i).getIdcon() %>)" class="btn fw-bold w-100"
								id="botaoVermelho"> Excluir </a></td>

						</tr>
						<% } %>

					</tbody>

				</table>

			</div>

		</main>

		<footer
			class="d-flex flex-column flex-md-row justify-content-center gap-3">

			<a type="button" class="btn px-4 py-2 fw-bold custom-btn"
				id="botaoAzul" href="cadastro.html"> Cadastrar produto </a> <a
				type="button" class="btn px-4 py-2 fw-bold custom-btn"
				id="botaoVerde" href="#"> Baixar relatório </a>

		</footer>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>

