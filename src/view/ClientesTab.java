package view;

import javax.swing.*;
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
    }

    public ListaPanel getListaClientes() {
        return listaClientes;
    }

    public ClienteDetails getDetails() {
        return details;
    }
}
