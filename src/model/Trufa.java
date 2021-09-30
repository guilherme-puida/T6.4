package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trufa extends Chocolate {
  private String recheio;
  private boolean alcoolico;

  public Trufa(
      int id,
      int peso,
      String nome,
      String descricao,
      String tipo,
      LocalDate dataCompra,
      double precoCompra,
      double precoVenda,
      double porcentagemCacau,
      boolean contemGluten,
      boolean contemLactose,
      boolean artesanal,
      String recheio,
      boolean alcoolico) {
    super(
        id,
        peso,
        nome,
        descricao,
        tipo,
        dataCompra,
        precoCompra,
        precoVenda,
        porcentagemCacau,
        contemGluten,
        contemLactose,
        artesanal);
    this.recheio = recheio;
    this.alcoolico = alcoolico;
  }

  public String infoBasica() {
    return String.format(
        "Id: %d | Nome: %s | Peso: %dg | Recheio: %s | Alcoólico: %s | Preço: %.2f",
        super.getId(), super.getNome(), super.getPeso(), recheio, alcoolico, super.getPrecoVenda());
  }

  public String infoCompleta() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format(
        "Id:%d|Peso:%d|Nome:%s|Descrição:%s|Tipo:%s|Data de compra:%s|"
            + "Preco da compra:$%.2f|Preco de venda:.%.2f|Porcentagem de Cacau:%.2f|"
            + "Gluten:%s|Lactose:%s|Artesanal:%s|Recheio:%s|Alcoolico:%s",
        super.getId(),
        super.getPeso(),
        super.getNome(),
        super.getDescricao(),
        super.getTipo(),
        super.getDataCompra().format(dtf),
        super.getPrecoCompra(),
        super.getPrecoVenda(),
        super.getPorcentagemCacau(),
        super.isContemGluten(),
        super.isContemLactose(),
        super.isArtesanal(),
        recheio,
        alcoolico);
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
