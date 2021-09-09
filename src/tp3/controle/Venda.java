package tp3.controle;

import tp3.pessoa.Cliente;
import tp3.pessoa.Funcionario;
import tp3.produto.Chocolate;

import java.util.Date;
import java.util.HashMap;


public class Venda {
    private int id;
    private Cliente cliente;
    private Funcionario funcionario;
    private Date data;
    private final HashMap<Chocolate, Integer> chocolateVendidos;

    public Venda(int id, Cliente cliente, Funcionario funcionario, Date data) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data = data;
        chocolateVendidos = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public HashMap<Chocolate, Integer> getChocolateVendidos() {
        return chocolateVendidos;
    }

    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
    }
}
