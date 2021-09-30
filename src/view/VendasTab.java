package view;

import controller.VendasTabController;

import javax.swing.*;
import java.awt.*;

public class VendasTab extends JPanel {
  private final ListaPanel listaVendas;
  private final VendaDetails details;

  public VendasTab() {
    setLayout(new BorderLayout(0, 0));

    listaVendas = new ListaPanel(ListaPanel.VENDA);
    add(listaVendas, BorderLayout.LINE_START);

    details = new VendaDetails();
    add(details, BorderLayout.CENTER);

    VendasTabController controller = new VendasTabController(this);

    listaVendas.getLista().addListSelectionListener(controller);
  }

  public ListaPanel getListaVendas() {
    return listaVendas;
  }

  public VendaDetails getDetails() {
    return details;
  }
}
