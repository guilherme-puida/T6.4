package view;

import javax.swing.*;

public class FuncionarioDetails extends PessoaDetails {
    /*JPanel innerDetailsPanel;
    JTextField id, idade, nome, cpf, telefone, email, bairro,
            rua, numero, cep, salario, cargo;
    JLabel labelId, labelIdade, labelNome, labelCpf, labelTelefone,
            labelEmail, labelBairro, labelRua, labelNumero, labelCep, labelSalario, labelCargo;
    JButton submit;

    public FuncionariosDetail() {
        setLayout(new BorderLayout());
        add(new JLabel("Detalhes do Cliente"), BorderLayout.NORTH);

        submit = new JButton("Salvar");
        add(submit, BorderLayout.SOUTH);

        innerDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints left = new GridBagConstraints();
        GridBagConstraints right = new GridBagConstraints();

        labelId = new JLabel("Id:");
        labelIdade = new JLabel("Idade:");
        labelNome = new JLabel("Nome:");
        labelCpf = new JLabel("Cpf:");
        labelTelefone = new JLabel("Telefone:");
        labelEmail = new JLabel("Email:");
        labelBairro = new JLabel("Bairro:");
        labelRua = new JLabel("Rua:");
        labelNumero = new JLabel("Numero:");
        labelCep = new JLabel("Cep:");
        labelSalario = new JLabel("Categoria:");
        labelCargo = new JLabel("Cargo:");

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
        salario = new JTextField();
        cargo = new JTextField();

        left.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        innerDetailsPanel.add(labelId, left);
        innerDetailsPanel.add(id, right);
        innerDetailsPanel.add(labelIdade, left);
        innerDetailsPanel.add(idade, right);
        innerDetailsPanel.add(labelNome, left);
        innerDetailsPanel.add(nome, right);
        innerDetailsPanel.add(labelCpf, left);
        innerDetailsPanel.add(cpf, right);
        innerDetailsPanel.add(labelTelefone, left);
        innerDetailsPanel.add(telefone, right);
        innerDetailsPanel.add(labelEmail, left);
        innerDetailsPanel.add(email, right);
        innerDetailsPanel.add(labelBairro, left);
        innerDetailsPanel.add(bairro, right);
        innerDetailsPanel.add(labelRua, left);
        innerDetailsPanel.add(rua, right);
        innerDetailsPanel.add(labelNumero, left);
        innerDetailsPanel.add(numero, right);
        innerDetailsPanel.add(labelCep, left);
        innerDetailsPanel.add(cep, right);
        innerDetailsPanel.add(labelSalario, left);
        innerDetailsPanel.add(salario, right);
        innerDetailsPanel.add(labelCargo, left);
        innerDetailsPanel.add(cargo, right);

        innerDetailsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(innerDetailsPanel, BorderLayout.CENTER);
    }*/
    private final JTextField salario, cargo;
    private final JLabel labelSalario, labelCargo;
    public FuncionarioDetails() {
        super("Detalhes do funcionário.");

        labelSalario = new JLabel("Salário");
        labelCargo = new JLabel("Cargo:");

        salario = new JTextField();
        cargo = new JTextField();

        getInnerDetailsPanel().add(labelSalario, getLeft());
        getInnerDetailsPanel().add(salario, getRight());
        getInnerDetailsPanel().add(labelCargo, getLeft());
        getInnerDetailsPanel().add(cargo, getRight());
    }

    public JTextField getSalario() {
        return salario;
    }

    public JTextField getCargo() {
        return cargo;
    }

    public JLabel getLabelSalario() {
        return labelSalario;
    }

    public JLabel getLabelCargo() {
        return labelCargo;
    }
}
