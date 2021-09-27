package view;

import javax.swing.*;

public class MainToolBar extends JToolBar {
    private final JButton adicionarCliente,
            adicionarProduto,
            adicionarFuncionario,
            adicionarVenda, remover;


    public MainToolBar() {
        adicionarCliente = new JButton("Adicionar Cliente");
        adicionarProduto = new JButton("Adicionar Produto");
        adicionarFuncionario = new JButton("Adicionar Funcinario");
        adicionarVenda = new JButton("Adicionar Venda");

        remover = new JButton("Remover");

        add(adicionarCliente);
        add(adicionarFuncionario);
        add(adicionarProduto);
        add(adicionarVenda);
        add(remover);

        setFloatable(false);
    }
}
