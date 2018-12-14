//const inputLogin = document.getElementById('login-nav');
//inputLogin.addEventListener('keyup', function(e){
//  var key = e.which || e.keyCode;
//  if (key == 13) {
//		let email = document.getElementById("login-nome").value;
//		let senha = document.getElementById("login-senha").value;
//		fetch("/fotografo").then(function(response){
//			if(response.status >= 200 && response.status <= 300){
//				response.json().then(function(data){
//					for(let i = 0; i < data.content.length ;i++){
//						let f = data.content[i];
//						if((`${f.email}` == email || `${f.nome}` == email) && `${f.password}` == senha){
//							console.log(f);
//							localStorage.setItem("user", f.id);
//							console.log(localStorage);
//							alert("Usuario - " + `${f.id}` + " - falta agora redirecionar para página de usuario / " + localStorage);
//							document.location = 'paginaUsuario.html';
//						}
//					}
//				});
//			}
//		}).catch(function(error){
//			console.log(error);
//		});
//  }
//});

const inputLogin = document.getElementById('login-nav');
inputLogin.addEventListener('keyup', function(e){
  var key = e.which || e.keyCode;
  if (key == 13) {
		let email = document.getElementById("login-nome").value;
		let password = document.getElementById("login-senha").value;
		let data = {
			"email": email,
			"password": password
		}
	
		fetch("/login",{
			method: "POST",
			headers: {
				"Content-Type": "application/JSON"
			},
			body: JSON.stringify(data)
		}).then(function(response){
			
			response.json().then(function(user){
//				console.log(user);
//				console.log(user.id);

				let usuario = JSON.stringify(user);
				localStorage.setItem("user", usuario);
				
				document.location = 'paginaUsuario.html';
			});
		}).catch(function(error){
			console.log(error);
		});
  }
});

function validarCadastro(){
	let nome = document.getElementById("name-cadastro").value;
	let email = document.getElementById("email-cadastro").value;
	let senha = document.getElementById("senha-cadastro").value;
	let conf_senha = document.getElementById("confirmacao-senha").value;
	
	let form_nome = document.getElementById("nome-erro");
	let form_email = document.getElementById("email-erro");
	let form_senha = document.getElementById("senha-erro");
	let form_csenha = document.getElementById("csenha-erro");
	form_nome.innerHTML = "";
	form_email.innerHTML = "";
	form_senha.innerHTML = "";
	form_csenha.innerHTML = "";
	
	let cadnome = false;
	let cademail = false;
	let cadsenha = false;
	
	if(nome == "" || nome == null || nome.length < 5) {
        form_nome.innerHTML += "<p>O nome deve conter mais de 5 caracteres."
    }else cadnome = true;
	
	if(senha == null || senha == "" || senha.length < 8){
        form_senha.innerHTML += "<p>A senha deve conter mais de 8 caracteres."
        	form_csenha.innerHTML += "<p>A senha deve conter mais de 8 caracteres."
	}else if(senha != conf_senha){
        form_senha.innerHTML += "<p>As senhas estão diferentes."
        	form_csenha.innerHTML += "<p>As senhas estão diferentes."
	}else cadsenha = true;
    if(email.indexOf("@") == -1 || email.indexOf(".") == -1 || email == "" || email == null) {
    	form_email.innerHTML += "<p>Insira um e-mail válido."
    }else cademail = true;
    
    return ((cadnome && cadsenha) && cademail);
}

function cadastrarFotografo(){
	if(validarCadastro()){
		let nome = document.getElementById("name-cadastro").value;
		let email = document.getElementById("email-cadastro").value;
		let senha = document.getElementById("senha-cadastro").value;;
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
			let form = document.getElementById("formulario-cadastro");
			form.innerHTML += "Cadastrado com sucesso!";
			
			
		}).catch(function(error){
			console.log(error);
		})
	}
}

verificarLoginFeito();
function verificarLoginFeito(){
//	console.log(JSON.parse(localStorage.getItem("user")).id);
	
	if(JSON.parse(localStorage.getItem("user")) != null){
		window.location.href="paginaUsuario.html"
	}	
}
