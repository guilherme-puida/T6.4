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

    public boolean retirarQuantidade(Chocolate chocolate, int quantidade) {
        if (quantidade == 0 || !chocolates.containsKey(chocolate)) {
            return false;
        }

        if (quantidade > chocolates.get(chocolate)) {
            return false;
        }

        chocolates.put(chocolate, chocolates.get(chocolate) - quantidade);
        return true;
    }

    public String stringChocolates() {
        return chocolates.toString();
    }
}
