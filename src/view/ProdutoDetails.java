package view;

import model.Chocolate;

import javax.swing.*;
import java.awt.*;

public class ProdutoDetails extends DetailsPanel{

    public static final int BARRA = 0, CHOCOTONE = 1, TRUFA = 2;
    private int escolha;

    private final JTextField id, peso, nome, descricao, tipo, precoCompra, precoVenda,
    porcentagemCacau;
    private final JCheckBox contemGluten, contemLactose, artesanal;

    private final JTextField sabor, nibs, recheio, frutas;
    private final JCheckBox alcoolico;

    private final JLabel saborLabel, recheioLabel, nibsLabel, frutasLabel, alcoolicoLabel;

    public ProdutoDetails(int escolha) {
        super("Detalhes do produto");

        this.escolha = escolha;

        id = new JTextField();
        peso = new JTextField();
        nome = new JTextField();
        descricao = new JTextField();
        tipo = new JTextField();
        precoCompra = new JTextField();
        precoVenda = new JTextField();
        porcentagemCacau = new JTextField();

        sabor = new JTextField();
        nibs = new JTextField();
        recheio = new JTextField();
        frutas = new JTextField();

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

        saborLabel = new JLabel("Sabor:");
        nibsLabel = new JLabel("Nibs:");
        recheioLabel = new JLabel("Recheio:");
        frutasLabel = new JLabel("Frutas:");
        alcoolicoLabel = new JLabel("Alcoólico");

        switch(escolha) {
            case BARRA -> {
                getInnerDetailsPanel().add(saborLabel, left);
                getInnerDetailsPanel().add(sabor, right);
                getInnerDetailsPanel().add(nibsLabel, left);
                getInnerDetailsPanel().add(nibs, right);
            }
            case CHOCOTONE -> {
                getInnerDetailsPanel().add(recheioLabel, left);
                getInnerDetailsPanel().add(recheio, right);
                getInnerDetailsPanel().add(frutasLabel, left);
                getInnerDetailsPanel().add(frutas, right);
            }
            case TRUFA -> {
                getInnerDetailsPanel().add(recheioLabel, left);
                getInnerDetailsPanel().add(recheio, right);
                getInnerDetailsPanel().add(alcoolicoLabel, left);
                getInnerDetailsPanel().add(alcoolico, right);
            }
        }


        left.gridx = GridBagConstraints.RELATIVE;
        right.gridx = GridBagConstraints.RELATIVE;
        getInnerDetailsPanel().add(new JLabel("Contém Gluten:"), left);
        getInnerDetailsPanel().add(contemGluten, right);
        getInnerDetailsPanel().add(new JLabel("Contém Lactose:"), left);
        getInnerDetailsPanel().add(contemLactose, right);
        getInnerDetailsPanel().add(new JLabel("Artesanal:"), left);
        getInnerDetailsPanel().add(artesanal, right);
    }

    public void popularDados(Chocolate chocolate) {
        
    }
}
