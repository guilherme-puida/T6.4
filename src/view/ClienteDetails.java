package view;

import javax.swing.*;

public class ClienteDetails extends PessoaDetails {
    private final JTextField categoria;
    private final JLabel labelCategoria;

    public ClienteDetails() {
        super("Detalhes do Cliente.");

        labelCategoria = new JLabel("Categoria:");
        categoria = new JTextField();

        getInnerDetailsPanel().add(labelCategoria, getLeft());
        getInnerDetailsPanel().add(categoria, getRight());
    }

    public JTextField getCategoria() {
        return categoria;
    }

    public JLabel getLabelCategoria() {
        return labelCategoria;
    }
}
