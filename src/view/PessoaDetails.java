package view;

import model.Pessoa;

import javax.swing.*;
import java.awt.*;

public abstract class PessoaDetails extends DetailsPanel {
    private final JTextField id, idade, nome, cpf, telefone, email, bairro,
            rua, numero, cep;

    public PessoaDetails(String titulo) {
        super(titulo);

        JLabel labelId = new JLabel("Id:");
        JLabel labelIdade = new JLabel("Idade:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelCpf = new JLabel("Cpf:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelBairro = new JLabel("Bairro:");
        JLabel labelRua = new JLabel("Rua:");
        JLabel labelNumero = new JLabel("Numero:");
        JLabel labelCep = new JLabel("Cep:");

        id = new JTextField();
        id.setEditable(false);
        idade = new JTextField();
        nome = new JTextField();
        cpf = new JTextField();
        telefone = new JTextField();
        email = new JTextField();
        bairro = new JTextField();
        rua = new JTextField();
        numero = new JTextField();
        cep = new JTextField();

        GridBagConstraints left = getLeft();
        GridBagConstraints right = getRight();


        getInnerDetailsPanel().add(labelId, left);
        getInnerDetailsPanel().add(id, right);
        getInnerDetailsPanel().add(labelIdade, left);
        getInnerDetailsPanel().add(idade, right);
        getInnerDetailsPanel().add(labelNome, left);
        getInnerDetailsPanel().add(nome, right);
        getInnerDetailsPanel().add(labelCpf, left);
        getInnerDetailsPanel().add(cpf, right);
        getInnerDetailsPanel().add(labelTelefone, left);
        getInnerDetailsPanel().add(telefone, right);
        getInnerDetailsPanel().add(labelEmail, left);
        getInnerDetailsPanel().add(email, right);
        getInnerDetailsPanel().add(labelBairro, left);
        getInnerDetailsPanel().add(bairro, right);
        getInnerDetailsPanel().add(labelRua, left);
        getInnerDetailsPanel().add(rua, right);
        getInnerDetailsPanel().add(labelNumero, left);
        getInnerDetailsPanel().add(numero, right);
        getInnerDetailsPanel().add(labelCep, left);
        getInnerDetailsPanel().add(cep, right);
    }

    public void popularDados(Pessoa pessoa) {
        id.setText(String.valueOf(pessoa.getId()));
        idade.setText(String.valueOf(pessoa.getIdade()));
        nome.setText(pessoa.getNome());
        cpf.setText(pessoa.getCpf());
        telefone.setText(pessoa.getTelefone());
        email.setText(pessoa.getEmail());
        bairro.setText(pessoa.getEndereco().getBairro());
        rua.setText(pessoa.getEndereco().getRua());
        numero.setText(pessoa.getEndereco().getNumero());
        cep.setText(pessoa.getEndereco().getCep());
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getIdade() {
        return idade;
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getBairro() {
        return bairro;
    }

    public JTextField getRua() {
        return rua;
    }

    public JTextField getNumero() {
        return numero;
    }

    public JTextField getCep() {
        return cep;
    }
}
