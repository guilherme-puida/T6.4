package view;

import controller.FuncionariosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class FuncionariosTab extends JPanel {
    private ListaPanel listaFuncionarios;

    private FuncionarioDetails details;

    public FuncionariosTab() {
        setLayout(new BorderLayout(0, 0));

        listaFuncionarios = new ListaPanel(ListaPanel.FUNCIONARIO);
        add(listaFuncionarios, BorderLayout.LINE_START);

        details = new FuncionarioDetails();
        add(details, BorderLayout.CENTER);

        listaFuncionarios.getLista().addListSelectionListener(new FuncionariosTabController(this));
    }

    public ListaPanel getListaFuncionarios() { return listaFuncionarios; }

    public FuncionarioDetails getDetails() {
        return details;
    }

    public void resetListSelectionController() {
        for (ListSelectionListener l : listaFuncionarios.getLista().getListSelectionListeners()) {
            listaFuncionarios.getLista().removeListSelectionListener(l);
        }

        listaFuncionarios.getLista().addListSelectionListener(new FuncionariosTabController(this));
    }
}
