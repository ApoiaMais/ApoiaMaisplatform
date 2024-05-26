// Função para lidar com a submissão do formulário de login
function handleLogin() {
    // Coletar os dados do formulário
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Construir o corpo da requisição
    const body = JSON.stringify({ email, password });

    // Fazer a requisição AJAX para o endpoint de login
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: body
    })
    .then(response => {
        // Verificar o status da resposta
        if (response.ok) {
            // Login bem-sucedido
            console.log('Login bem-sucedido!');
            // Redirecionar para a página principal, por exemplo
            window.location.href = '/home';
        } else {
            // Lidar com erros de login
            console.error('Erro ao fazer login:', response.statusText);
            // Atualizar a interface do usuário para exibir uma mensagem de erro, por exemplo
            document.getElementById('error-message').innerText = 'Credenciais inválidas. Por favor, tente novamente.';
        }
    })
    .catch(error => {
        // Lidar com erros de rede ou outros erros
        console.error('Erro:', error);
        // Atualizar a interface do usuário para exibir uma mensagem de erro genérica, por exemplo
        document.getElementById('error-message').innerText = 'Ocorreu um erro ao processar sua solicitação. Por favor, tente novamente mais tarde.';
    });
}

// Adicionar um evento de clique ao botão de login
document.getElementById('login-button').addEventListener('click', handleLogin);
