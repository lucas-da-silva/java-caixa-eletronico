package com.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  private static final String NOME = "Camaragibe Oliveira";
  private static final String CPF = "433.892.200-11";
  private static final String SENHA = "1234";
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private PessoaCliente cliente;
  private Conta conta;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

    cliente = new PessoaCliente(NOME, CPF, SENHA);
    conta = new Conta("Corrente", cliente, new Banco());
  }

  @AfterEach
  public void cleanUp() {
    output.reset();
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    assertEquals(NOME, cliente.getNomeCompleto());
    assertEquals(CPF, cliente.getCpf());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    cliente.adicionarConta(conta);
    assertEquals(1, cliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    conta.adicionarTransacao(100, "Depósito");
    cliente.adicionarConta(conta);
    assertEquals(100, cliente.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    cliente.adicionarConta(conta);
    assertEquals(conta.getIdConta(), cliente.retornarIdContaEspecifica(0));

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    cliente.adicionarConta(conta);
    conta.adicionarTransacao(100, "Depósito");

    output.reset();
    conta.retornarExtrato();
    String extratoEsperado = output.toString().trim();

    output.reset();
    cliente.retornarExtratoContaEspecifica(0);
    String extratoRetornado = output.toString().trim();

    assertEquals(extratoEsperado, extratoRetornado);
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    cliente.adicionarConta(conta);
    cliente.adicionarTransacaoContaEspecifica(0, 100, "Depósito");
    assertEquals(100, cliente.retornarSaldoContaEspecifica(0));
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    assertTrue(cliente.validarSenha(SENHA));
    assertFalse(cliente.validarSenha("12345"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    cliente.adicionarConta(conta);

    String resumoContasEsperado = "Resumo das contas da pessoa " + NOME + ":\n"
        + "1) " + conta.retornarResumoConta();

    output.reset();
    cliente.retornarResumoContas();
    String resumoContasRetornado = output.toString().trim();

    String resumoContasEsperadoLimpo = resumoContasEsperado.replaceAll("\\r\\n", "\n");
    String resumoContasRetornadoLimpo = resumoContasRetornado.replaceAll("\\r\\n", "\n");

    assertEquals(resumoContasEsperadoLimpo, resumoContasRetornadoLimpo);
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    assertEquals(CPF, cliente.getCpf());
  }

}
