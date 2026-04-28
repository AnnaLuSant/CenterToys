function confirmar(idcon) {
    //console.log(idcon); // <-- verifica se vem valor
    let resposta = confirm("Confirma a exclusão deste produto?");
	
    if (resposta === true) {
        window.location.href = "delete?idcon=" + idcon
    }
}
