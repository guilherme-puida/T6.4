package tp3.controle;

import tp3.pessoa.Cliente;
import tp3.pessoa.Funcionario;
import tp3.produto.Chocolate;


import java.time.LocalDate;
import java.util.HashMap;


public class Venda {
    private int id;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private LocalDate data;
    private final HashMap<Chocolate, Integer> chocolateVendidos;

    public Venda(int id, Cliente cliente, Funcionario funcionario, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data = data;
        chocolateVendidos = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LocalDate getData() {
        return data;
    }

    public HashMap<Chocolate, Integer> getChocolateVendidos() {
        return chocolateVendidos;
    }

    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
    }

    public void calcularValor() {
        double valorVenda = 0;

        for (Chocolate chocolate: chocolateVendidos.keySet()) {
            valorVenda += chocolate.getPrecoVenda() * chocolateVendidos.get(chocolate);
        }

        valor = valorVenda;
    }

    public double getValor() {
        return valor;
    }
}
