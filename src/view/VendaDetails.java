package view;

import model.Venda;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class VendaDetails extends DetailsPanel{

    private Venda currentVenda;

    public VendaDetails() {
        super("Detalhes da venda:");
    }

    public Venda getCurrentVenda() {
        return currentVenda;
    }

    public void setCurrentVenda(Venda currentVenda) {
        this.currentVenda = currentVenda;
    }
}
