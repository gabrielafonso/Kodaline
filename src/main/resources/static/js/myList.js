

// function enviarFotografo(){
// 	let xhr = new XMLHttpRequest();
// 	xhr.open('POST', '/fotografo');

// 	let nome = document.getElementById("nome").value;
// 	let email = document.getElementById("email").value;
// 	let telefone = document.getElementById("tel").value;
	
// 	let novo_u = {
// 			"nome": nome,
// 	        "email": email,
// 	        "telefone": telefone,
// 	        "album": []}

// 	xhr.setRequestHeader('Content-Type', 'application/json');
// 	xhr.send( JSON.stringify(novo_u));
// 	window.location.reload();
// }

// function getFotografo(id){
// 	let xhr = new XMLHttpRequest();
// 	let link = "/fotografo/"+id;
// 	alert(link);
	//xhr.open('GET', link);
	//xhr.send();
//}

function enviarFotografo(){
	let nome = document.getElementById("nome").value;
	let email = document.getElementById("email").value;
	let senha = document.getElementById("password").value;;
	let data = {
		"nome": nome,
		"email": email,
		"password": senha
	}

	fetch("/fotografo",{
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(data)
	}).then(function(response){
		listarFotografo();
	}).catch(function(error){
		console.log(error);
	})
}

// function cadastrarFotografo(){
// 	let xhr = new XMLHttpRequest();
// 	xhr.open('GET', '/fotografo');
// 	xhr.onload = function(){
// 		if(this.status == 200){

// 			let r = JSON.parse(this.responseText);
			
// 			let tb = document.getElementById("fotografos");
			
// 			r.content.forEach(f => {
// 					tb.innerHTML += 
// 						`<tr>
// 							<td>${f.nome}</td>
// 							<td>${f.email}</td>
// 							<td>${f.telefone}</td>
// 							<td><button onclick="deletarFotografo(${f.id})">Deletar</button></td>
// 							<td><button onclick="atualizarFotografo(${f.id})">Editar</button></td>
// 						</tr>`
// 			});
// 		}
// 	}
// 	xhr.send();
// }

function listarFotografo(){

	fetch("/fotografo").then(function(response){
		if(response.status >= 200 && response.status <= 300){
			//console.log(response);
			response.json().then(function(data){
				let table = document.getElementById("fotografos");
				//console.log(data);
				table.innerHTML = "<tr><td>Nome</td><td>E-mail</td><td>Senha</td><td>Opções de gerenciamento</td></tr>"
				for(let i = 0; i < data.content.length ;i++){
					let f = data.content[i];
					//console.log(f);
					table.innerHTML += `<tr><td>${f.nome}</td><td>${f.email}</td><td>${f.password}</td><td><button onclick="deletarFotografo(${f.id})">Deletar</button></td><td><button onclick="atualizarFotografo(${f.id})">Editar</button></td></tr>`
				}	
			});
			
		}
	});
	
}

listarFotografo();

function deletarFotografo(id){
	let xhr = new XMLHttpRequest();
	let link = "/fotografo/"+id;
	xhr.open('DELETE', link);
	xhr.send();
	window.location.reload();
}

function atualizarFotografo(id){
	let xhr = new XMLHttpRequest();
	var fotografo = xhr
}