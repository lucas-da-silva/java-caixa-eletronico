package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {

  private static final double QUANTIA = 100.00;
  private static final String DESCRICAO = "Saque";

  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(QUANTIA, DESCRICAO);
    assertEquals(QUANTIA, transacao.getQuantia());
    assertEquals(DESCRICAO, transacao.getDescricao());
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(QUANTIA, DESCRICAO);
    assertEquals(QUANTIA, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(QUANTIA, DESCRICAO);
    assertEquals(DESCRICAO, transacao.getDescricao());
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(QUANTIA, DESCRICAO);
    assertEquals(transacao.retornarInstante(), transacao.getInstante());
  }

}
