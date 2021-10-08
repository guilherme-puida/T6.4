package view;

import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de detalhes para o produto. Mostra todas as informações do produto selecionado. Usa a classe DetailsPanel como template.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class ProdutoDetails extends DetailsPanel {

  public static final int BARRA = 0;
  public static final int CHOCOTONE = 1;
  public static final int TRUFA = 2;

  private final JTextField id;
  private final JTextField peso;
  private final JTextField nome;
  private final JTextField descricao;
  private final JTextField tipo;
  private final JTextField precoCompra;
  private final JTextField precoVenda;
  private final JTextField porcentagemCacau;
  private final JTextField dataCompra;
  private final JCheckBox contemGluten;
  private final JCheckBox contemLactose;
  private final JCheckBox artesanal;

  private final JTextField sabor;
  private final JTextField nibs;
  private final JTextField recheio;
  private final JTextField frutas;
  private final JCheckBox alcoolico;

  private final JLabel saborLabel;
  private final JLabel recheioLabel;
  private final JLabel nibsLabel;
  private final JLabel frutasLabel;
  private final JLabel alcoolicoLabel;

  private final JSpinner quantidade;

  /**
   * Cria e adiciona os JLabels, e os JTextFields com setToolTipText do tipo de variavel aceito.
   */
  public ProdutoDetails() {
    super("Detalhes do produto");


    id = new JTextField();
    id.setEditable(false);

    peso = new JTextField();
    peso.setToolTipText("Inteiro.");
    nome = new JTextField();
    descricao = new JTextField();
    tipo = new JTextField();
    precoCompra = new JTextField();
    precoCompra.setToolTipText("Double.");
    precoVenda = new JTextField();
    precoVenda.setToolTipText("Double.");
    porcentagemCacau = new JTextField();

    dataCompra = new JTextField();
    dataCompra.setEditable(false);

    sabor = new JTextField();
    nibs = new JTextField();
    nibs.setToolTipText("No formato [nibs1, nibs2, nibs3, ...]");
    recheio = new JTextField();
    frutas = new JTextField();
    frutas.setToolTipText("No formato [fruta1, fruta2, fruta3, ...]");

    contemGluten = new JCheckBox();
    contemLactose = new JCheckBox();
    artesanal = new JCheckBox();

    alcoolico = new JCheckBox();

    GridBagConstraints left = getLeft();
    GridBagConstraints right = getRight();

    getInnerDetailsPanel().add(new JLabel("Id:"), left);
    getInnerDetailsPanel().add(id, right);
    getInnerDetailsPanel().add(new JLabel("Peso:"), left);
    getInnerDetailsPanel().add(peso, right);
    getInnerDetailsPanel().add(new JLabel("Nome:"), left);
    getInnerDetailsPanel().add(nome, right);
    getInnerDetailsPanel().add(new JLabel("Descrição:"), left);
    getInnerDetailsPanel().add(descricao, right);
    getInnerDetailsPanel().add(new JLabel("Tipo:"), left);
    getInnerDetailsPanel().add(tipo, right);
    getInnerDetailsPanel().add(new JLabel("Preço de Compra:"), left);
    getInnerDetailsPanel().add(precoCompra, right);
    getInnerDetailsPanel().add(new JLabel("Preço de Venda:"), left);
    getInnerDetailsPanel().add(precoVenda, right);
    getInnerDetailsPanel().add(new JLabel("Porcentagem de Cacau:"), left);
    getInnerDetailsPanel().add(porcentagemCacau, right);
    getInnerDetailsPanel().add(new JLabel("Data da compra:"), left);
    getInnerDetailsPanel().add(dataCompra, right);

    saborLabel = new JLabel("Sabor:");
    nibsLabel = new JLabel("Nibs:");
    recheioLabel = new JLabel("Recheio:");
    frutasLabel = new JLabel("Frutas:");
    alcoolicoLabel = new JLabel("Alcoólico");

    getInnerDetailsPanel().add(saborLabel, left);
    getInnerDetailsPanel().add(sabor, right);
    getInnerDetailsPanel().add(nibsLabel, left);
    getInnerDetailsPanel().add(nibs, right);
    getInnerDetailsPanel().add(recheioLabel, left);
    getInnerDetailsPanel().add(recheio, right);
    getInnerDetailsPanel().add(frutasLabel, left);
    getInnerDetailsPanel().add(frutas, right);
    getInnerDetailsPanel().add(alcoolicoLabel, left);
    getInnerDetailsPanel().add(alcoolico, right);

    getInnerDetailsPanel().add(new JLabel("Contém Gluten:"), left);
    getInnerDetailsPanel().add(contemGluten, right);
    getInnerDetailsPanel().add(new JLabel("Contém Lactose:"), left);
    getInnerDetailsPanel().add(contemLactose, right);
    getInnerDetailsPanel().add(new JLabel("Artesanal:"), left);
    getInnerDetailsPanel().add(artesanal, right);

    quantidade = new JSpinner();

    getInnerDetailsPanel().add(new JLabel("Quantidade:"), left);
    getInnerDetailsPanel().add(quantidade, right);

    setAllInvisible();
  }

  /**
   * Deixa todos os Labels e TextFields invisiveis.
   */
  public void setAllInvisible() {
    recheioLabel.setVisible(false);
    recheio.setVisible(false);
    frutasLabel.setVisible(false);
    frutas.setVisible(false);
    alcoolicoLabel.setVisible(false);
    alcoolico.setVisible(false);
    sabor.setVisible(false);
    saborLabel.setVisible(false);
    nibsLabel.setVisible(false);
    nibs.setVisible(false);
  }

  /**
   * Popula os JTextFields do metodo ProdutoDetails() com os detalhes do produto.
   * @param selection inteiro que seleciona o tipo de chocolate.
   * @param chocolate objeto Chocolate.
   */
  public void popularDados(int selection, Chocolate chocolate) {
    id.setText(String.valueOf(chocolate.getId()));
    peso.setText(String.valueOf(chocolate.getPeso()));
    nome.setText(chocolate.getNome());
    descricao.setText(chocolate.getDescricao());
    tipo.setText(chocolate.getTipo());
    precoCompra.setText(String.valueOf(chocolate.getPrecoCompra()));
    precoVenda.setText(String.valueOf(chocolate.getPrecoVenda()));
    porcentagemCacau.setText(String.valueOf(chocolate.getPorcentagemCacau()));
    dataCompra.setText(chocolate.getDataCompra().toString());

    contemGluten.setSelected(chocolate.isContemGluten());
    contemLactose.setSelected(chocolate.isContemLactose());
    artesanal.setSelected(chocolate.isArtesanal());

    setAllInvisible();

    switch (selection) {
      case BARRA -> {
        showBarra();

        Barra barra = (Barra) chocolate;
        sabor.setText(barra.getSabor());
        nibs.setText(String.join(",", barra.getNibs()));
      }
      case CHOCOTONE -> {
        showChocotone();

        Chocotone chocotone = (Chocotone) chocolate;
        recheio.setText(chocotone.getRecheio());
        frutas.setText(String.join(",", chocotone.getFrutas()));
      }
      case TRUFA -> {
        showTrufa();

        Trufa trufa = (Trufa) chocolate;
        recheio.setText(trufa.getRecheio());
        alcoolico.setSelected(trufa.isAlcoolico());
      }
    }

    int quantidadeAtual = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate);
    quantidade.setModel(new SpinnerNumberModel(
            quantidadeAtual,
            quantidadeAtual,
            null,
            1
    ));
  }

  /**
   * Deixa os elementos da Barra visiveis.
   */
  public void showBarra() {
    setAllInvisible();
    saborLabel.setVisible(true);
    sabor.setVisible(true);
    nibsLabel.setVisible(true);
    nibs.setVisible(true);
  }

  /**
   * Deixa os elementos do Chocotone visiveis.
   */
  public void showChocotone() {
    setAllInvisible();
    frutasLabel.setVisible(true);
    frutas.setVisible(true);
    recheioLabel.setVisible(true);
    recheio.setVisible(true);
  }

  /**
   * Deixa os elementos da Trufa visiveis.
   */
  public void showTrufa() {
    setAllInvisible();
    recheioLabel.setVisible(true);
    recheio.setVisible(true);
    alcoolicoLabel.setVisible(true);
    alcoolico.setVisible(true);
  }

  public JSpinner getQuantidade() {
    return quantidade;
  }

  /**
   * Getter do id do produto.
   * @return JTextfield do id do produto.
   */
  public JTextField getId() {
    return id;
  }

  /**
   * Getter do peso do produto.
   * @return JTextfield do peso do produto.
   */
  public JTextField getPeso() {
    return peso;
  }

  /**
   * Getter do nome do produto.
   * @return JTextfield do nome do produto.
   */
  public JTextField getNome() {
    return nome;
  }

  /**
   * Getter da descrição do produto.
   * @return JTextfield da descrição do produto.
   */
  public JTextField getDescricao() {
    return descricao;
  }

  /**
   * Getter do tipo do produto.
   * @return JTextfield do tipo do produto.
   */
  public JTextField getTipo() {
    return tipo;
  }

  /**
   * Getter do preço de compra do produto.
   * @return JTextfield do preço de compra do produto.
   */
  public JTextField getPrecoCompra() {
    return precoCompra;
  }

  /**
   * Getter do preço de venda do produto.
   * @return JTextfield do preço de venda do produto.
   */
  public JTextField getPrecoVenda() {
    return precoVenda;
  }

  /**
   * Getter da porcentagem de cacau do produto.
   * @return JTextfield da porcentagem de cacau do produto.
   */
  public JTextField getPorcentagemCacau() {
    return porcentagemCacau;
  }

  /**
   * Getter da opção de glutem do produto.
   * @return JCheckBox da opção de glutem do produto.
   */
  public JCheckBox getContemGluten() {
    return contemGluten;
  }

  /**
   * Getter da opção de lactose do produto.
   * @return JCheckBox da opção de lactose do produto.
   */
  public JCheckBox getContemLactose() {
    return contemLactose;
  }

  /**
   * Getter da opção artesanal do produto.
   * @return JCheckBox da opção artesanal do produto.
   */
  public JCheckBox getArtesanal() {
    return artesanal;
  }

  /**
   * Getter do sabor do produto.
   * @return JTextfield do sabor do produto.
   */
  public JTextField getSabor() {
    return sabor;
  }

  /**
   * Getter do(s) nib(s) do produto.
   * @return JTextfield do(s) nib(s) do produto.
   */
  public JTextField getNibs() {
    return nibs;
  }

  /**
   * Getter do recheio do produto.
   * @return JTextfield do recheio do produto.
   */
  public JTextField getRecheio() {
    return recheio;
  }

  /**
   * Getter das frutas do produto.
   * @return JTextfield das frutas do produto.
   */
  public JTextField getFrutas() {
    return frutas;
  }

  /**
   * Getter da opção alcoolica do produto.
   * @return JCheckBox da opção alcoolica do produto.
   */
  public JCheckBox getAlcoolico() {
    return alcoolico;
  }

  /**
   * Getter da data de compra do produto.
   * @return JTextfield da data de compra do produto.
   */
  public JTextField getDataCompra() {
    return dataCompra;
  }
}
