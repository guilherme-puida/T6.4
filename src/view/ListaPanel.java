package view;

import model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
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
            case CLIENTE -> lista = new JList<>(Loja.getInstance().getClientes());
            case FUNCIONARIO -> lista = new JList<>(Loja.getInstance().getFuncionarios());
            case CHOCOLATE -> lista = new JList<>(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
            case VENDA -> lista = new JList<>(Loja.getInstance().getVendas());
        }

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);

        listaScroller.setViewportView(lista);
    }

    public int getSelection() {
        return selection;
    }

    public JList<?> getLista() {
        return lista;
    }

    public JScrollPane getListaScroller() {
        return listaScroller;
    }
}
