package tp3.controle;

import tp3.produto.Chocolate;

import java.util.HashMap;

public class Estoque {
    private final HashMap<Chocolate, Integer> chocolates;

    public Estoque() {
        chocolates = new HashMap<>();
    }

    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolates.put(chocolate, chocolates.getOrDefault(chocolate, 0) + quantidade);
    }

    public void retirarQuantidade(Chocolate chocolate, int quantidade) {
        if (!chocolates.containsKey(chocolate)) {
            throw new IllegalArgumentException("Produto não está no estoque");
        }

        if (quantidade == 0) {
            throw new IllegalArgumentException("Quantidade não pode ser 0");
        }

        if (quantidade > chocolates.get(chocolate)) {
            throw new IllegalArgumentException(String.format("Quantidade %d maior do que em estoque (%d)",
                    quantidade, chocolates.get(chocolate)));
        }

        chocolates.put(chocolate, chocolates.get(chocolate) - quantidade);
    }

    public String stringChocolates() {
        return chocolates.toString();
    }
}
