package view;

import controller.ProdutoDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ProdutoDialog extends JDialog {
  private final ProdutoDetails details;
  private final JComboBox<String> seletor;
  private final JSpinner quantidade;

  public ProdutoDialog(JFrame parent) {
    super(parent, "Produto");
    setLayout(new BorderLayout());
    setModalityType(ModalityType.APPLICATION_MODAL);

    ProdutoDialogController controller = new ProdutoDialogController(this);

    JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

    String[] opcoes = {"Barra", "Chocotone", "Trufa"};
    seletor = new JComboBox<>(opcoes);
    seletor.setSelectedIndex(0);
    topBar.add(seletor);

    topBar.add(new JLabel("Quantidade:"));
    quantidade = new JSpinner(new SpinnerNumberModel(1, 1, null, 1) {});
    Component editor = quantidade.getEditor();
    JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
    textField.setColumns(5);
    topBar.add(quantidade);

    seletor.addActionListener(controller);

    add(topBar, BorderLayout.BEFORE_FIRST_LINE);

    details = new ProdutoDetails();
    add(details, BorderLayout.CENTER);

    details.getId().setText(String.valueOf(Loja.getInstance().showProximoIdChocolate()));
    details.getDataCompra().setText(LocalDate.now().toString());

    details.getSubmit().addActionListener(controller);

    setMinimumSize(new Dimension(600, 400));
    pack();
    setResizable(false);
    setVisible(true);
  }

  public ProdutoDetails getDetails() {
    return details;
  }

  public JComboBox<String> getSeletor() {
    return seletor;
  }

  public JSpinner getQuantidade() {
    return quantidade;
  }
}
