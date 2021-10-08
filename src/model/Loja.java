package model;

import java.time.LocalDate;
import java.util.*;

public class Loja {
  private static final Loja instance = new Loja();

  private final Estoque estoque;
  private final ArrayList<Funcionario> funcionarios;
  private final ArrayList<Cliente> clientes;
  private final ArrayList<Venda> vendas;

  private int clienteId = 0;
  private int funcionarioId = 0;
  private int produtoId = 0;
  private int vendaId = 0;

  private Loja() {
    this.estoque = new Estoque();
    this.funcionarios = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.vendas = new ArrayList<>();
  }

  public void reset() {
    clientes.clear();
    funcionarios.clear();
    vendas.clear();
    estoque.clear();

    clienteId = 0;
    funcionarioId = 0;
    produtoId = 0;
    vendaId = 0;
  }

  public static Loja getInstance() {
    return instance;
  }

  // Cadastra um novo cliente na lista de clientes
  public void cadastrarCliente(int id, int idade, String nome, String cpf, String telefone,
                               String email, Endereco endereco, String categoria) {
    clientes.add(new Cliente(id, idade, nome, cpf, telefone, email, endereco, categoria));
  }

  // Cadastra um novo funcionário na lista de funcionários
  public void cadastrarFuncionario(int id, int idade, String nome, String cpf, String telefone,
                                   String email, Endereco endereco, double salario, String cargo) {
    funcionarios.add(new Funcionario(id, idade, nome, cpf, telefone, email, endereco, salario,
            cargo));
  }

  // Cadastra uma nova barra na lista de chocolates
  public void cadastrarBarra(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String sabor, String[] nibs, int quantidade) {
    estoque.adicionarChocolate(new Barra(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, sabor, nibs),
            quantidade);
  }

  // Cadastra uma nova trufa na lista de chocolates
  public void cadastrarTrufa(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String recheio, boolean alcoolico, int quantidade) {
    estoque.adicionarChocolate(new Trufa(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, recheio,
            alcoolico), quantidade);
  }

  // Cadastra um novo chocotone na lista de chocolates
  public void cadastrarChocotone(int id, int peso, String nome, String descricao, String tipo,
                                 LocalDate dataCompra, double precoCompra, double precoVenda,
                                 double porcentagemCacau, boolean contemGluten,
                                 boolean contemLactose, boolean artesanal, String recheio,
                                 String[] frutas, int quantidade) {
    estoque.adicionarChocolate(new Chocotone(id, peso, nome, descricao, tipo, dataCompra,
            precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal,
            recheio, frutas), quantidade);
  }

  public int getProximoIdCliente() {
    clienteId++;
    return clienteId;
  }

  public int showProximoIdCliente() {
    return clienteId + 1;
  }

  public int getProximoIdFuncionario() {
    funcionarioId++;
    return funcionarioId;
  }

  public int showProximoIdFuncionario() {
    return funcionarioId + 1;
  }

  public int getProximoIdChocolate() {
    produtoId++;
    return produtoId;
  }

  public int showProximoIdChocolate() {
    return produtoId + 1;
  }

  public int getProximoIdVenda() {
    vendaId++;
    return vendaId;
  }

  public int showProximoIdVenda() {
    return vendaId + 1;
  }

  // Calcula o lucro de determinado mes
  public double calcularLucroMes(int mes, int ano) throws IllegalArgumentException {
    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException("Mês inválido");
    }

    double gastos = calcularGastosMes(mes, ano);
    double receita = 0;

    for (Venda venda : vendas) {
      LocalDate dataVenda = venda.getData();
      if (dataVenda.getMonthValue() == mes && dataVenda.getYear() == ano) {
        receita += venda.getValor();
      }
    }

    return receita - gastos;
  }

  // Calcula os gastos em um determinado mes
  public double calcularGastosMes(int mes, int ano) throws IllegalArgumentException {
    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException("Mês inválido");
    }
    double gastos = 0;

    for (Chocolate chocolate : estoque.getChocolates()) {
      LocalDate dataCompra = chocolate.getDataCompra();
      if (dataCompra.getMonthValue() == mes && dataCompra.getYear() == ano) {
        gastos += chocolate.getPrecoCompra();
      }
    }

    for (Funcionario funcionario : funcionarios) {
      gastos += funcionario.getSalario();
    }

    return gastos;
  }

  // Realiza uma venda, retirando a quantidade de chocolates vendidos do estoque
  public void fazerVenda(Map<Chocolate, Integer> chocolatesQuantidades, int id,
                         Cliente cliente, Funcionario funcionario, LocalDate data) {
    Venda venda = new Venda(id, cliente, funcionario, data);

    for (Chocolate chocolate : chocolatesQuantidades.keySet()) {
      try {
        estoque.retirarQuantidade(chocolate, chocolatesQuantidades.get(chocolate));
        venda.adicionarChocolate(chocolate, chocolatesQuantidades.get(chocolate));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        return;
      }
    }

    venda.calcularValor();
    vendas.add(venda);
  }

  // Pesquisa um cliente por id
  public Cliente getClientePorId(int id) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  // Pesquisa um cliente pelo nome
  public Cliente getClientePorNome(String nome) {
    for (Cliente cliente : clientes) {
      if (Objects.equals(cliente.getNome(), nome)) {
        return cliente;
      }
    }
    return null;
  }

  // Pesquisa um funcionario por id
  public Funcionario getFuncionarioPorId(int id) {
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getId() == id) {
        return funcionario;
      }
    }

    return null;
  }

  // Pesquisa um funcionario pelo nome
  public Funcionario getFuncionarioPorNome(String nome) {
    for (Funcionario funcionario : funcionarios) {
      if (Objects.equals(funcionario.getNome(), nome)) {
        return funcionario;
      }
    }
    return null;
  }

  // Pesquisa uma venda por id
  public Venda getVendaPorId(int id) {
    for (Venda venda : vendas) {
      if (venda.getId() == id) {
        return venda;
      }
    }

    return null;
  }

  // Representação em string de todas as vendas
  public String stringVendas() {
    StringBuilder s = new StringBuilder();
    for (Venda venda : vendas) {
      s.append(venda.info()).append("\n");
    }

    return s.toString();
  }

  // Representação em string de todos os funcionários
  public String stringFuncionarios() {
    StringBuilder s = new StringBuilder();
    for (Funcionario funcionario : funcionarios) {
      s.append(funcionario.infoBasica()).append("\n");
    }

    return s.toString();
  }

  // Representação em string de todos os clientes
  public String stringClientes() {
    StringBuilder s = new StringBuilder();
    for (Cliente cliente : clientes) {
      s.append(cliente.infoBasica()).append("\n");
    }
    return s.toString();
  }

  // Remove um funcionário da lista
  public void removerCliente(Cliente cliente) {
    clientes.remove(cliente);
  }

  // Remove um cliente da lista
  public void removerFuncionario(Funcionario funcionario) {
    funcionarios.remove(funcionario);
  }

  // Remove uma venda da lista
  public void removerVenda(Venda venda) {
    vendas.remove(venda);
  }

  public Cliente[] getClientes() {
    return clientes.toArray(new Cliente[0]);
  }

  public Funcionario[] getFuncionarios() {
    return funcionarios.toArray(new Funcionario[0]);
  }

  public Venda[] getVendas() {
    return this.vendas.toArray(new Venda[0]);
  }

  public Estoque getEstoque() {
    return estoque;
  }
}
