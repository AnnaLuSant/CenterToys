<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<title>Cadastro</title>
<link rel="shortcut icon" href="img/favicon_fone.png"
	type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container w-50 bg-secondary-subtle text-center py-3">

		<h1 class="text-primary">Novo produto</h1>

		<form class="row g-3 w-50 mx-auto" name="frmProduto" action="update">


			<div class="mb-3">
				<input type="text" class="form-control" name="idcon" readonly
					value="<%out.print(request.getAttribute("idcon"));%>">
			</div>

			<div class="mb-3">
				<input type="text" name="nome" class="form-control"
					placeholder="Produto" aria-label="Digite nome do produto"
					value="<%out.print(request.getAttribute("nome"));%>">
			</div>

			<div class="mb-3">
				<input type="text" name="fab" class="form-control"
					placeholder="Fabricação" aria-label="Digite a fabricação "
					value="<%out.print(request.getAttribute("fab"));%>">
			</div>

			<div class="mb-3">
				<select id="inputState" class="form-select" name="categoria">
				
					<%String categoria = (String) request.getAttribute("categoria");%>
					
					<option value="" selected disabled>Selecione uma categoria</option>
					<option value="Jogos de Tabuleiro" <%= categoria.equals("Jogos de Tabuleiro") ? "selected" : "" %>>Jogos de Tabuleiro</option>
					<option value="Jogos Pedagógicos" <%= categoria.equals("Jogos Pedagógicos") ? "selected" : "" %>>Jogos Pedagógicos</option>
					<option value="Blocos de montar" <%= categoria.equals("Blocos de montar") ? "selected" : "" %>>Blocos de montar</option>
					<option value="Bonecas" <%= categoria.equals("Bonecas") ? "selected" : "" %>>Bonecas</option>
					<option value="Ar Livre" <%= categoria.equals("Ar Livre") ? "selected" : "" %>>Ar Livre</option>
					<option value="Quebra-cabeça" <%= categoria.equals("Quebra-cabeça") ? "selected" : "" %>>Quebra-cabeça</option>
					<option value="Cartas" <%= categoria.equals("Cartas") ? "selected" : "" %>>Cartas</option>
				</select>
			</div>

			<div class="mb-3">
				<input type="text" name="faixa" class="form-control"
					placeholder="Faixa" aria-label="Digite a faixa Etária " required
					value="<%out.print(request.getAttribute("faixa"));%>">
			</div>


			<div class="mb-3">
				<input type="text" name="preco" class="form-control"
					placeholder="Fabricação" aria-label="Digite o preço " required
					value="<%out.print(request.getAttribute("preco"));%>">
			</div>
		</form>

		<button class="btn btn-primary" onclick="validar()" value="Salvar">Salvar</button>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"></script>
	<script src="scripts/validador.js"></script>

</body>
</html>