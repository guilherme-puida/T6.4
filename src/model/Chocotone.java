package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa uma unidade de Chocotone.
 * @author Guilherme
 * @version 1.0
 */
public class Chocotone extends Chocolate {
  private final ArrayList<String> frutas = new ArrayList<>();
  private String recheio;

  /**
   * Representa uma unidade de Chocotone.
   * @param id representa o id do Chocotone.
   * @param peso representa o peso do Chocotone.
   * @param nome representa o nome do Chocotone.
   * @param descricao representa a descrição do Chocotone.
   * @param tipo representa o tipo do Chocotone.
   * @param dataCompra representa a data da compra do Chocotone.
   * @param precoCompra representa o preço de venda do Chocotone.
   * @param precoVenda representa o preço de venda do Chocotone.
   * @param porcentagemCacau representa a porcentagem de cacau do Chocotone.
   * @param contemGluten representa a opção de glutem do Chocotone.
   * @param contemLactose representa a opção de lactose do Chocotone.
   * @param artesanal representa a opção artesanal do Chocotone.
   * @param recheio representa o recheio do Chocotone
   * @param frutas representa as frutas do Chocotone
   */
  public Chocotone(int id, int peso, String nome, String descricao, String tipo,
                   LocalDate dataCompra, double precoCompra, double precoVenda,
                   double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                   boolean artesanal, String recheio, String[] frutas) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);

    this.recheio = recheio;
    Collections.addAll(this.frutas, frutas);
  }

  /**
   * Retorna as informações basicas do chocotone.
   * @return String de informações basicas do chocotone.
   */
  public String infoBasica() {
    return String.format("Id: %d | Nome: %s | Peso: %d | Sabor: %s | Nibs: %s | Preço: %.2f",
            super.getId(), super.getNome(), super.getPeso(), recheio, String.join(", ", frutas),
            super.getPrecoVenda());
  }

  /**
   * Retorna as informações completas do chocotone.
   * @return String de informações completas do chocotone.
   */
  public String infoCompleta() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format("Id:%d|Peso:%d|Nome:%s|Descrição:%s|Tipo:%s|Data de compra:%s|" + "Preco" +
            " da compra:$%.2f|Preco de venda:.%.2f|Porcentagem de Cacau:%.2f|" + "Gluten:%s" +
            "|Lactose:%s|Artesanal:%s|Recheio:%s|Frutas:%s", super.getId(), super.getPeso(),
            super.getNome(), super.getDescricao(), super.getTipo(),
            super.getDataCompra().format(dtf), super.getPrecoCompra(), super.getPrecoVenda(),
            super.getPorcentagemCacau(), super.isContemGluten(), super.isContemLactose(),
            super.isArtesanal(), recheio, String.join(", ", frutas));
  }

  public String getRecheio() {
    return recheio;
  }

  public void setRecheio(String recheio) {
    this.recheio = recheio;
  }

  public String getFrutas() {
    return frutas.toString();
  }

  public void setFrutas(String[] frutas) {
    this.frutas.clear();
    Collections.addAll(this.frutas, frutas);
  }
  //TODO tirar addFruta e removeFruta
}
