package controller;

import model.Endereco;
import model.Loja;
import view.ClienteDetails;
import view.ClienteOptionPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteOptionPaneController implements ActionListener {
    ClienteOptionPane view;

    public ClienteOptionPaneController(ClienteOptionPane view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getDetails().getSubmit())) {
            String[] info = new String[10];

            ClienteDetails details = view.getDetails();
            info[1] = details.getNome().getText();
            info[2] = details.getCpf().getText();
            info[3] = details.getTelefone().getText();
            info[4] = details.getEmail().getText();
            info[5] = details.getBairro().getText();
            info[6] = details.getRua().getText();
            info[7] = details.getNumero().getText();
            info[8] = details.getCep().getText();
            info[9] = details.getCategoria().getText();

            Endereco endereco = new Endereco(info[5], info[6], info[7], info[8]);

            Loja.getInstance().cadastrarCliente(
                    Loja.getInstance().getProximoIdCliente(),
                    18,
                    info[1],
                    info[2],
                    info[3],
                    info[4],
                    endereco,
                    info[9]
            );

            view.dispose();

        }
    }
}
