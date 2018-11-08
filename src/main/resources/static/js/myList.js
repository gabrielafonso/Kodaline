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
	xhr.send( JSON.stringify(novo_u) );
}

function cadastrarFotografo(){
	let xhr2 = new XMLHttpRequest();
	xhr2.open('GET', '/fotografo');
	
	xhr2.onload = function(){
		if(this.status == 200){

			let r = JSON.parse(this.responseText);
			
			let tb = document.getElementById("fotografos");
			
			r.content.forEach(f => {
					tb.innerHTML += 
						`<tr>
							<td>${f.nome}</td>
							<td>${f.email}</td>
							<td>${f.telefone}</td>
							</tr>`
			});
		}
	}
	xhr2.send();
}

cadastrarFotografo();