package view;

import controller.ClientesTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ClientesTab extends JPanel {
    private final ListaPanel listaClientes;

    private final ClienteDetails details;

    public ClientesTab() {
        setLayout(new BorderLayout(0, 0));

        listaClientes = new ListaPanel(ListaPanel.CLIENTE);
        add(listaClientes, BorderLayout.LINE_START);

        details = new ClienteDetails();
        add(details, BorderLayout.CENTER);


        listaClientes.getLista().addListSelectionListener(new ClientesTabController(this));
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

        listaClientes.getLista().addListSelectionListener(new ClientesTabController(this));
    }

}
