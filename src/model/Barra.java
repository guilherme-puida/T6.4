package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Barra extends Chocolate {
  private final ArrayList<String> nibs = new ArrayList<>();
  private String sabor;

  public Barra(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra
          , double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
               boolean contemLactose, boolean artesanal, String sabor, String[] nibs) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);

    this.sabor = sabor;
    Collections.addAll(this.nibs, nibs);
  }

  public String infoBasica() {
    return String.format("Id: %d | Nome: %s | Peso: %dg | Sabor: %s | Nibs: %s | Preço: %.2f",
            super.getId(), super.getNome(), super.getPeso(), sabor, String.join(", ", nibs),
            super.getPrecoVenda());
  }

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

  public void addNib(String nib) {
    if (!nibs.contains(nib)) {
      nibs.add(nib);
    }
  }

  public void removeNib(String nib) {
    nibs.remove(nib);
  }
}
