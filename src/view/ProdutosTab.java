package view;

import controller.ProdutosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Classe com a lista de todos os produtos cadastrados.
 */
public class ProdutosTab extends JPanel {
  private final ListaPanel listaProdutos;

  private final ProdutoDetails details;

  /**
   * Cria o painel da lista de produtos, usando o template da classe ListaPanel.
   */
  public ProdutosTab() {
    setLayout(new BorderLayout());

    listaProdutos = new ListaPanel(ListaPanel.CHOCOLATE);
    add(listaProdutos, BorderLayout.LINE_START);

    details = new ProdutoDetails();
    add(details, BorderLayout.CENTER);

    ProdutosTabController controller = new ProdutosTabController(this);

    listaProdutos.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
  }

  /**
   * Getter da lista de produtos.
   * @return painel da lista de produtos.
   */
  public ListaPanel getListaProdutos() {
    return listaProdutos;
  }

  /**
   * Getter dos detalhes do produto.
   * @return detalhes do produto.
   */
  public ProdutoDetails getDetails() {
    return details;
  }

  /**
   * Reseta o controller de seleção da lista, para aplicar as mudanças feitas.
   */
  public void resetListSelectionController() {
    for (ListSelectionListener l : listaProdutos.getLista().getListSelectionListeners()) {
      listaProdutos.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }

    ProdutosTabController controller = new ProdutosTabController(this);

    listaProdutos.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
  }
}
