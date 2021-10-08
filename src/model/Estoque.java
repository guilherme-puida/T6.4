package model;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa o estoque de produtos e seus metodos.
 */
public class Estoque {
  private final HashMap<Chocolate, Integer> chocolates;

  /**
   * Representa o estoque de chocolates em um HashMap.
   */
  public Estoque() {
    chocolates = new HashMap<>();
  }

  /**
   * Adiciona o chocolate no mapa de chocolates.
   * @param chocolate chocolate que será adicionado no mapa de chocolates.
   * @param quantidade quantidade desse chocolate que será adicionado.
   */
  public void adicionarChocolate(Chocolate chocolate, int quantidade) {
    chocolates.put(chocolate, chocolates.getOrDefault(chocolate, 0) + quantidade);
  }

  /**
   * Retira certa quantidade de chocolate do map.
   * @param chocolate chocolate que será retirado do mapa.
   * @param quantidade quantidade desse chocolate que será retirado.
   * @throws IllegalArgumentException quando o produto não esta no estoque, ou a quantidade for 0, ou a quantidade for maior do que em estoque.
   */
  public void retirarQuantidade(Chocolate chocolate, int quantidade) throws IllegalArgumentException {
    if (!chocolates.containsKey(chocolate)) {
      throw new IllegalArgumentException("Produto não está no estoque");
    }

    if (quantidade == 0) {
      throw new IllegalArgumentException("Quantidade não pode ser 0");
    }

    if (quantidade > chocolates.get(chocolate)) {
      throw new IllegalArgumentException(String.format("Quantidade %d maior do que em estoque " +
              "(%d)", quantidade, chocolates.get(chocolate)));
    }

    chocolates.put(chocolate, chocolates.get(chocolate) - quantidade);
  }

  /**
   * Pesquisa um chocolate por Id.
   * @param id inteiro id do chocolate.
   * @return chocolate do id requerido.
   */
  public Chocolate getChocolatePorId(int id) {
    for (Chocolate chocolate : getChocolates()) {
      if (chocolate.getId() == id) {
        return chocolate;
      }
    }

    return null;
  }

  public Set<Chocolate> getChocolates() {
    return chocolates.keySet();
  }

  /**
   * Pesquisa um chocolate por Nome.
   * @param nome nome do chocolate
   * @return chocolate do nome requerido.
   */
  public Chocolate getChocolatePorNome(String nome) {
    for (Chocolate chocolate : getChocolates()) {
      if (Objects.equals(chocolate.getNome(), nome)) {
        return chocolate;
      }
    }

    return null;
  }

  public int getQuantidadeEmEstoque(Chocolate chocolate) {
    return chocolates.get(chocolate);
  }

  /**
   * Remove o chocolate do estoque.
   * @param chocolate chocolate que será removido.
   */
  public void removerChocolate(Chocolate chocolate) {
    chocolates.remove(chocolate);
  }

  public void setQuantidade(Chocolate chocolate, int quantidade) {
    chocolates.put(chocolate, quantidade);
  }
}
