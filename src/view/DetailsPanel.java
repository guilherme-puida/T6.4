package view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstrata de template para os detalhes dos clientes, funcionarios, chocolates e vendas.
 * @author Guilherme
 * @version 1.0
 */
public abstract class DetailsPanel extends JPanel {
  private final JPanel innerDetailsPanel;
  private final JButton submit;
  private final GridBagConstraints left;
  private final GridBagConstraints right;

  /**
   * Cria o painel que irá ser usado como template nas classes ClienteDetails, FuncionarioDetails, ChocolateDetails e VendaDetails. Utiliza o layout BorderLayout.
   * @param titulo String do titulo, varia dependendo de qual objeto é requerido.
   */
  protected DetailsPanel(String titulo) {
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

  /**
   * Getter do painel template de detalhes.
   * @return painel template de detalhes.
   */
  public JPanel getInnerDetailsPanel() {
    return innerDetailsPanel;
  }

  /**
   * Getter do botão submit.
   * @return JButton submit para salvar as mudanças.
   */
  public JButton getSubmit() {
    return submit;
  }

  /**
   * Getter da parte esquerda do BorderLayout.
   * @return GridBagConstraintrs da parte esquerda do BorderLayout.
   */
  public GridBagConstraints getLeft() {
    return left;
  }

  /**
   * Getter da parte direita do BorderLayout.
   * @return GridBagConstraints da parte direita do BorderLayout.
   */
  public GridBagConstraints getRight() {
    return right;
  }
}
