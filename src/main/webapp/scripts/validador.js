/*function validar() {
	let nome = frmProduto.nome.value
	let fab = frmProduto.fab.value
	let categoria = frmProduto.categoria.value
	let faixa = frmProduto.faixa.value
	let preco = frmProduto.preco.value
	let precoCampo = frmProduto.preco;
	let faixaCampo = frmProduto.faixa;

	//console.log(fab)


	let data = fab.split('/')
	console.log(data)
	let data_fab = data[2] + "-" + data[1] + "-" + data[0]
	console.log(data_fab)


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
	} else {
		document.getElementById("fab").value = data_fab;
		document.forms["frmProduto"].submit();
	}


}*/

function validar() {
    // 1. Pegar a referência do formulário de forma segura
    let form = document.forms["frmProduto"];
    
    let nome = form.nome.value;
    let fabRaw = form.fab.value; // Valor original do campo data
    let categoria = form.categoria.value;
    let faixa = form.faixa.value;
    let preco = form.preco.value;

    // 2. Validações básicas (antes de manipular os dados)
    if (nome === "") {
        alert("Preencha o campo nome");
        form.nome.focus();
        return; // Para a execução aqui
    } 
    
    if (fabRaw === "") {
        alert("Preencha o campo fabricação");
        form.fab.focus();
        return;
    } 

    if (categoria === "") {
        alert("Preencha o campo categoria");
        form.categoria.focus();
        return;
    } 

    if (faixa === "") {
        alert("Preencha o campo Faixa Etária");
        form.faixa.focus();
        return;
    } 

    if (preco === "" || preco === "R$ 0,00") {
        alert("Preencha o campo preço");
        form.preco.focus();
        return;
    }

    // 3. Se chegou aqui, todos os campos estão preenchidos. 
    // Agora fazemos as conversões para o Banco de Dados.

    // Converter Data (DD/MM/AAAA para AAAA-MM-DD)
    let dataArray = fabRaw.split('/');
    if (dataArray.length === 3) {
        let dataFormatada = dataArray[2] + "-" + dataArray[1] + "-" + dataArray[0];
        // Usamos o name do campo em vez de getElementById para evitar erro de null
        form.fab.value = dataFormatada;
    }

    // Limpar o Preço (Remover R$, espaços e converter vírgula em ponto)
    let precoLimpo = preco.replace(/[R$\s.]/g, '').replace(',', '.');
    form.preco.value = precoLimpo;

    // Limpar a Faixa Etária (manter apenas números)
    let faixaLimpa = faixa.replace(/\D/g, '');
    form.faixa.value = faixaLimpa;

    // 4. Enviar o formulário
    form.submit();
}

