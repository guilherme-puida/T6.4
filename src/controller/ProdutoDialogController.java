package controller;

import model.Loja;
import view.ProdutoDetails;
import view.ProdutoDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ProdutoDialogController implements ActionListener {
    private final ProdutoDialog view;


    public ProdutoDialogController(ProdutoDialog view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getSeletor())) {
            int selection = view.getSeletor().getSelectedIndex();
            switch (selection) {
                case 0 -> view.getDetails().showBarra();
                case 1 -> view.getDetails().showChocotone();
                case 2 -> view.getDetails().showTrufa();
            }
        }

        if (e.getSource().equals(view.getDetails().getSubmit())) {
            int peso;
            double porcentagemCacau, precoCompra, precoVenda;

            ProdutoDetails details = view.getDetails();

            try {
                peso = Integer.parseInt(details.getPeso().getText());
                porcentagemCacau = Double.parseDouble(details.getPorcentagemCacau().getText());
                precoCompra = Double.parseDouble(details.getPrecoCompra().getText());
                precoVenda = Double.parseDouble(details.getPrecoVenda().getText());
            } catch (NumberFormatException ignored) {
                peso = 0;
                porcentagemCacau = 0;
                precoCompra = 0;
                precoVenda = 0;
            }

            int id = Loja.getInstance().getProximoIdChocolate();
            String nome = details.getNome().getText();
            String descricao = details.getDescricao().getText();
            String tipo = details.getTipo().getText();
            LocalDate dataCompra = LocalDate.now();
            boolean contemLactose = details.getContemLactose().isSelected();
            boolean contemGluten = details.getContemGluten().isSelected();
            boolean artesanal = details.getArtesanal().isSelected();

            int selection = view.getSeletor().getSelectedIndex();
            switch (selection) {
                case 0 -> {
                    String nibsStr = details.getNibs().getText();
                    nibsStr = nibsStr.substring(1, nibsStr.length()-1);
                    String[] nibs = nibsStr.split("\\s*,\\s*");

                    String sabor = details.getSabor().getText();

                    Loja.getInstance().cadastrarBarra(
                            id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda,
                            porcentagemCacau, contemGluten, contemLactose, artesanal, sabor, nibs, 0
                    );
                }
            }
        }
    }
}
