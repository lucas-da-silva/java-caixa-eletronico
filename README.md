<h1 align="center">Sistema de Caixa Eletrônico</h1>

## Sobre o projeto

Aplicação Java simula um caixa eletrônico, oferecendo saque, depósito, transferência e consulta de extrato. Desenvolvida com TDD para máxima confiabilidade e qualidade.

## Exemplo de uso

```
Bem-vindo ao Banco


Entre com seu CPF: 433.892.200-11
Entre com sua senha: 1234


Resumo das contas da pessoa Camaragibe Oliveira:
1) 7533278583 : R$0.0 : Poupança
2) 6172914945 : R$0.0 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 3
Entre com o número (1-2) para selecionar a conta para depósito: 1
Entre com a quantia de depósito: R$ 2000


Resumo das contas da pessoa Camaragibe Oliveira:
1) 7533278583 : R$2000.0 : Poupança
2) 6172914945 : R$0.0 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 3
Entre com o número (1-2) para selecionar a conta para depósito: 2
Entre com a quantia de depósito: R$ 4000


Resumo das contas da pessoa Camaragibe Oliveira:
1) 7533278583 : R$2000.0 : Poupança
2) 6172914945 : R$4000.0 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 4
Entre o número (1-2) para retirar o valor para transferência: 2
Entre o número (1-2) para selecionar a conta que receberá a transferência: 1
Entre com a quantia para ser transferida (máximo R$4000,00): R$ 2000


Resumo das contas da pessoa Camaragibe Oliveira:
1) 7533278583 : R$4000.0 : Poupança
2) 6172914945 : R$2000.0 : Corrente


O que você gostaria de fazer?
  1) Mostrar Extrato
  2) Sacar
  3) Depositar
  4) Transferir
  5) Sair

Entre com sua opção: 1
Entre com o número (1-2) para a conta
que o extrato será impresso: 1


Extrato da conta 7533278583
16/08/2023 11:20:11 -------- Depósito recebido: R$ 2000.0 +
16/08/2023 11:20:32 -------- Transferência recebida: R$ 2000.0 +


Resumo das contas da pessoa Camaragibe Oliveira:
1) 7533278583 : R$4000.0 : Poupança
2) 6172914945 : R$2000.0 : Corrente
```

## Tecnologias utilizadas

- [Java](https://www.java.com/pt-BR/) - Linguagem de programação orientada a objetos;
- [Maven](https://maven.apache.org/) - Gerenciador de dependências;
- [JUnit](https://junit.org/junit5/) - Framework para testes unitários.

## Funcionalidades

- Logar no sistema;
- Visualizar e manipular as informações da sua conta bancária;
- Ter acesso a todas as transações feitas.

## Instalação

```bash
# Clonar Projeto
$ git clone git@github.com:lucas-da-silva/java-caixa-eletronico.git

# Entrar no diretório
$ cd java-caixa-eletronico

# Execute o arquivo CaixaEletronico.java
```

## Estrutura do projeto

```
$PROJECT_ROOT
|   # Arquivos de configuração do Maven
├── .mvn
|   # Código fonte da aplicação
└── src
    |   # Classes da aplicação
    ├── main
    |   # Testes unitários
    └── test

```

## Autor

- [@lucas-da-silva](https://github.com/lucas-da-silva)
