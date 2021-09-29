package controller;


import model.Cliente;
import view.ClientesTab;


import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClientesTabController implements ListSelectionListener {
    ClientesTab clientesTab;

    public ClientesTabController(ClientesTab clientesTab) {
        this.clientesTab = clientesTab;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {

        }
    }
}
