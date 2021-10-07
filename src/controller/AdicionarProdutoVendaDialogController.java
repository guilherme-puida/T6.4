package controller;

import main.Main;
import model.*;
import view.AdicionarProdutoVendaDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * Classe controller para adicionar um produto novo em uma venda já criada.
 * @author Guilherme
 * @version 1.0
 */
public class AdicionarProdutoVendaDialogController implements ActionListener {
  private final AdicionarProdutoVendaDialog view;

  public AdicionarProdutoVendaDialogController(AdicionarProdutoVendaDialog view) {
    this.view = view;
    Set<Chocolate> produtosVenda =
        ((Venda) Main.getFrame().getVendasTab().getListaVendas().getLista().getSelectedValue())
            .getChocolateVendidos()
            .keySet();

    ArrayList<Chocolate> produtos = new ArrayList<>();

    for (Chocolate chocolate : Loja.getInstance().getEstoque().getChocolates()) {
      if (!produtosVenda.contains(chocolate) && Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate) > 0) {
        produtos.add(chocolate);
      }
    }

    view.getProduto().setModel(new DefaultComboBoxModel<>(produtos.toArray(new Chocolate[0])));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == view.getSubmit()) {
      Venda venda = (Venda) Main.getFrame().getVendasTab().getListaVendas().getLista().getSelectedValue();
      Chocolate chocolate = (Chocolate) view.getProduto().getSelectedItem();
      venda.adicionarChocolate(chocolate, 1);
      Loja.getInstance().getEstoque().retirarQuantidade(chocolate, 1);
      Main.getFrame().getVendasTab().getDetails().popularDados(venda);
      view.dispose();
    }
  }
}
