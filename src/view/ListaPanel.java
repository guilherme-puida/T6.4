package view;

import model.Cliente;
import model.Loja;

import javax.swing.*;
import java.awt.*;

public class ListaPanel extends JPanel {

    public ListaPanel() {
        JList<Cliente> listaClientes = new JList<>(Loja.getInstance().getClientes());
        listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaClientes.setLayoutOrientation(JList.VERTICAL);
        listaClientes.setVisibleRowCount(-1);

        JScrollPane listaClientesScroller = new JScrollPane(listaClientes);
        listaClientesScroller.setPreferredSize(new Dimension(200, 800));
        listaClientesScroller.setMinimumSize(new Dimension(200, 800));

        add(listaClientesScroller);
    }
}
