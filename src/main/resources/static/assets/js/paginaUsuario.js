/**
 * 
 */
carregarDados();
function carregarDados(){
	//console.log(localStorage.getItem("user"));
	let usuario = localStorage["user"];
	console.log(usuario);
	
	fetch("/fotografo/" + usuario).then(function(response){
		if(response.status >= 200 && response.status <= 300){
			//console.log(response);
			response.json().then(function(data){
				let nome_usuario = document.getElementById("nome-usuario");
				
//				console.log(data);
//				console.log(data.nome);
				
				nome_usuario.value = data.nome;
				});
		}
	});
}