# language: pt

Funcionalidade: Incluir conta de usuário
  Eu como cliente do site
  Quero cadastrar minha conta de usuário
  Para que possa fazer compras no site

  Cenário: Deve verificar se o email é válido
    Dado que clico no botão "Sign in"
    Quando clicar no botão "Create an account"
    Então deve mostrar a mensagem de validação "Invalid email address."