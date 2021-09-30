package controller;

import model.Venda;
import view.VendasTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendasTabController implements ActionListener, ListSelectionListener {
    private final VendasTab vendasTab;

    public VendasTabController(VendasTab vendasTab) {
        this.vendasTab = vendasTab;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
            vendasTab.getDetails().popularDados(venda);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
