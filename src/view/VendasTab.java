package view;

import controller.VendasTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendasTab extends JPanel {
  private final ListaPanel listaVendas;
  private final VendaDetails details;

  public VendasTab() {
    setLayout(new BorderLayout(0, 0));

    listaVendas = new ListaPanel(ListaPanel.VENDA);
    listaVendas.getLista().setSelectedIndex(0);
    add(listaVendas, BorderLayout.LINE_START);

    details = new VendaDetails();
    add(details, BorderLayout.CENTER);

    VendasTabController controller = new VendasTabController(this);

    details.getSubmit().addActionListener(controller);
    listaVendas.getLista().addListSelectionListener(controller);
  }

  public void resetListSelectionController() {
    for (ListSelectionListener l : listaVendas.getLista().getListSelectionListeners()) {
      listaVendas.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }

    VendasTabController controller = new VendasTabController(this);
    details.getSubmit().addActionListener(controller);
    listaVendas.getLista().addListSelectionListener(controller);
  }

  public ListaPanel getListaVendas() {
    return listaVendas;
  }

  public VendaDetails getDetails() {
    return details;
  }
}
