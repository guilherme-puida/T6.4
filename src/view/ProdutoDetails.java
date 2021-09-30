package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class ProdutoDetails extends DetailsPanel{

    public static final int BARRA = 0, CHOCOTONE = 1, TRUFA = 2;

    private final JTextField id, peso, nome, descricao, tipo, precoCompra, precoVenda,
    porcentagemCacau, dataCompra;
    private final JCheckBox contemGluten, contemLactose, artesanal;

    private final JTextField sabor, nibs, recheio, frutas;
    private final JCheckBox alcoolico;

    private final JLabel saborLabel, recheioLabel, nibsLabel, frutasLabel, alcoolicoLabel;

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

        setAllInvisible();
    }

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
                String nibsStr = barra.getNibs();
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
    }

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

    public void showBarra() {
        setAllInvisible();
        saborLabel.setVisible(true);
        sabor.setVisible(true);
        nibsLabel.setVisible(true);
        nibs.setVisible(true);
    }

    public void showChocotone() {
        setAllInvisible();
        frutasLabel.setVisible(true);
        frutas.setVisible(true);
        recheioLabel.setVisible(true);
        recheio.setVisible(true);
    }

    public void showTrufa() {
        setAllInvisible();
        recheioLabel.setVisible(true);
        recheio.setVisible(true);
        alcoolicoLabel.setVisible(true);
        alcoolico.setVisible(true);
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getPeso() {
        return peso;
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getDescricao() {
        return descricao;
    }

    public JTextField getTipo() {
        return tipo;
    }

    public JTextField getPrecoCompra() {
        return precoCompra;
    }

    public JTextField getPrecoVenda() {
        return precoVenda;
    }

    public JTextField getPorcentagemCacau() {
        return porcentagemCacau;
    }

    public JCheckBox getContemGluten() {
        return contemGluten;
    }

    public JCheckBox getContemLactose() {
        return contemLactose;
    }

    public JCheckBox getArtesanal() {
        return artesanal;
    }

    public JTextField getSabor() {
        return sabor;
    }

    public JTextField getNibs() {
        return nibs;
    }

    public JTextField getRecheio() {
        return recheio;
    }

    public JTextField getFrutas() {
        return frutas;
    }

    public JCheckBox getAlcoolico() {
        return alcoolico;
    }

    public JTextField getDataCompra() {
        return dataCompra;
    }
}
