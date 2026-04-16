function validar() {
	let nome = frmProduto.nome.value
	let fab = frmProduto.fab.value
	let categoria = frmProduto.categoria.value
	let faixa = frmProduto.faixa.value
	let preco = frmProduto.preco.value

	if (nome === "") {
		alert("Preencha o campo nome")
		frmContato.nome.focus
	} else if (fab === "") {
		alert("Preencha o campo fabricação")
		frmProduto.fab.value
	} else if (categoria === "") {
		alert("Preencha o campo categoria")
		frmProduto.cadastro.value
	} else if (faixa === "") {
		alert("Preencha o campo Faixa Etária")
		frmProduto.faixa.value
	} else if (preco === "") {
		alert("Preencha o campo preço")
		frmProduto.preco.value
	}else {
		document.forms["frmProduto"].submit()
	}
}