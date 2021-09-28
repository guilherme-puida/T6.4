package view;

import javax.swing.*;
import java.awt.*;

public class ClientesTab extends JPanel {
    ListaPanel listaClientes;

    ClienteDetails details;

    public ClientesTab() {
        setLayout(new BorderLayout(0, 0));

        listaClientes = new ListaPanel(ListaPanel.CLIENTE);
        add(listaClientes, BorderLayout.LINE_START);

        details = new ClienteDetails();
        add(details, BorderLayout.CENTER);


    }
}
