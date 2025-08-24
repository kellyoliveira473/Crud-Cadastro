document.addEventListener('DOMContentLoaded', () => {

    // --- Lógica das Abas ---
    const tabButtons = document.querySelectorAll('.tab-button');
    const tabContents = document.querySelectorAll('.tab-content');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Remove a classe 'active' de todos os botões e conteúdos
            tabButtons.forEach(btn => btn.classList.remove('active'));
            tabContents.forEach(tab => tab.classList.remove('active'));

            // Adiciona a classe 'active' ao botão clicado e ao conteúdo correspondente
            button.classList.add('active');
            const targetTab = button.getAttribute('data-tab');
            document.getElementById(targetTab).classList.add('active');
        });
    });

    // --- Lógica de Cadastro de Usuário (com Fetch) ---
    const cadastroForm = document.getElementById('formUsuario');

    if (cadastroForm) {
        cadastroForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const usuario = {
                nome: document.getElementById('nome').value,
                cpf: document.getElementById('cpf').value,
                email: document.getElementById('email').value,
                telefone: document.getElementById('telefone').value,
            };

            // Exemplo de como usar o fetch para enviar os dados para um servidor
            // fetch('http://localhost:8080/usuario', {
            //     method: 'POST',
            //     headers: { 'Content-Type': 'application/json' },
            //     body: JSON.stringify(usuario)
            // })
            // .then(response => {
            //     if (!response.ok) throw new Error('Erro ao cadastrar usuário.');
            //     alert('Usuário cadastrado com sucesso!');
            //     this.reset();
            // })
            // .catch(error => {
            //     console.error('Erro ao enviar dados:', error);
            //     alert('Erro ao cadastrar usuário.');
            // });

            alert('Usuário cadastrado com sucesso! ');
            this.reset();
        });
    }

    // --- Lógica da Padaria e Carrinho ---
    const produtos = [
        {id: 1, nome: "Pão Francês", preco: 0.50},
        {id: 2, nome: "Pão de Queijo", preco: 2.00},
        {id: 3, nome: "Croissant", preco: 4.50},
        {id: 4, nome: "Bolo de Chocolate", preco: 25.00},
        {id: 5, nome: "Café Expresso", preco: 5.00},
        {id: 6, nome: "Suco de Laranja", preco: 8.00}
    ];

    const produtosList = document.getElementById('produtosList');
    const carrinhoList = document.getElementById('carrinhoList');
    const totalSpan = document.getElementById('total');
    const finalizarCompraBtn = document.getElementById('finalizarCompra');
    let carrinho = [];

    function exibirProdutos() {
        if (!produtosList) return;
        produtosList.innerHTML = '';
        produtos.forEach(prod => {
            const div = document.createElement('div');
            div.classList.add('produto');
            div.innerHTML = `
                <p>${prod.nome}</p>
                <p>R$ ${prod.preco.toFixed(2)}</p>
                <button class="btn-adicionar" data-id="${prod.id}">Adicionar</button>
            `;
            produtosList.appendChild(div);
        });
    }

    // Delegação de eventos para o botão Adicionar
    if (produtosList) {
        produtosList.addEventListener('click', (e) => {
            if (e.target.classList.contains('btn-adicionar')) {
                const id = parseInt(e.target.getAttribute('data-id'));
                const produto = produtos.find(p => p.id === id);
                if (produto) {
                    carrinho.push(produto);
                    atualizarCarrinho();
                }
            }
        });
    }

    function atualizarCarrinho() {
        if (!carrinhoList) return;
        carrinhoList.innerHTML = '';
        let total = 0;

        carrinho.forEach((item, index) => {
            total += item.preco;
            const div = document.createElement('div');
            div.classList.add('carrinho-item');
            div.innerHTML = `
                <p>${item.nome} - R$ ${item.preco.toFixed(2)}</p>
                <button class="btn-remover" data-index="${index}">Remover</button>
            `;
            carrinhoList.appendChild(div);
        });

        if(totalSpan) {
            totalSpan.textContent = total.toFixed(2);
        }
    }

    // Delegação de eventos para o botão Remover
    if (carrinhoList) {
        carrinhoList.addEventListener('click', (e) => {
            if (e.target.classList.contains('btn-remover')) {
                const index = parseInt(e.target.getAttribute('data-index'));
                carrinho.splice(index, 1);
                atualizarCarrinho();
            }
        });
    }

    if (finalizarCompraBtn) {
        finalizarCompraBtn.addEventListener('click', () => {
            const numeroTelefone = '5511999999999'; // Substitua pelo seu número de telefone com código do país
            let mensagem = "Olá! Gostaria de fazer o seguinte pedido:\n\n";
            let total = 0;

            if (carrinho.length === 0) {
                alert("Seu carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                return;
            }

            carrinho.forEach(item => {
                mensagem += `- ${item.nome} (R$ ${item.preco.toFixed(2)})\n`;
                total += item.preco;
            });

            mensagem += `\nTotal: R$ ${total.toFixed(2)}`;

            const url = `https://api.whatsapp.com/send?phone=${numeroTelefone}&text=${encodeURIComponent(mensagem)}`;
            window.open(url, '_blank');
        });
    }

    // --- Inicialização ---
    exibirProdutos();
    atualizarCarrinho();
});