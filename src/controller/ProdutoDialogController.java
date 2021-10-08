package controller;

import main.Main;
import model.Loja;
import view.ProdutoDetails;
import view.ProdutoDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Classe controller do dialog de produtos. Implementa ActionListeners ao dialog.
 * @author Guilherme e Tiago
 * @version 1.0
 */
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
        case 0 -> {
          view.getDetails().showBarra();
          view.getDetails().getNibs().setText("[]");
        }
        case 1 -> {
          view.getDetails().showChocotone();
          view.getDetails().getFrutas().setText("[]");
        }
        case 2 -> view.getDetails().showTrufa();
      }
    }

    if (e.getSource().equals(view.getDetails().getSubmit())) {
      System.out.println("here");
      int peso;
      double porcentagemCacau;
      double precoCompra;
      double precoVenda;

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

      int quantidade = (int) view.getQuantidade().getValue();

      String recheio;

      int selection = view.getSeletor().getSelectedIndex();
      switch (selection) {
        case 0 -> {
          String nibsStr = details.getNibs().getText();
          String[] nibs;
          if (nibsStr.length() == 0) {
            nibs = new String[]{};
          } else {
            nibsStr = nibsStr.substring(1, nibsStr.length() - 1);
            nibs = nibsStr.split("\\s*,\\s*");
          }
          String sabor = details.getSabor().getText();

          Loja.getInstance().cadastrarBarra(id, peso, nome, descricao, tipo, dataCompra,
                  precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose,
                  artesanal, sabor, nibs, quantidade);
        }
        case 1 -> {
          String frutasStr = details.getFrutas().getText();
          String[] frutas;
          if (frutasStr.length() == 0) {
            frutas = new String[]{};
          } else {
            frutasStr = frutasStr.substring(1, frutasStr.length() - 1);
            frutas = frutasStr.split("\\s*,\\s*");
          }

          recheio = details.getRecheio().getText();

          Loja.getInstance().cadastrarChocotone(id, peso, nome, descricao, tipo, dataCompra,
                  precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose,
                  artesanal, recheio, frutas, quantidade);
        }
        case 2 -> {
          recheio = details.getRecheio().getText();
          boolean alcoolico = details.getAlcoolico().isSelected();

          Loja.getInstance().cadastrarTrufa(id, peso, nome, descricao, tipo, dataCompra,
                  precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose,
                  artesanal, recheio, alcoolico, quantidade);
        }
      }

      Main.getFrame().getProdutosTab().getListaProdutos().updateLista();
      Main.getFrame().getProdutosTab().resetListSelectionController();

      view.dispose();
    }
  }
}

