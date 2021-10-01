package controller;

import main.Main;
import model.*;
import view.AdicionarProdutoVendaDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoVendaDialogController implements ActionListener {
    private final AdicionarProdutoVendaDialog view;

    public AdicionarProdutoVendaDialogController(AdicionarProdutoVendaDialog view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getProduto()) {
            int maxQuantidade = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(
                    (Chocolate) view.getProduto().getSelectedItem()
            );

            view.getQuantidade().setModel(new SpinnerNumberModel(
                    1, 1, maxQuantidade, 1
            ));
        } else if (e.getSource() == view.getSubmit()) {
            Venda venda = (Venda) Main.getFrame().getVendasTab().getListaVendas().getLista().getSelectedValue();
            Chocolate chocolate = (Chocolate) view.getProduto().getSelectedItem();

            int quantidade = venda.getChocolateVendidos().containsKey(chocolate)
                    ? (int) view.getQuantidade().getValue() - venda.getChocolateVendidos().get(chocolate)
                    : (int) view.getQuantidade().getValue();

            venda.adicionarChocolate(chocolate, quantidade);

            Loja.getInstance().getEstoque().retirarQuantidade(chocolate, quantidade);
            venda.calcularValor();

            view.dispose();
        }
    }
}
