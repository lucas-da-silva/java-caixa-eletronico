package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<>();


  /**
   * Construtor da classe Conta.
   *
   * @param tipoConta     Tipo da conta.
   * @param pessoaCliente PessoaCliente dono da conta.
   * @param banco         Banco ao qual a conta pertence.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    this.transacoes.add(new Transacao(quantia, descricao));
  }

  /**
   * Retorna o saldo da conta.
   *
   * @return Saldo da conta.
   */
  public double retornarSaldo() {
    double saldo = 0;

    for (Transacao transacao : this.transacoes) {
      if (transacao.getDescricao().contains("Saque") || transacao.getDescricao()
          .contains("Transferência enviada")) {
        saldo -= transacao.getQuantia();
      } else {
        saldo += transacao.getQuantia();
      }
    }

    return saldo;
  }

  public String retornarResumoConta() {
    return this.idConta + " : " + "R$" + this.retornarSaldo() + " : " + this.tipoConta;
  }

  /**
   * Imprime o extrato da conta.
   */
  public void retornarExtrato() {
    for (Transacao transacao : this.transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }
  }

  public String getIdConta() {
    return this.idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  public String getTipoConta() {
    return this.tipoConta;
  }

  public ArrayList<Transacao> getTransacoes() {
    return this.transacoes;
  }

}
