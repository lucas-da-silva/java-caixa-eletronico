package com.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  /**
   * Construtor da classe Transacao.
   *
   * @param quantia   Quantia da transação.
   * @param descricao Descrição da transação.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = this.retornarInstante();
  }

  public double getQuantia() {
    return this.quantia;
  }

  /**
   * Retorna o resumo da transação.
   *
   * @return Resumo da transação.
   */
  public String retornarResumoTransacao() {
    String iconeTransacao;

    if (this.descricao.contains("Saque") || this.descricao.contains("Transferência enviada")) {
      iconeTransacao = " -";
    } else {
      iconeTransacao = " +";
    }

    return this.instante + " -------- " + this.descricao + ": R$ " + quantia + iconeTransacao;
  }

  public String retornarInstante() {
    return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
  }

  public String getDescricao() {
    return this.descricao;
  }

  public String getInstante() {
    return this.instante;
  }

}

