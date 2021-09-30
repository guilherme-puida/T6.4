package view;

import controller.ClientesTabController;
import controller.FuncionariosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientesTab extends JPanel {
    private final ListaPanel listaClientes;

    private final ClienteDetails details;

    public ClientesTab() {
        setLayout(new BorderLayout(0, 0));

        listaClientes = new ListaPanel(ListaPanel.CLIENTE);
        add(listaClientes, BorderLayout.LINE_START);

        details = new ClienteDetails();
        add(details, BorderLayout.CENTER);

        ClientesTabController controller = new ClientesTabController(this);

        listaClientes.getLista().addListSelectionListener(controller);
        details.getSubmit().addActionListener(controller);
    }

    public ListaPanel getListaClientes() {
        return listaClientes;
    }

    public ClienteDetails getDetails() {
        return details;
    }

    public void resetListSelectionController() {
        for (ListSelectionListener l : listaClientes.getLista().getListSelectionListeners()) {
            listaClientes.getLista().removeListSelectionListener(l);
        }

        for (ActionListener l : details.getSubmit().getActionListeners()) {
            details.getSubmit().removeActionListener(l);
        }

        ClientesTabController controller = new ClientesTabController(this);

        details.getSubmit().addActionListener(controller);
        listaClientes.getLista().addListSelectionListener(controller);
    }

}
