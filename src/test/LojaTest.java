package test;

import model.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LojaTest {

  Loja loja;

  @BeforeEach
  void init() {
    loja = Loja.getInstance();

    Endereco e1 = new Endereco("Asa Norte", "307", "F", "70746-060");
    Endereco e2 = new Endereco("Asa Norte", "SQN", "Colina", "00000-00");

    loja.cadastrarCliente(
            loja.getProximoIdCliente(),
            19,
            "Guilherme",
            "000.000.000-00",
            "61 99999-9999",
            "guilherme@guilherme.xyz",
            e1,
            "Diamante");

    loja.cadastrarCliente(
            loja.getProximoIdCliente(),
            19,
            "Tiago",
            "111.111.111-11",
            "61 98888-8888",
            "tiago@tiago.xyz",
            e2,
            "Super Diamante"
    );

    loja.cadastrarFuncionario(
            loja.getProximoIdFuncionario(),
            25,
            "Marcelo",
            "222.222.222-22",
            "61 97777-7777",
            "marcelo@marcelo.xyz",
            e1,
            1500.0,
            "Caixa"
    );

    loja.cadastrarFuncionario(
            loja.getProximoIdFuncionario(),
            19,
            "Kassem",
            "333.333.333-33",
            "61 96666-6666",
            "kassem@kassem.xyz",
            e2,
            600.0,
            "Jovem Aprendiz"
    );
  }

  @AfterEach
  void teardown() {
    loja.reset();
  }

  @Test
  @DisplayName("Pesquisar funcionário por ID")
  void getFuncionarioPorId() {
    System.out.println(Arrays.toString(loja.getFuncionarios()));
    Funcionario c1 = loja.getFuncionarioPorId(1);
    Funcionario c2 = loja.getFuncionarioPorId(2);
    Funcionario c3 = loja.getFuncionarioPorId(3);
    assertAll(
            () -> assertEquals("Marcelo", c1.getNome()),
            () -> assertEquals("Kassem", c2.getNome()),
            () -> assertNull(c3)
    );
  }

  @Test
  @DisplayName("Pesquisar funcionário por nome.")
  void getFuncionarioPorNome() {
    Funcionario c1 = loja.getFuncionarioPorNome("Marcelo");
    Funcionario c2 = loja.getFuncionarioPorNome("Kassem");
    Funcionario c3 = loja.getFuncionarioPorNome("AAAAAAAAAAAAA");

    assertAll(
            () -> assertEquals("Marcelo", c1.getNome()),
            () -> assertEquals("Kassem", c2.getNome()),
            () -> assertNull(c3)
    );
  }

  @Test
  @DisplayName("Remover funcionário")
  void removerFuncionario() {
    Funcionario c1 = loja.getFuncionarioPorId(1);
    assertEquals(2, loja.getFuncionarios().length);

    loja.removerFuncionario(c1);

    assertEquals(1, loja.getFuncionarios().length);
  }

  @Test
  @DisplayName("Pesquisar cliente por nome.")
  void getClientePorId() {
    Cliente c1 = loja.getClientePorId(1);
    Cliente c2 = loja.getClientePorId(2);
    Cliente c3 = loja.getClientePorId(3);

    assertAll(
            () -> assertEquals("Guilherme", c1.getNome()),
            () -> assertEquals("Tiago", c2.getNome()),
            () -> assertNull(c3)
    );
  }

  @Test
  @DisplayName("Pesquisar cliente por nome.")
  void getClientePorNome() {
    Cliente c1 = loja.getClientePorNome("Guilherme");
    Cliente c2 = loja.getClientePorNome("Tiago");
    Cliente c3 = loja.getClientePorNome("AAAAAAAAAAAAA");

    assertAll(
            () -> assertEquals("Guilherme", c1.getNome()),
            () -> assertEquals("Tiago", c2.getNome()),
            () -> assertNull(c3)
    );
  }

  @Test
  @DisplayName("Remover cliente")
  void removerCliente() {
    Cliente c1 = loja.getClientePorId(1);
    assertEquals(2, loja.getClientes().length);

    loja.removerCliente(c1);

    assertEquals(1, loja.getClientes().length);
  }
}

























