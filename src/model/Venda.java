package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Classe que representa uma venda.
 * @author Guilherme
 * @version 1.0
 */
public class Venda {
  private final int id;
  private final LocalDate data;
  private double valor;
  private Cliente cliente;
  private Funcionario funcionario;
  private HashMap<Chocolate, Integer> chocolateVendidos;

  /**
   * @param id representa o id da venda.
   * @param cliente representa o cliente que fez a venda.
   * @param funcionario representa o funcionario que fez a venda.
   * @param data representa a data da venda.
   */
  public Venda(int id, Cliente cliente, Funcionario funcionario, LocalDate data) {
    this.id = id;
    this.cliente = cliente;
    this.funcionario = funcionario;
    this.data = data;
    chocolateVendidos = new HashMap<>();
  }

  /**
   * Transforma em String
   * @return String do id e do nome.
   */
  @Override
  public String toString() {
    return String.format("%d - %s", this.id, this.cliente.getNome());
  }

  /**
   * Adiciona um chocolate na venda.
   * @param chocolate chocolate que será adicionado.
   * @param quantidade quantidade de chocolates que serão adicionados.
   */
  public void adicionarChocolate(Chocolate chocolate, int quantidade) {
    chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
  }

  public void retirarChocolate(Chocolate chocolate) {

  }

  /**
   * Calcula o valor da venda.
   */
  public void calcularValor() {
    double valorVenda = 0;

    for (Chocolate chocolate : chocolateVendidos.keySet()) {
      valorVenda += chocolate.getPrecoVenda() * chocolateVendidos.get(chocolate);
    }

    valor = valorVenda;
  }

  /**
   * Retorna a representação em string de uma compra.
   * @return representação em string de uma compra.
   */
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
