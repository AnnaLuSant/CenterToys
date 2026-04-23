function validar() {
	let nome = frmProduto.nome.value
	let fab = frmProduto.fab.value
	let categoria = frmProduto.categoria.value
	let faixa = frmProduto.faixa.value
	let preco = frmProduto.preco.value
	let precoCampo = frmProduto.preco;
	let faixaCampo = frmProduto.faixa;

	let precoLimpo = precoCampo.value.replace(/[R$\s.]/g, '').replace(',', '.');
	precoCampo.value = precoLimpo;

	let faixaLimpa = faixaCampo.value.replace(/\D/g, '');
	faixaCampo.value = faixaLimpa;

	if (nome === "") {
		alert("Preencha o campo nome")
		frmContato.nome.focus()
	} else if (fab === "") {
		alert("Preencha o campo fabricação")
		frmProduto.fab.value
		frmProduto.fab.focus()
	} else if (categoria === "") {
		alert("Preencha o campo categoria")
		frmProduto.cadastro.value
		frmProduto.categoria.focus()
	} else if (faixa === "") {
		alert("Preencha o campo Faixa Etária")
		frmProduto.faixa.value
		frmProduto.faixa.focus()
	} else if (preco === "") {
		alert("Preencha o campo preço")
		frmProduto.preco.value
		frmProduto.preco.focus()
	}else {
		document.forms["frmProduto"].submit()
	}
	
	
}