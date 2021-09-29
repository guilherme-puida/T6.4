package controller;


import model.Loja;
import view.ListaPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaPanelController implements ListSelectionListener {
    Loja loja = Loja.getInstance();
    ListaPanel panel;

    public ListaPanelController(ListaPanel panel) {
        this.panel = panel;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {

        }
    }
}
