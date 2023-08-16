package com.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {

  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<>();

  /**
   * Construtor da classe PessoaCliente.
   *
   * @param nome  Nome completo da pessoa.
   * @param cpf   CPF da pessoa.
   * @param senha Senha da pessoa.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;

    System.out.println("Nova pessoa cliente " + nome + " com CPF: " + cpf + " criada!");
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  public Conta retornarContaEspecifica(int indice) {
    return this.contas.get(indice);
  }


  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  /**
   * Imprime o resumo das contas da pessoa.
   */
  public void retornarResumoContas() {
    System.out.println("\n\nResumo das contas da pessoa " + this.nomeCompleto + ":");
    for (int i = 0; i < this.contas.size(); i++) {
      System.out.println((i + 1) + ") " + this.contas.get(i).retornarResumoConta());
    }
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getNomeCompleto() {
    return this.nomeCompleto;
  }

}
