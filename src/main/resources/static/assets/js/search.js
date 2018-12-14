/**
 * 
 */
const inputEle = document.getElementById('pesquisa');
inputEle.addEventListener('keyup', function(e){
  var key = e.which || e.keyCode;
  if (key == 13) { 
	  console.log("asdf");
		let fotPesquisa = document.getElementById("pesquisa").value;
		fetch("/fotografo").then(function(response){
			if(response.status >= 200 && response.status <= 300){
				response.json().then(function(data){
					let fotografos = document.getElementById("fotografos");
					console.log(fotografos);
					fotografos.innerHTML = "<tr><td>Nome</td><td>E-mail</td>"
					for(let i = 0; i < data.content.length ;i++){
						let f = data.content[i];
						console.log(f);
						if(`${f.nome}` == fotPesquisa){
							fotografos.innerHTML += `<tr><td>${f.nome}</td><td><button type="button" onclick="paginaUsuario(${f.id})"></td></button>`
						}
					}
				});
			}
		});
	  
  }
});

function paginaUsuario(id){
	
	console.log(id);
	alert(id);
	
}
