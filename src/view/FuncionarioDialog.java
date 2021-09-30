package view;

import controller.FuncionarioDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;

public class FuncionarioDialog extends JDialog {
  private final FuncionarioDetails details;
  private final JFrame parent;

  public FuncionarioDialog(JFrame parent) {
    super(parent, "Funcionário");
    this.parent = parent;
    setModalityType(ModalityType.APPLICATION_MODAL);

    details = new FuncionarioDetails();
    add(details);

    details.getId().setText(String.valueOf(Loja.getInstance().showProximoIdFuncionario()));

    details.getSubmit().addActionListener(new FuncionarioDialogController(this));

    setMinimumSize(new Dimension(600, 200));
    pack();
    setResizable(false);
    setVisible(true);
  }

  public FuncionarioDetails getDetails() {
    return details;
  }
}
