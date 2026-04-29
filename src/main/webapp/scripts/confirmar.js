function confirmar(idcon) {
    
    let resposta = confirm("Confirma a exclusão deste produto?");
	
    if (resposta === true) {
        window.location.href = "delete?idcon=" + idcon
		//alert(idcon); // <-- verifica se vem valor
    }
}
