package controller;

import model.*;
import view.ProdutoDetails;
import view.ProdutosTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutosTabController implements ListSelectionListener, ActionListener {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(produtosTab.getDetails().getSubmit())) {
            Chocolate chocolate = (Chocolate) produtosTab.getListaProdutos().getLista().getSelectedValue();

            int peso;
            double precoVenda, precoCompra, porcentagemCacau;
            ProdutoDetails details = produtosTab.getDetails();

            try {
                peso = Integer.parseInt(details.getPeso().getText());
                precoCompra = Double.parseDouble(details.getPrecoCompra().getText());
                precoVenda = Double.parseDouble(details.getPrecoVenda().getText());
                porcentagemCacau = Double.parseDouble(details.getPorcentagemCacau().getText());
            } catch (NumberFormatException ignored) {
                peso = 0;
                precoCompra = 0;
                precoVenda = 0;
                porcentagemCacau = 0;
            }

            chocolate.setPeso(peso);
            chocolate.setNome(details.getNome().getText());
            chocolate.setDescricao(details.getDescricao().getText());
            chocolate.setTipo(details.getTipo().getText());
            chocolate.setPrecoCompra(precoCompra);
            chocolate.setPrecoVenda(precoVenda);
            chocolate.setPorcentagemCacau(porcentagemCacau);
            chocolate.setContemGluten(details.getContemGluten().isSelected());
            chocolate.setContemLactose(details.getContemLactose().isSelected());
            chocolate.setArtesanal(details.getArtesanal().isSelected());

            if (chocolate instanceof Barra barra) {
                barra.setSabor(details.getSabor().getText());

                String nibsStr = details.getNibs().getText();
                nibsStr = nibsStr.substring(1, nibsStr.length()-1);
                String[] nibs = nibsStr.split("\\s*,\\s*");
                barra.setNibs(nibs);
            } else if (chocolate instanceof Chocotone chocotone) {
                chocotone.setRecheio(details.getRecheio().getText());

                String frutasStr = details.getFrutas().getText();
                frutasStr = frutasStr.substring(1, frutasStr.length()-1);
                String[] frutas = frutasStr.split("\\s*,\\s*");
                chocotone.setFrutas(frutas);
            } else if (chocolate instanceof Trufa trufa){
                trufa.setRecheio(details.getRecheio().getText());
                trufa.setAlcoolico(details.getAlcoolico().isSelected());
            }

        }
    }
}
