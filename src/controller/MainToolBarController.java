package controller;


import model.Cliente;
import model.Loja;
import view.MainToolBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainToolBarController implements ActionListener {
    Loja loja = Loja.getInstance();

    public MainToolBarController() {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MainToolBar.adicionarCliente) {
            new view.ClienteOptionPane();
        } else if (e.getSource() == MainToolBar.adicionarProduto) {
            System.out.println("Adicionar Produto!");
        } else if (e.getSource() == MainToolBar.adicionarFuncionario) {
            System.out.println("Adicionar Funcionario!");
        } else if (e.getSource() == MainToolBar.adicionarVenda) {
            System.out.println("Adicionar Venda!");
        }
    }
}
