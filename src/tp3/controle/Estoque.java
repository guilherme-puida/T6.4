package tp3.controle;

import tp3.produto.Chocolate;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Estoque {
    private final HashMap<Chocolate, Integer> chocolates;

    public Estoque() {
        chocolates = new HashMap<>();
    }

    // Adiciona um chocolate no mapa de chocolates
    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolates.put(chocolate, chocolates.getOrDefault(chocolate, 0) + quantidade);
    }

    // Retira certa quantidade de chocolate do map.
    public void retirarQuantidade(Chocolate chocolate, int quantidade) throws IllegalArgumentException{
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

    // Pesquisa um chocolate por Id
    public Chocolate getChocolatePorId(int id) {
        for (Chocolate chocolate: getChocolates()) {
            if (chocolate.getId() == id) {
                return chocolate;
            }
        }

        return null;
    }

    public Chocolate getChocolatePorNome(String nome) {
       for (Chocolate chocolate: getChocolates()) {
           if (Objects.equals(chocolate.getNome(), nome)) {
               return chocolate;
           }
       }

       return null;
    }

    // Representação em string do estoque
    public String stringEstoque() {
        StringBuilder repr = new StringBuilder();

        for (Chocolate chocolate: getChocolates()) {
            repr.append(chocolate.infoBasica());
            repr.append(" | Quantidade: ").append(chocolates.get(chocolate)).append("\n");
        }

        return repr.toString();
    }

    public Set<Chocolate> getChocolates() {
        return chocolates.keySet();
    }

    public int getQuantidade(Chocolate chocolate) {
        return chocolates.get(chocolate);
    }
}
