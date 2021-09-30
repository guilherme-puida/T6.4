package controller;

import model.*;
import view.ProdutoDetails;
import view.ProdutosTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProdutosTabController implements ListSelectionListener {
    private final ProdutosTab produtosTab;

    public ProdutosTabController(ProdutosTab produtosTab) {
        this.produtosTab = produtosTab;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Chocolate chocolate = (Chocolate) produtosTab.getListaProdutos().getLista().getSelectedValue();
            if (chocolate instanceof Barra) {
                produtosTab.getDetails().popularDados(ProdutoDetails.BARRA, chocolate);
            } else if (chocolate instanceof Chocotone) {
                produtosTab.getDetails().popularDados(ProdutoDetails.CHOCOTONE, chocolate);
            } else if (chocolate instanceof Trufa) {
                produtosTab.getDetails().popularDados(ProdutoDetails.TRUFA, chocolate);
            }
        }
    }
}
