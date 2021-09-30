package view;

import model.Venda;

public class VendaDetails extends DetailsPanel {

  private Venda currentVenda;

  public VendaDetails() {
    super("Detalhes da venda:");
  }

  public Venda getCurrentVenda() {
    return currentVenda;
  }

  public void setCurrentVenda(Venda currentVenda) {
    this.currentVenda = currentVenda;
  }
}
