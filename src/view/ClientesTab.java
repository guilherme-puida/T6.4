package view;

import model.Cliente;
import model.Loja;

import javax.swing.*;
import java.awt.*;

public class ClientesTab extends JPanel {
    JList<Cliente> listaClientes;
    JScrollPane listaClientesScroller;

    JPanel detailsPanel;

    JTextField id, idade, nome, cpf, telefone, email, bairro, rua, numero, cep, categoria;
    JButton submit;

    public ClientesTab() {
        setLayout(new BorderLayout(0, 0));

        listaClientes = new JList<>(Loja.getInstance().getClientes());
        listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaClientes.setLayoutOrientation(JList.VERTICAL);
        listaClientes.setVisibleRowCount(-1);

        listaClientesScroller = new JScrollPane(listaClientes);
        listaClientesScroller.setPreferredSize(new Dimension(200, 800));
        listaClientesScroller.setPreferredSize(new Dimension(200, 800));

        add(listaClientesScroller, BorderLayout.LINE_START);

        detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(3, 4, 50, 200));
        id = new JTextField();
        idade = new JTextField();
        nome = new JTextField();
        cpf = new JTextField();
        telefone = new JTextField();
        email = new JTextField();
        bairro = new JTextField();
        rua = new JTextField();
        numero = new JTextField();
        cep = new JTextField();
        categoria = new JTextField();

        detailsPanel.add(id);
        detailsPanel.add(idade);
        detailsPanel.add(nome);
        detailsPanel.add(cpf);
        detailsPanel.add(telefone);
        detailsPanel.add(email);
        detailsPanel.add(bairro);
        detailsPanel.add(rua);
        detailsPanel.add(numero);
        detailsPanel.add(cep);
        detailsPanel.add(categoria);

        submit = new JButton("Submit");
        detailsPanel.add(submit);


        add(detailsPanel, BorderLayout.CENTER);
    }
}
