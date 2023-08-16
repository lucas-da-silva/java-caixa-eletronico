package com.acc.java.caixaeletronico;

import java.util.Scanner;

public class CaixaEletronico {

  /**
   * Método principal do programa.
   *
   * @param args Argumentos passados para o programa.
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Banco banco = new Banco();

    PessoaCliente pessoaCliente1 =
        banco.adicionarPessoaCliente("Alexiania Pereira", "842.074.410-77", "1234");
    banco.adicionarConta("Poupança", pessoaCliente1);
    banco.adicionarConta("Corrente", pessoaCliente1);

    PessoaCliente pessoaCliente2 =
        banco.adicionarPessoaCliente("Abadiania Silva", "848.725.510-87", "1234");
    banco.adicionarConta("Poupança", pessoaCliente2);
    banco.adicionarConta("Corrente", pessoaCliente2);

    PessoaCliente pessoaCliente3 =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    banco.adicionarConta("Poupança", pessoaCliente3);
    banco.adicionarConta("Corrente", pessoaCliente3);

    while (true) {

      System.out.println("\n\nBem-vindo ao Banco\n\n");
      System.out.print("Entre com seu CPF: ");
      String pessoaClienteCpf = sc.nextLine();
      System.out.print("Entre com sua senha: ");
      String senha = sc.nextLine();

      PessoaCliente pessoaClienteAutenticada = banco.pessoaClienteLogin(pessoaClienteCpf, senha);

      if (pessoaClienteAutenticada == null) {
        System.out.println("\n\nCombinação de CPF e senha incorretos. Tente novamente");

      } else {

        int op;

        do {

          pessoaClienteAutenticada.retornarResumoContas();

          System.out.println("\n\nO que você gostaria de fazer?");
          System.out.println("  1) Mostrar Extrato");
          System.out.println("  2) Sacar");
          System.out.println("  3) Depositar");
          System.out.println("  4) Transferir");
          System.out.println("  5) Sair");
          System.out.println();
          System.out.print("Entre com sua opção: ");

          op = sc.nextInt();

          if (op < 1 || op > 5) {
            System.out.println("Opção inválida, escolha uma opção válida.");
          }

          if (op == 1) {

            int conta;

            do {
              System.out.printf(
                  "Entre com o número (1-%d) para a conta\nque " + "o extrato será impresso: ",
                  pessoaClienteAutenticada.retornaNumeroDeContas());
              conta = sc.nextInt() - 1;
              if (conta < 0 || conta >= pessoaClienteAutenticada.retornaNumeroDeContas()) {
                System.out.println("Número inválido, tente novamente.");
              } else {
                break;
              }
            } while (true);

            banco.mostrarExtrato(pessoaClienteAutenticada, conta);


          } else if (op == 2) {

            int deConta;
            double quantia;
            double saldoConta;

            do {
              System.out.printf("Entre o número (1-%d) para selecionar a conta para " + "o saque: ",
                  pessoaClienteAutenticada.retornaNumeroDeContas());
              deConta = sc.nextInt() - 1;
              if (deConta < 0 || deConta >= pessoaClienteAutenticada.retornaNumeroDeContas()) {
                System.out.println("Índice de conta inválido, tente novamente.");
              } else {
                break;
              }
            } while (true);

            saldoConta = pessoaClienteAutenticada.retornarSaldoContaEspecifica(deConta);

            do {
              System.out.printf("Entre com a quantia a ser sacada (máximo R$%.02f): R$ ",
                  saldoConta);
              quantia = sc.nextDouble();
              if (quantia < 0) {
                System.out.println("quantia deve ser maior que zero.");
              } else if (quantia > saldoConta) {
                System.out.printf("quantia não pode ser maior que o saldo " + "de R$ %.02f.\n",
                    saldoConta);
              } else {
                break;
              }
            } while (true);

            banco.sacar(pessoaClienteAutenticada, deConta, quantia);

          } else if (op == 3) {

            int paraConta;
            double quantia;

            do {
              System.out.printf(
                  "Entre com o número (1-%d) para selecionar a conta para " + "depósito: ",
                  pessoaClienteAutenticada.retornaNumeroDeContas());
              paraConta = sc.nextInt() - 1;

              if (paraConta < 0 || paraConta >= pessoaClienteAutenticada.retornaNumeroDeContas()) {
                System.out.println("Índice de conta inválido, tente novamente.");

              } else {
                break;
              }
            } while (true);

            do {
              System.out.printf("Entre com a quantia de depósito: R$ ");
              quantia = sc.nextDouble();

              if (quantia < 0) {
                System.out.println("quantia deve ser maior que zero.");

              } else {
                break;
              }
            } while (true);

            banco.depositar(pessoaClienteAutenticada, paraConta, quantia);

          } else if (op == 4) {

            int daConta;
            int paraConta;
            double quantia;
            double saldoConta;

            do {
              System.out.printf(
                  "Entre o número (1-%d) para " + "retirar o valor para transferência: ",
                  pessoaClienteAutenticada.retornaNumeroDeContas());
              daConta = sc.nextInt() - 1;
              if (daConta < 0 || daConta >= pessoaClienteAutenticada.retornaNumeroDeContas()) {
                System.out.println("Índice de conta inválido, tente novamente.");
              } else {
                break;
              }
            } while (true);

            saldoConta = pessoaClienteAutenticada.retornarSaldoContaEspecifica(daConta);

            do {
              System.out.printf(
                  "Entre o número (1-%d) para "
                      + "selecionar a conta que receberá a transferência: ",
                  pessoaClienteAutenticada.retornaNumeroDeContas());
              paraConta = sc.nextInt() - 1;
              if (paraConta < 0 || paraConta >= pessoaClienteAutenticada.retornaNumeroDeContas()) {
                System.out.println("Índice de conta inválido, tente novamente.");
              } else {
                break;
              }
            } while (true);

            do {

              System.out.printf("Entre com a quantia para ser transferida (máximo R$%.02f): R$ ",
                  saldoConta);
              quantia = sc.nextDouble();

              if (quantia < 0) {
                System.out.println("quantia deve ser maior que zero.");

              } else if (quantia > saldoConta) {
                System.out.printf(
                    "quantia não pode ser maior que o valor do saldo " + "de R$.02f.\n",
                    saldoConta);
              } else {
                break;
              }
            } while (true);

            banco.transferirFundos(pessoaClienteAutenticada, daConta, paraConta, quantia);

          } else if (op == 5) {
            System.out.println("Logout realizado com sucesso!");
            break;
          }

        } while (true);

      }

    }
  }
}
