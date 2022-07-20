# Multiverso Marvel App
Repositório do nosso Projeto Integrador para a Digital House

O App Multiverso Marvel foi criado para oferecer aos fãs de quadrinhos acesso a informações sobre seus heróis e HQs favoritas.
Com a opção de selecionar heróis favoritos e encontrar suas histórias em quadrinhos para serem adquiridas pela internet.

- Arquitetura MVVM.
- Registro e Login pelo Firebase, utilizando e-mail, Google ou Facebook.
- Lista de heróis adquirida pelo consumo da API Marvel, utilizando Retrofit, Glide e Recycler View.
- Página com detalhes de cada herói, com informação também adquirida pelo consumo da API: Nome, Descrição e Quadrinhos que aparece.
- Adicionamos também valores de poderes fictícios e a opção de adicionar o herói em uma lista de favoritos, que fica armazenada no banco de dados interno do celular, utilizando Room e SQLite. 
- Opção ‘Procurar HQ’ que realiza uma pesquisa no Google com o nome do quadrinho.
- Opção ‘Ler Agora’ que abre o app Marvel Unlimited caso o usuário o possua em seu celular. Caso ele não possua, é levado à página de download do app na Play Store.

