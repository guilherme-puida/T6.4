package view;

import controller.FuncionariosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class FuncionariosTab extends JPanel {
  private final ListaPanel listaFuncionarios;

  private final FuncionarioDetails details;

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

  public ListaPanel getListaFuncionarios() {
    return listaFuncionarios;
  }

  public FuncionarioDetails getDetails() {
    return details;
  }

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
