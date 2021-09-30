package view;

import javax.swing.*;
import java.awt.*;

public abstract class DetailsPanel extends JPanel {
  private final JPanel innerDetailsPanel;
  private final JButton submit;
  private final GridBagConstraints left, right;

  public DetailsPanel(String titulo) {
    setLayout(new BorderLayout());
    add(new JLabel(titulo), BorderLayout.NORTH);

    submit = new JButton("Salvar");
    add(submit, BorderLayout.SOUTH);

    innerDetailsPanel = new JPanel(new GridBagLayout());
    left = new GridBagConstraints();
    right = new GridBagConstraints();

    left.anchor = GridBagConstraints.EAST;
    right.weightx = 2.0;
    right.fill = GridBagConstraints.HORIZONTAL;
    right.gridwidth = GridBagConstraints.REMAINDER;

    innerDetailsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    add(innerDetailsPanel, BorderLayout.CENTER);
  }

  public JPanel getInnerDetailsPanel() {
    return innerDetailsPanel;
  }

  public JButton getSubmit() {
    return submit;
  }

  public GridBagConstraints getLeft() {
    return left;
  }

  public GridBagConstraints getRight() {
    return right;
  }
}
