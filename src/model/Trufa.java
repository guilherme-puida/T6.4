package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa uma unidade de Trufa.
 */
public class Trufa extends Chocolate {
  private String recheio;
  private boolean alcoolico;

  /**
   * Representa uma unidade de Trufa.
   * @param id representa o id da trufa.
   * @param peso representa o peso da trufa.
   * @param nome representa o nome da trufa.
   * @param descricao representa a descrição da trufa.
   * @param tipo representa o tipo da trufa.
   * @param dataCompra representa a data da compra da trufa.
   * @param precoCompra representa o preço de venda da trufa.
   * @param precoVenda representa o preço de venda da trufa.
   * @param porcentagemCacau representa a porcentagem de cacau da trufa.
   * @param contemGluten representa a opção de glutem da trufa.
   * @param contemLactose representa a opção de lactose da trufa.
   * @param artesanal representa a opção artesanal da trufa.
   * @param recheio representa o recheio da trufa.
   * @param alcoolico representa a opção alcoolica da trufa.
   */
  public Trufa(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra
          , double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
               boolean contemLactose, boolean artesanal, String recheio, boolean alcoolico) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);
    this.recheio = recheio;
    this.alcoolico = alcoolico;
  }

  /**
   * Retorna as informações basicas da Trufa.
   * @return String de informações basicas da Trufa.
   */
  public String infoBasica() {
    return String.format("Id: %d | Nome: %s | Peso: %dg | Recheio: %s | Alcoólico: %s | Preço: %" +
            ".2f", super.getId(), super.getNome(), super.getPeso(), recheio, alcoolico,
            super.getPrecoVenda());
  }

  /**
   * Retorna as informações completas da Trufa.
   * @return String de informações completas da Trufa.
   */
  public String infoCompleta() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format("Id:%d|Peso:%d|Nome:%s|Descrição:%s|Tipo:%s|Data de compra:%s|" + "Preco" +
            " da compra:$%.2f|Preco de venda:.%.2f|Porcentagem de Cacau:%.2f|" + "Gluten:%s" +
            "|Lactose:%s|Artesanal:%s|Recheio:%s|Alcoolico:%s", super.getId(), super.getPeso(),
            super.getNome(), super.getDescricao(), super.getTipo(),
            super.getDataCompra().format(dtf), super.getPrecoCompra(), super.getPrecoVenda(),
            super.getPorcentagemCacau(), super.isContemGluten(), super.isContemLactose(),
            super.isArtesanal(), recheio, alcoolico);
  }

  public String getRecheio() {
    return recheio;
  }

  public void setRecheio(String recheio) {
    this.recheio = recheio;
  }

  public boolean isAlcoolico() {
    return alcoolico;
  }

  public void setAlcoolico(boolean alcoolico) {
    this.alcoolico = alcoolico;
  }
}
