package view;

import javax.swing.*;
import java.awt.*;

public class ProdutoDetails extends DetailsPanel{

    public static final int BARRA = 0, CHOCOTONE = 1, TRUFA = 2;
    private int escolha;

    private final JTextField id, peso, nome, descricao, tipo, precoCompra, precoVenda,
    porcentagemCacau;
    private final JCheckBox contemGluten, contemLactose, artesanal;

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

        contemGluten = new JCheckBox();
        contemLactose = new JCheckBox();
        artesanal = new JCheckBox();

        GridBagConstraints left = getLeft();
        GridBagConstraints right = getRight();

        add(new JLabel("Id:"), left);

    }
}
