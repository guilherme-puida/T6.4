package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class ListaPanel extends JPanel {

    public static final int CLIENTE = 0;
    public static final int FUNCIONARIO = 1;
    public static final int CHOCOLATE = 2;
    public static final int VENDA = 3;

    private int selection;

    private JList<?> lista;
    private JScrollPane listaScroller;

    public ListaPanel(int selection) {
        this.selection = selection;
        listaScroller = new JScrollPane();
        updateLista();


        listaScroller.setPreferredSize(new Dimension(200, 600));
        listaScroller.setMinimumSize(new Dimension(200, 600));

        add(listaScroller);
    }

    public void updateLista() {
        switch (selection) {
            case 0 -> lista = new JList<>(Loja.getInstance().getClientes());
            case 1 -> lista = new JList<>(Loja.getInstance().getFuncionarios());
            case 2 -> lista = new JList<>(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
            case 3 -> lista = new JList<>(Loja.getInstance().getVendas());
        }

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);

        listaScroller.setViewportView(lista);
    }
}
