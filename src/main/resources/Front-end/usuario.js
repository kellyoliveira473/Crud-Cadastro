document.addEventListener('DOMContentLoaded', () => {

    // Formulário de cadastro
    const cadastroForm = document.getElementById('cadastroForm');

    cadastroForm.addEventListener('submit', function(e) {
        e.preventDefault();

        const usuario = {
            nome: document.getElementById('nome').value,
            cpf: document.getElementById('cpf').value,
            email: document.getElementById('email').value,
            telefone: document.getElementById('telefone').value,
            dataNascimento: document.getElementById('datadenascimento').value,
            senha: document.getElementById('senha').value
        };

        console.log('Tentando enviar usuário:', usuario);

        fetch('http://localhost:8080/usuario', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(usuario)
        })
        .then(response => {
            if (!response.ok) throw new Error('Erro ao cadastrar usuário');
            alert('Usuário cadastrado com sucesso!');
            this.reset();
        })
        .catch(error => {
            console.error('Erro ao enviar:', error);
            alert('Erro ao cadastrar usuário');
        });

    });

    // Produtos disponíveis
    const produtos = [
        {id: 1, nome: "Pão Francês", preco: 0.50},
        {id: 2, nome: "Croissant", preco: 2.50},
        {id: 3, nome: "Bolo de Chocolate", preco: 15.00},
        {id: 4, nome: "Café", preco: 3.00}
    ];

    const produtosList = document.getElementById('produtosList');
    const carrinhoList = document.getElementById('carrinhoList');
    const totalSpan = document.getElementById('total');
    let carrinho = [];

    // Exibe produtos
    function exibirProdutos() {
        produtosList.innerHTML = '';
        produtos.forEach(prod => {
            const div = document.createElement('div');
            div.classList.add('produto');
            div.innerHTML = `
                <p>${prod.nome}</p>
                <p>R$ ${prod.preco.toFixed(2)}</p>
                <button onclick="adicionarCarrinho(${prod.id})">Adicionar</button>
            `;
            produtosList.appendChild(div);
        });
    }

    // Adiciona produto ao carrinho
    window.adicionarCarrinho = function(id) {
        const produto = produtos.find(p => p.id === id);
        carrinho.push(produto);
        atualizarCarrinho();
    }

    // Atualiza carrinho
    function atualizarCarrinho() {
        carrinhoList.innerHTML = '';
        let total = 0;

        carrinho.forEach((item, index) => {
            total += item.preco;
            const div = document.createElement('div');
            div.classList.add('carrinho-item');
            div.innerHTML = `
                <p>${item.nome} - R$ ${item.preco.toFixed(2)}</p>
                <button onclick="removerCarrinho(${index})">Remover</button>
            `;
            carrinhoList.appendChild(div);
        });

        totalSpan.textContent = total.toFixed(2);
    }

    // Remove item do carrinho
    window.removerCarrinho = function(index) {
        carrinho.splice(index, 1);
        atualizarCarrinho();
    }

    // Inicializa produtos
    exibirProdutos();

});
