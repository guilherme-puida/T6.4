package tp3.controle;

import tp3.produto.Chocolate;

import java.util.HashMap;
import java.util.Set;

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

    public Set<Chocolate> getChocolates() {
        return chocolates.keySet();
    }

    public int getQuantidade(Chocolate chocolate) {
        return chocolates.get(chocolate);
    }

    public Chocolate getChocolatePorId(int id) {
        for (Chocolate chocolate: getChocolates()) {
            if (chocolate.getId() == id) {
                return chocolate;
            }
        }

        return null;
    }

    public String stringEstoque() {
        StringBuilder repr = new StringBuilder();

        for (Chocolate chocolate: getChocolates()) {
            repr.append(chocolate.infoBasica());
            repr.append(" | Quantidade: ").append(chocolates.get(chocolate)).append("\n");
        }

        return repr.toString();
    }
}
