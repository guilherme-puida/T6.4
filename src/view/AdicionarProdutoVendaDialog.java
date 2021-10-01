package view;

import controller.AdicionarProdutoVendaDialogController;
import model.Chocolate;

import javax.swing.*;
import java.awt.*;

public class AdicionarProdutoVendaDialog extends JDialog {
  private final JComboBox<Chocolate> produto;
  private final JButton submit;

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

  public JComboBox<Chocolate> getProduto() {
    return produto;
  }

  public JButton getSubmit() {
    return submit;
  }
}
