package tp3.main;

import tp3.controle.Loja;
import tp3.pessoa.Endereco;
import tp3.produto.Chocolate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

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
                LocalDate.of(2021, 9, 10), 12.0, 33.2,
                25.0, true, true, false, "Menta",
                new String[]{"Castanha"}, 30);

        loja.cadastrarChocotone(loja.getProximoIdChocolate(), 500, "Chocotone Delicioso",
                "O melhor chocotone", "Gourmet", LocalDate.of(2021, 9, 10),
                8.0, 20.0, 10, true, true, false,
                "Doce de leite", new String[]{"Morango"}, 20);

        loja.cadastrarTrufa(loja.getProximoIdChocolate(), 20, "Trufa Trufada", "Trufa de trufas",
                "Ao leite", LocalDate.of(2021, 9, 10), 0.5, 2.0,
                20, true, true, false, "Licor", true, 100);


        // Mostrando estoque
        System.out.println(loja.getEstoque().stringEstoque());

        // Fazendo venda
        Chocolate ch1 = loja.getEstoque().getChocolatePorId(0);
        Chocolate ch2 = loja.getEstoque().getChocolatePorId(1);
        HashMap<Chocolate, Integer> vendidos = new HashMap<>();
        vendidos.put(ch1, 10);
        vendidos.put(ch2, 15);

        loja.fazerVenda(vendidos, loja.getProximoIdVenda(), loja.getClientePorId(0),
                loja.getFuncionarioPorId(0), LocalDate.now());

        // Informações da venda
        System.out.println(loja.stringVendas());

    }
}
