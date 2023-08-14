package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  private static final String CONTA_CORRENTE = "Corrente";
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private PessoaCliente cliente;
  private Conta conta;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

    cliente = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Banco banco = new Banco();
    conta = new Conta(CONTA_CORRENTE, cliente, banco);
  }

  @AfterEach
  public void cleanUp() {
    output.reset();
  }

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    assertEquals(CONTA_CORRENTE, conta.getTipoConta());
    assertEquals(this.cliente, conta.getPessoaCliente());
    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    conta.adicionarTransacao(100, "Depósito");
    assertEquals(100, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    String resumoConta = conta.retornarResumoConta();
    assertTrue(resumoConta.contains(conta.getIdConta()));
    assertTrue(resumoConta.contains(String.valueOf(conta.retornarSaldo())));
    assertTrue(resumoConta.contains(conta.getTipoConta()));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  public void retornarExtratoTest() {
    conta.adicionarTransacao(100, "Depósito");
    conta.adicionarTransacao(50, "Saque");

    StringBuilder extratoEsperado = new StringBuilder();

    for (Transacao transacao : conta.getTransacoes()) {
      extratoEsperado.append(transacao.retornarResumoTransacao()).append("\n");
    }

    output.reset();
    conta.retornarExtrato();
    System.setOut(originalOut);

    String extratoEsperadoLimpo = extratoEsperado.toString().replaceAll("\\r\\n", "\n").trim();
    String outputLimpo = output.toString().replaceAll("\\r\\n", "\n").trim();

    assertEquals(extratoEsperadoLimpo, outputLimpo);
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    assertEquals(cliente, conta.getPessoaCliente());
  }

}
