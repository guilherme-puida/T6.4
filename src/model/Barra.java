package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa uma unidade da Barra.
 * @author Guilherme
 * @version 1.0
 */
public class Barra extends Chocolate {
  private final ArrayList<String> nibs = new ArrayList<>();
  private String sabor;

  /**
   * Representa uma unidade da Barra.
   * @param id representa o id da barra.
   * @param peso representa o peso da barra.
   * @param nome representa o nome da barra.
   * @param descricao representa a descrição da barra.
   * @param tipo representa o tipo da barra.
   * @param dataCompra representa a data da compra da barra.
   * @param precoCompra representa o preço de compra da barra.
   * @param precoVenda representa o preço de venda da barra.
   * @param porcentagemCacau representa a porcentagem de cacau da barra.
   * @param contemGluten representa a opção de glutem da barra.
   * @param contemLactose representa a opção de lactose da barra.
   * @param artesanal representa a opção artesanal da barra.
   * @param sabor representa o sabor da barra.
   * @param nibs representa os nibs da barra.
   */
  public Barra(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra
          , double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
               boolean contemLactose, boolean artesanal, String sabor, String[] nibs) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);

    this.sabor = sabor;
    Collections.addAll(this.nibs, nibs);
  }

  /**
   * Retorna as informações basicas da Barra.
   * @return String de informações basicas da barra.
   */
  public String infoBasica() {
    return String.format("Id: %d | Nome: %s | Peso: %dg | Sabor: %s | Nibs: %s | Preço: %.2f",
            super.getId(), super.getNome(), super.getPeso(), sabor, String.join(", ", nibs),
            super.getPrecoVenda());
  }

  /**
   * Retorna as informações completas da Barra.
   * @return String de informações completas da barra.
   */
  public String infoCompleta() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format("Id:%d|Peso:%d|Nome:%s|Descrição:%s|Tipo:%s|Data de compra:%s|" + "Preco" +
            " da compra:$%.2f|Preco de venda:.%.2f|Porcentagem de Cacau:%.2f|" + "Gluten:%s" +
            "|Lactose:%s|Artesanal:%s|Sabor:%s|Nibs:%s", super.getId(), super.getPeso(),
            super.getNome(), super.getDescricao(), super.getTipo(),
            super.getDataCompra().format(dtf), super.getPrecoCompra(), super.getPrecoVenda(),
            super.getPorcentagemCacau(), super.isContemGluten(), super.isContemLactose(),
            super.isArtesanal(), sabor, String.join(", ", nibs));
  }

  public String getSabor() {
    return sabor;
  }

  public void setSabor(String sabor) {
    this.sabor = sabor;
  }

  public String getNibs() {
    return nibs.toString();
  }

  public void setNibs(String[] nibs) {
    this.nibs.clear();
    Collections.addAll(this.nibs, nibs);
  }
}
//TODO tirar addNib e removeNib