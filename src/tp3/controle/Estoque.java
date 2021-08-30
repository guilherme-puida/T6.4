package tp3.controle;

import tp3.produto.Chocolate;

import java.util.HashMap;

public class Estoque {
    private HashMap<Chocolate, Integer> chocolates;

    public Estoque() {
        chocolates = new HashMap<>();
    }

    public void adicionarChocolate(Chocolate chocolate, int quantidade) {
        chocolates.put(chocolate, chocolates.getOrDefault(chocolate, 0) + quantidade);
    }
    


}
