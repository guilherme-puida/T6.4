package view;

import controller.AdicionarProdutoVendaDialogController;
import model.Chocolate;
import model.Loja;

import javax.swing.*;
import java.awt.*;

public class AdicionarProdutoVendaDialog extends JDialog {
    private final JComboBox<Chocolate> produto;
    private final JSpinner quantidade;
    private final JButton submit;

  public AdicionarProdutoVendaDialog() {
    setLayout(new BorderLayout(20, 20));

    Loja loja = Loja.getInstance();
    produto = new JComboBox<>(new DefaultComboBoxModel<>(
            loja.getEstoque().getChocolates().toArray(new Chocolate[0])
    ));

    quantidade = new JSpinner(new SpinnerNumberModel(
            1, 1, null, 1
    ));

    submit = new JButton("Salvar");

    add(produto, BorderLayout.BEFORE_FIRST_LINE);
    add(quantidade, BorderLayout.CENTER);
    add(submit, BorderLayout.AFTER_LAST_LINE);

    AdicionarProdutoVendaDialogController controller = new AdicionarProdutoVendaDialogController(this);

    produto.addActionListener(controller);
    submit.addActionListener(controller);

    setVisible(true);
    setSize(300, 100);
    setResizable(false);

  }

    public JComboBox<Chocolate> getProduto() {
        return produto;
    }

    public JSpinner getQuantidade() {
        return quantidade;
    }

    public JButton getSubmit() {
        return submit;
    }
}
