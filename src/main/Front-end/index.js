document.getElementById("FormUsuario").addEventListener("submit",async function(e){
    e.preventDefault();
    const usuario={
        nome:document.getElementById("nome").value,
 cpf:document.getElementById("cpf").value,
 dataNascimento:document.getElementById("dataNascimento").value,
 email:document.getElementById("email").value,
 telefone:document.getElementById("telefone").value
    };
    try{
        const Response=await fetch("http://localhost:8080/usuario",{
            method:"POST",
        Headers:{"Content-type":"application/JSON"},
        body:JSON.stringify(usuario)
    });

        if(Response.status ===201){
            alert("Usuario cadastro com sucesso !");
            document.getElementById("FormUsuario").reset();
        }else {
            alert("Erro ao cadastrar usuario");

        }
    }catch(error){
        alert("Erro de conexao com servidor");
        console.error(error);

    }
        
    });
    async function BuscarUsuario(){
        const id =document.getElementById("BuscarId").value;
        try{
                const Response = await fetch(`http://localhost:8080/usuario?id=${id}`);
                if(Response.ok){
                    const usuario= await Response.json();
                    document.getElementById("resultado").textContent=JSON.stringify(usuario,null,2);
                }else{
                    document.getElementById("resultado").textContent="Usuario nao encontrado";
                }


        }catch(errror){
            document.getElementById("Resultado").textContent="error ao buscar usuario";
            console.error(error)
        }
    }
