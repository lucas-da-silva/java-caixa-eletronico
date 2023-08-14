package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  private static final String NOME = "Camaragibe Oliveira";
  private static final String CPF = "433.892.200-11";
  private static final String SENHA = "1234";
  private static final String CONTA_CORRENTE = "Corrente";
  private static final String CONTA_POUPANCA = "Poupanca";

  private Banco banco;

  @BeforeEach()
  public void setUp() {
    this.banco = new Banco();
  }


  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    String numeroConta = banco.gerarNumeroNovaConta();
    assertEquals(10, numeroConta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    assertEquals(0, banco.getPessoasClientes().size());
    assertNotNull(banco.adicionarPessoaCliente(NOME, CPF, SENHA));
    assertEquals(1, banco.getPessoasClientes().size());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    PessoaCliente cliente = banco.adicionarPessoaCliente(NOME, CPF, SENHA);
    banco.adicionarConta(CONTA_CORRENTE, cliente);
    assertNotNull(banco.pessoaClienteLogin(CPF, SENHA));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    int primeiraConta = 0;
    int segundaConta = 1;

    PessoaCliente cliente = banco.adicionarPessoaCliente(NOME, CPF, SENHA);

    banco.adicionarConta(CONTA_CORRENTE, cliente);
    banco.adicionarConta(CONTA_POUPANCA, cliente);
    banco.depositar(cliente, primeiraConta, 2000);
    banco.transferirFundos(cliente, primeiraConta, segundaConta, 1000);

    assertEquals(1000, cliente.retornarSaldoContaEspecifica(primeiraConta));
    assertEquals(1000, cliente.retornarSaldoContaEspecifica(segundaConta));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    PessoaCliente cliente = banco.adicionarPessoaCliente(NOME, CPF, SENHA);
    banco.adicionarConta(CONTA_CORRENTE, cliente);
    banco.depositar(cliente, 0, 2000);
    banco.sacar(cliente, 0, 1000);

    assertEquals(1000, cliente.retornarSaldoContaEspecifica(0));
  }

}
