function enviarFotografo(){
	let xhr = new XMLHttpRequest();
	xhr.open('POST', '/fotografo');

	let nome = document.getElementById("nome").value;
	let email = document.getElementById("email").value;
	let telefone = document.getElementById("tel").value;
	
	let novo_u = {
			"nome": nome,
	        "email": email,
	        "telefone": telefone,
	        "album": []}

	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send( JSON.stringify(novo_u));
	window.location.reload();
}

function getFotografo(id){
	let xhr = new XMLHttpRequest();
	let link = "/fotografo/"+id;
	alert(link);
	//xhr.open('GET', link);
	//xhr.send();
}

function cadastrarFotografo(){
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/fotografo');
	xhr.onload = function(){
		if(this.status == 200){

			let r = JSON.parse(this.responseText);
			
			let tb = document.getElementById("fotografos");
			
			r.content.forEach(f => {
					tb.innerHTML += 
						`<tr>
							<td>${f.nome}</td>
							<td>${f.email}</td>
							<td>${f.telefone}</td>
							<td><button onclick="deletarFotografo(${f.id})">Deletar</button></td>
							<td><button onclick="atualizarFotografo(${f.id})">Editar</button></td>
						</tr>`
			});
		}
	}
	xhr.send();
}

cadastrarFotografo();

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