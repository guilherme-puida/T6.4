/*
TP3 - T6.4

Guilherme Puida Moreira - 200019015
Tiago Leão Buson - 200034162

Na especificação do TP3 não era pedido menu interativo, então a Main desse projeto testa e comprova o funcionamento
dos métodos implementados

Alguns métodos foram implementados e não usados, como diversos gets e sets. Contudo, eles serão úteis no desenvolvimento
do TP4.
 */

/*
        // Cadastro de clientes inciais:
        loja.cadastrarCliente(loja.getProximoIdCliente(), 19, "Guilherme", "000.000.000-00", "99999-9999",
                "email@email.com", new Endereco("Asa Norte", "SQN", "307", "00000-00"),
                "diamante");
        loja.cadastrarCliente(loja.getProximoIdCliente(), 25, "Marcelo", "000.000.000-00", "99999-9999",
                "email@email.com", new Endereco("Asa Sul", "SQS", "102", "00001-00"),
                "bronze");

        // Cadastro dos funcionários iniciais:
        loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 23, "Antonio", "000.000.000-00",
                "99999-9999", "email@email.com",
                new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
                1000.00, "Caixa");
        loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 34, "Ana", "000.000.000-00",
                "99999-9999", "email@email.com",
                new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
                30000.00, "Gerente");

        // Cadastro dos produtos iniciais:
        loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Incrível",
                "Uma incrível barra de chocolate", "Meio-Amargo",
                LocalDate.of(2021, 9, 10), 10.0, 20.0,
                70.0, true, true, true, "Chocolate",
                new String[]{"Amendoim", "Nozes"}, 25);
        loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Sensacional",
                "Barra sensacional de chocolate", "Ao Leite",
                LocalDate.of(2021, 5, 10), 12.0, 33.2,
                25.0, true, true, false, "Menta",
                new String[]{"Castanha"}, 30);

        loja.cadastrarChocotone(loja.getProximoIdChocolate(), 500, "Chocotone Delicioso",
                "O melhor chocotone", "Gourmet", LocalDate.of(2021, 9, 10),
                8.0, 20.0, 10, true, true, false,
                "Doce de leite", new String[]{"Morango"}, 20);

        loja.cadastrarTrufa(loja.getProximoIdChocolate(), 20, "Trufa Trufada", "Trufa de trufas",
                "Ao leite", LocalDate.of(2021, 7, 10), 0.5, 2.0,
                20, true, true, false, "Licor", true, 100);


        // Mostrando estoque
        System.out.println("====Estoque====");
        System.out.println(loja.getEstoque().stringEstoque());

        // Mostrando clientes
        System.out.println("====Clientes====");
        System.out.println(loja.stringClientes());

        // Mostrando Funcionários
        System.out.println("====Funcionarios====");
        System.out.println(loja.stringFuncionarios());

        // Fazendo venda
        Chocolate ch1 = loja.getEstoque().getChocolatePorId(0);
        Chocolate ch2 = loja.getEstoque().getChocolatePorId(1);
        HashMap<Chocolate, Integer> vendidos = new HashMap<>();
        vendidos.put(ch1, 10);
        vendidos.put(ch2, 15);

        loja.fazerVenda(vendidos, loja.getProximoIdVenda(), loja.getClientePorId(0),
                loja.getFuncionarioPorId(0), LocalDate.now());

        // Informações da venda
        System.out.println("====Venda feita====");
        System.out.println(loja.getVendaPorId(0).info());

        // Mostrando novamente o estoque
        System.out.println("====Estoque atualizado, com os produtos vendidos retirados====");
        System.out.println(loja.getEstoque().stringEstoque());

        // Pesquisando cliente por nome:
        System.out.println("====Pesquisando o cliente 'Guilherme'====");
        System.out.println(loja.getClientePorNome("Guilherme").infoBasica());
        System.out.println(loja.getClientePorNome("Guilherme").infoCompleta());
        System.out.println();

        // Pesquisando funcionário por nome:
        System.out.println("====Pesquisando o funcionário 'Antonio'====");
        System.out.println(loja.getFuncionarioPorNome("Antonio").infoBasica());
        System.out.println(loja.getFuncionarioPorNome("Antonio").infoCompleta());
        System.out.println();

        // Editando cliente
        System.out.println("====Editando o cliente 'Guilherme'====");
        System.out.println(loja.getClientePorNome("Guilherme").infoCompleta());
        System.out.println("----Alterando a idade de 19 para 20----");
        loja.getClientePorNome("Guilherme").setIdade(20);
        System.out.println(loja.getClientePorNome("Guilherme").infoCompleta());
        System.out.println();

        // Removendo um cliente da lista
        System.out.println("====Removendo o cliente 'Marcelo'====");
        System.out.println(loja.stringClientes());
        System.out.println("----Com cliente removido----");
        loja.removerCliente(loja.getClientePorNome("Marcelo"));
        System.out.println(loja.stringClientes());

        // Editando um chocotone
        System.out.println("====Editando um chocotone====");
        System.out.println(loja.getEstoque().getChocolatePorNome("Chocotone Delicioso").infoBasica());
        System.out.println("----Editando o chocotone----");
        Chocotone chocotone = (Chocotone) loja.getEstoque().getChocolatePorNome("Chocotone Delicioso");
        chocotone.setNome("O Melhor Chocotone");
        chocotone.setPeso(600);
        chocotone.addFruta("Maça");
        System.out.println(chocotone.infoBasica());
        System.out.println();

        // Calculando gastos e lucro no mes de setembro de 2021
        System.out.println("====Calculando gastos e lucro em setembro de 2021");
        System.out.println("Os gastos em 09/21 foram de: " + loja.calcularGastosMes(9, 2021));
        System.out.println("O lucro em 09/21 foi de: " + loja.calcularLucroMes(9, 2021));
        */
import model.Loja;
import model.Endereco;
import view.MainFrame;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Loja loja = new Loja();
        carregar_clientes(loja);

        MainFrame frame = new MainFrame("teste");
    }

    public static void carregar_clientes(Loja loja) {
        loja.cadastrarCliente(loja.getProximoIdCliente(), 19, "Guilherme", "000.000.000-00", "99999-9999",
                "email@email.com", new Endereco("Asa Norte", "SQN", "307", "00000-00"),
                "diamante");
        loja.cadastrarCliente(loja.getProximoIdCliente(), 25, "Marcelo", "000.000.000-00", "99999-9999",
                "email@email.com", new Endereco("Asa Sul", "SQS", "102", "00001-00"),
                "bronze");

        // Cadastro dos funcionários iniciais:
        loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 23, "Antonio", "000.000.000-00",
                "99999-9999", "email@email.com",
                new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
                1000.00, "Caixa");
        loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 34, "Ana", "000.000.000-00",
                "99999-9999", "email@email.com",
                new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
                30000.00, "Gerente");

        // Cadastro dos produtos iniciais:
        loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Incrível",
                "Uma incrível barra de chocolate", "Meio-Amargo",
                LocalDate.of(2021, 9, 10), 10.0, 20.0,
                70.0, true, true, true, "Chocolate",
                new String[]{"Amendoim", "Nozes"}, 25);
        loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Sensacional",
                "Barra sensacional de chocolate", "Ao Leite",
                LocalDate.of(2021, 5, 10), 12.0, 33.2,
                25.0, true, true, false, "Menta",
                new String[]{"Castanha"}, 30);

        loja.cadastrarChocotone(loja.getProximoIdChocolate(), 500, "Chocotone Delicioso",
                "O melhor chocotone", "Gourmet", LocalDate.of(2021, 9, 10),
                8.0, 20.0, 10, true, true, false,
                "Doce de leite", new String[]{"Morango"}, 20);

        loja.cadastrarTrufa(loja.getProximoIdChocolate(), 20, "Trufa Trufada", "Trufa de trufas",
                "Ao leite", LocalDate.of(2021, 7, 10), 0.5, 2.0,
                20, true, true, false, "Licor", true, 100);
    }
}
