package view;

import controller.FuncionariosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Classe com a lista de todos os funcionarios cadastrados.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class FuncionariosTab extends JPanel {
  private final ListaPanel listaFuncionarios;

  private final FuncionarioDetails details;

  /**
   * Cria o painel da lista de funcionarios, usando o template da classe ListaPanel.
   */
  public FuncionariosTab() {
    setLayout(new BorderLayout(0, 0));

    listaFuncionarios = new ListaPanel(ListaPanel.FUNCIONARIO);
    add(listaFuncionarios, BorderLayout.LINE_START);

    details = new FuncionarioDetails();
    add(details, BorderLayout.CENTER);

    FuncionariosTabController controller = new FuncionariosTabController(this);

    listaFuncionarios.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
  }

  /**
   * Getter da lista de funcionarios.
   * @return painel da lista de funcionarios.
   */
  public ListaPanel getListaFuncionarios() {
    return listaFuncionarios;
  }

  /**
   * Getter dos detalhes do funcionario.
   * @return detalhes do funcionario
   */
  public FuncionarioDetails getDetails() {
    return details;
  }

  /**
   * Reseta o controller de seleção da lista, para aplicar as mudanças feitas.
   */
  public void resetListSelectionController() {
    for (ListSelectionListener l : listaFuncionarios.getLista().getListSelectionListeners()) {
      listaFuncionarios.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }

    FuncionariosTabController controller = new FuncionariosTabController(this);

    listaFuncionarios.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
  }
}
