package controller;

import model.*;
import view.VendaDetails;
import view.VendasTab;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VendasTabController implements ActionListener, ListSelectionListener {
  private final VendasTab vendasTab;

  public VendasTabController(VendasTab vendasTab) {
    this.vendasTab = vendasTab;
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      vendasTab.getDetails().popularDados(venda);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(vendasTab.getDetails().getSubmit())) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      VendaDetails details = vendasTab.getDetails();

      venda.setCliente((Cliente) details.getCliente().getSelectedItem());
      venda.setFuncionario((Funcionario) details.getFuncionario().getSelectedItem());

      HashMap<Chocolate, Integer> vendidos = new HashMap<>();
      ArrayList<JSpinner> produtosSpinner = details.getListaProdutos();
      ArrayList<JLabel> labels = details.getListaLabels();

      /*
      for (int i = 0; i < produtosSpinner.size(); i++) {
          vendidos.put()
      } */
    }
  }
}
