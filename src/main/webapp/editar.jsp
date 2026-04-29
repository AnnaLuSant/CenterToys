<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description" content="">
<meta name="keywords" content="">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Fredoka:wght@300..700&display=swap"
	rel="stylesheet">

<title>Cadastro</title>
<link rel="shortcut icon" href="img/logo_personagem.png"
	type="image/x-icon">

</head>

<body id="interface">

	<header
		class="d-flex flex-column flex-md-row align-items-center justify-content-center mb-4 gap-md-4">

		<img id="logo" src="img/logo.png" alt="Logo Center Toys"
			class="img-fluid">
		<h1 class="fw-bold titulo-pagina mb-0" id="titulo-pagina">
			Cadastro de Produtos</h1>

	</header>


	<div class=" container text-center py-3">

		<form class="row mb-3 w-50 mx-auto" name="frmProduto" action="insert">

			<div class="mb-3">
				<input type="text" id="idcon" class="form-control" name="idcon" readonly
					value="<%out.print(request.getAttribute("idcon"));%>">
			</div>

			<div class="mb-3">

				<input type="text" name="nome" class="form-control"
					placeholder="Nome do Produto:" maxlength="50" required
					value="<%out.print(request.getAttribute("nome"));%>">

			</div>


			<div class="mb-3">

				<input type="text" name="fab" class="form-control"
					placeholder="Data de Fabricação:" maxlength="10"
					oninput="let v=this.value.replace(/\D/g,''); if(v.length>2) v=v.slice(0,2)+'/'+v.slice(2); if(v.length>5) v=v.slice(0,5)+'/'+v.slice(5,9); this.value=v;"
					required value="<%out.print(request.getAttribute("fab"));%>">

			</div>

			<div class="mb-3">

				<select id="inputState" class="form-select" name="categoria">
				<%String categoria = (String) request.getAttribute("categoria");%>

					<option value="" selected disabled>Selecione uma categoria</option>
					<option value="Jogos de Tabuleiro" <%= categoria.equals("Jogos de Tabuleiro") ? "selected" : "" %>> Jogos de Tabuleiro</option>
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
					placeholder="Faixa Etária: (Ex: 5)"
					onfocus="this.value = this.value.replace(' anos', '')"
					onblur="if(this.value && !this.value.includes(' anos')) this.value += ' anos'"
					required value="<%out.print(request.getAttribute("faixa"));%>">

			</div>


			<div class="mb-3">

				<input type="text" name="preco" class="form-control"
					oninput="this.value = (Number(this.value.replace(/\D/g, '')) / 100).toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })"
					required value="R$ <%out.print(request.getAttribute("preco"));%>">

			</div>

		</form>

		<div class="d-grid gap-2 col-3 mx-auto">

			<a class="btn btn-primary" id="botaoAzul" type="button"
				onclick="validar()"> Cadastrar </a> <a class="btn btn-primary"
				id="botaoVermelho" type="button" href="main"> Voltar </a>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"></script>
	<script src="scripts/validador.js"></script>

</body>

</html>