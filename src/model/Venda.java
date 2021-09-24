package model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class Venda {
    private final int id;
    private double valor;
    private final Cliente cliente;
    private final Funcionario funcionario;
    private final LocalDate data;
    private final HashMap<Chocolate, Integer> chocolateVendidos;

    public Venda(int id, Cliente cliente, Funcionario funcionario, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data = data;
        chocolateVendidos = new HashMap<>();
    }

    // Adiciona um chocolate na venda
    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
    }

    // Calcula o valor da venda
    public void calcularValor() {
        double valorVenda = 0;

        for (Chocolate chocolate: chocolateVendidos.keySet()) {
            valorVenda += chocolate.getPrecoVenda() * chocolateVendidos.get(chocolate);
        }

        valor = valorVenda;
    }

    // Representação em string de uma compra
    public String info() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Id: %d | Cliente: %s | Funcionário: %s | Valor: %.2f | Data: %s\n",
                id, cliente.getNome(), funcionario.getNome(), valor, data.format(dtf));
    }

    public double getValor() {
        return valor;
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
}
