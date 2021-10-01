package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Venda {
  private final int id;
  private final LocalDate data;
  private double valor;
  private Cliente cliente;
  private Funcionario funcionario;
  private HashMap<Chocolate, Integer> chocolateVendidos;

  public Venda(int id, Cliente cliente, Funcionario funcionario, LocalDate data) {
    this.id = id;
    this.cliente = cliente;
    this.funcionario = funcionario;
    this.data = data;
    chocolateVendidos = new HashMap<>();
  }

  @Override
  public String toString() {
    return String.format("%d - %s", this.id, this.cliente.getNome());
  }

  // Adiciona um chocolate na venda
  public void adicionarChocolate(Chocolate chocolate, int quantidade) {
    chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
  }

  // Calcula o valor da venda
  public void calcularValor() {
    double valorVenda = 0;

    for (Chocolate chocolate : chocolateVendidos.keySet()) {
      valorVenda += chocolate.getPrecoVenda() * chocolateVendidos.get(chocolate);
    }

    valor = valorVenda;
  }

  // Representação em string de uma compra
  public String info() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format("Id: %d | Cliente: %s | Funcionário: %s | Valor: %.2f | Data: %s%n", id,
            cliente.getNome(), funcionario.getNome(), valor, data.format(dtf));
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public int getId() {
    return id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public LocalDate getData() {
    return data;
  }

  public HashMap<Chocolate, Integer> getChocolateVendidos() {
    return chocolateVendidos;
  }

  public void setChocolateVendidos(HashMap<Chocolate, Integer> vendidos) {
      chocolateVendidos = vendidos;
  }
}
