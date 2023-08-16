package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {

  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<>();
  private ArrayList<Conta> contas = new ArrayList<>();

  /**
   * Gera um número aleatório e único de 10 dígitos e verifica se ele já existe no banco de dados.
   *
   * @return Número aleatório e único de 10 dígitos.
   */
  public String gerarNumeroNovaConta() {
    String numero = this.gerarNumeroAleatorio();

    while (true) {
      boolean numeroJaExiste = false;

      for (Conta conta : this.contas) {
        if (conta.getIdConta().equals(numero)) {
          numeroJaExiste = true;
          break;
        }
      }

      if (numeroJaExiste) {
        numero = this.gerarNumeroAleatorio();
      } else {
        break;
      }
    }

    return numero;
  }

  private String gerarNumeroAleatorio() {
    StringBuilder numero = new StringBuilder();

    for (int i = 0; i < 10; i++) {
      int digito = new Random().nextInt(10);
      numero.append(digito);
    }

    return numero.toString();
  }

  /**
   * Adiciona uma nova pessoa cliente ao banco de dados.
   *
   * @param nome  Nome da pessoa cliente.
   * @param cpf   CPF da pessoa cliente.
   * @param senha Senha da pessoa cliente.
   * @return A pessoa cliente adicionada.
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoaCliente);
    return pessoaCliente;
  }

  /**
   * Adiciona uma nova conta ao banco de dados.
   *
   * @param tipo    Tipo da conta: "Corrente" ou "Poupança".
   * @param cliente Pessoa cliente que está criando a conta.
   */
  public void adicionarConta(String tipo, PessoaCliente cliente) {
    Conta novaConta = new Conta(tipo, cliente, this);
    cliente.adicionarConta(novaConta);
    this.contas.add(novaConta);
  }

  /**
   * Realiza o login de uma pessoa cliente.
   *
   * @param cpf   CPF da pessoa cliente.
   * @param senha Senha da pessoa cliente.
   * @return A pessoa cliente que realizou o login.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoaCliente : pessoasClientes) {
      if (pessoaCliente.getCpf().equals(cpf) && pessoaCliente.validarSenha(senha)) {
        return pessoaCliente;
      }
    }

    return null;
  }

  /**
   * Transfere fundos de uma conta para outra.
   *
   * @param pessoaCliente Pessoa cliente que está realizando a transferência.
   * @param daConta       Número da conta de onde os fundos serão retirados.
   * @param paraConta     Número da conta para onde os fundos serão enviados.
   * @param valor         Valor a ser transferido.
   */

  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      double valor) {
    Conta contaDebitada = pessoaCliente.retornarContaEspecifica(daConta);
    Conta contaCreditada = pessoaCliente.retornarContaEspecifica(paraConta);

    contaDebitada.adicionarTransacao(valor, "Transferência enviada");
    contaCreditada.adicionarTransacao(valor, "Transferência recebida");
  }

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    Conta clienteConta = pessoaCliente.retornarContaEspecifica(daConta);
    clienteConta.adicionarTransacao(quantia, "Saque");
  }

  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    Conta contaDeposito = pessoaCliente.retornarContaEspecifica(paraConta);
    contaDeposito.adicionarTransacao(quantia, "Depósito recebido");
  }

  /**
   * Mostra o extrato de uma conta.
   *
   * @param pessoaCliente Pessoa cliente que está solicitando o extrato.
   * @param conta         Número da conta que terá o extrato mostrado.
   */
  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    Conta contaExtrato = pessoaCliente.retornarContaEspecifica(conta);
    System.out.println("\n\nExtrato da conta " + contaExtrato.getIdConta());
    contaExtrato.retornarExtrato();
  }

  public ArrayList<PessoaCliente> getPessoasClientes() {
    return this.pessoasClientes;
  }

  public ArrayList<Conta> getContas() {
    return this.contas;
  }

}
