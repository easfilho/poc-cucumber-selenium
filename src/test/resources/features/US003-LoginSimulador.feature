#language: pt

Funcionalidade: US003 Fazer login
  Eu como operador
  Quero fazer login
  Para que eu possa utilizar o sistema

  Cenário: Deve fazer login quando passados parâmetros de entrada válidos
    Dado que acesso o simulador
    E que informo o nome "Camila"
    E que informo a senha "123456"
    E que seleciono a cooperativa "566"
    Quando clico no botão entrar
    Então deve fazer o login
    E deve redirecionar para a tela "Plataforma de Crédito"