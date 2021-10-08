package view;

import controller.AdicionarProdutoVendaDialogController;
import model.Chocolate;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que cria um dialog para a adição de um produto novo em uma venda já criada.
 * @author Guilherme
 * @version 1.0 (Oct 2021
 */
public class AdicionarProdutoVendaDialog extends JDialog {
  private final JComboBox<Chocolate> produto;
  private final JButton submit;

  /**
   * Cria o dialog de adição de um produto novo em uma venda já criada.
   * @param parent JFrame da classe pai.
   */
  public AdicionarProdutoVendaDialog(JFrame parent) {
    super(parent, "Adicionar novo produto");
    setModalityType(ModalityType.APPLICATION_MODAL);

    setLayout(new BorderLayout(20, 20));

    produto = new JComboBox<>();
    submit = new JButton("Salvar");

    AdicionarProdutoVendaDialogController controller =
            new AdicionarProdutoVendaDialogController(this);

    produto.addActionListener(controller);
    submit.addActionListener(controller);

    add(produto, BorderLayout.CENTER);
    add(submit, BorderLayout.AFTER_LAST_LINE);


    setMinimumSize(new Dimension(300, 200));
    pack();
    setResizable(false);
    setVisible(true);
  }

  /**
   * Getter do produto.
   * @return JComboBox de Chocolate do produto da venda.
   */
  public JComboBox<Chocolate> getProduto() {
    return produto;
  }

  /**
   * Getter do botão submit.
   * @return botão para salvar as mudanças feitas.
   */
  public JButton getSubmit() {
    return submit;
  }
}
