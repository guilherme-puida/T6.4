package view;

import javax.swing.*;
import java.awt.*;

public class VendasTab extends JPanel {
    ListaPanel listaVendas;

    public VendasTab() {
        setLayout(new BorderLayout(0, 0));

        listaVendas = new ListaPanel(ListaPanel.VENDA);
        add(listaVendas, BorderLayout.LINE_START);
    }
}
