package view;

import model.Cliente;
import model.Pessoa;

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

    @Override
    public void popularDados(Pessoa pessoa) {
        Cliente cliente = (Cliente) pessoa;
        super.popularDados(cliente);

        categoria.setText(cliente.getCategoria());
    }

    public JTextField getCategoria() {
        return categoria;
    }

    public JLabel getLabelCategoria() {
        return labelCategoria;
    }
}
