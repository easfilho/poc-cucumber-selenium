# language: pt

Funcionalidade: Fazer login
  Eu como cliente do site
  Quero fazer login
  Para que possa fazer compras no site

  Esquema do Cenario: Deve validar o e-mail para fazer login
    Dado que acesso a página de login
    E que informo no campo "<campo>" o valor "<valor>"
    Quando clicar no botão "Sign in"
    Então deve mostrar a mensagem de validação "<mensagem>"
    Exemplos:
      | campo | valor         | mensagem                   |
      | Email |               | An email address required. |
      | Email | emailInvalido | Invalid email address.     |

  Esquema do Cenario: Deve validar a senha para fazer login
    Dado que acesso a página de login
    E que informo no campo "Email" o valor "barbara.tavares@unicred.com.br"
    E que informo no campo "<campo>" o valor "<valor>"
    Quando clicar no botão "Sign in"
    Então deve mostrar a mensagem de validação "<mensagem>"
    Exemplos:
      | campo | valor | mensagem              |
      | Senha |       | Password is required. |

  Cenario: Deve redirecionar para tela de esqueci senha
    Dado que acesso a página de login
    Quando clicar no botão esqueci senha
    Então deve redirecionar para tela de "esqueci senha"



