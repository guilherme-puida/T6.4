package tp3.controle;


import tp3.pessoa.Cliente;
import tp3.pessoa.Endereco;
import tp3.pessoa.Funcionario;
import tp3.produto.Barra;
import tp3.produto.Chocolate;
import tp3.produto.Chocotone;
import tp3.produto.Trufa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Loja {
    private Estoque estoque;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;

    public Loja() {
        this.estoque = new Estoque();
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void cadastrarCliente(int id, int idade, String nome, String cpf, String telefone, String email,
                                 Endereco endereco, String categoria) {
        clientes.add(new Cliente(id, idade, nome, cpf, telefone, email, endereco, categoria));
    }

    public void cadastrarFuncionario(int id, int idade, String nome, String cpf, String telefone, String email,
                                     Endereco endereco, double salario, String cargo) {
        funcionarios.add(new Funcionario(id, idade, nome, cpf, telefone, email, endereco, salario, cargo));
    }

    public void cadastrarBarra(int id, int peso, String nome, String descricao, String tipo, Date dataCompra,
                               double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
                               boolean contemLactose, boolean artesanal, String sabor, String[] nibs, int quantidade) {
        estoque.adicionarChocolate(new Barra(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal, sabor, nibs), quantidade);
    }

    public void cadastrarTrufa(int id, int peso, String nome, String descricao, String tipo, Date dataCompra, double precoCompra,
                               double precoVenda, double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                               boolean artesanal, String recheio, boolean alcoolico, int quantidade) {
        estoque.adicionarChocolate(new Trufa(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal, recheio, alcoolico), quantidade);
    }

    public void cadastrarChocotone(int id, int peso, String nome, String descricao, String tipo, Date dataCompra, double precoCompra,
                                   double precoVenda, double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                                   boolean artesanal, String recheio, String[] frutas, int quantidade) {
        estoque.adicionarChocolate(new Chocotone(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                porcentagemCacau, contemGluten, contemLactose, artesanal, recheio, frutas), quantidade);
    }

    public double calcularGastosMes(int mes, int ano) throws IllegalArgumentException{
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido");
        }
        double gastos = 0;

        for (Chocolate chocolate: estoque.getChocolates()) {
            LocalDate dataCompra = chocolate.getDataCompra();
            if (dataCompra.getMonthValue() == mes && dataCompra.getYear() == ano) {
                gastos += chocolate.getPrecoCompra();
            }
        }

        for (Funcionario funcionario: funcionarios) {
            gastos +=  funcionario.getSalario();
        }

        return gastos;
    }

    public double calcularLucroMes(int mes, int ano) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido");
        }

        double gastos = calcularGastosMes(mes, ano);
        double receita = 0;

        for (Venda venda: vendas) {
            LocalDate dataVenda = venda.getData();
            if (dataVenda.getMonthValue() == mes && dataVenda.getYear() == ano) {
                receita += venda.getValor();
            }
        }

        return receita - gastos;
    }

    public void fazerVenda(HashMap<Chocolate, Integer> chocolatesQuantidades, int id, Cliente cliente,
                           Funcionario funcionario, LocalDate data) {
        Venda venda = new Venda(id, cliente, funcionario, data);

        for (Chocolate chocolate: chocolatesQuantidades.keySet()) {
            try {
                estoque.retirarQuantidade(chocolate, chocolatesQuantidades.get(chocolate));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        vendas.add(venda);
    }


}
