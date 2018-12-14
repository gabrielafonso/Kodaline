/**
 * 
 */
carregarDados();
function carregarDados(){
//	console.log(localStorage.getItem("user"));
	let data = JSON.parse(localStorage["user"]);

	document.getElementById("nome-usuario").innerText = data.nome;
	document.getElementById("detalhes").innerText = data.detalhes;	
}