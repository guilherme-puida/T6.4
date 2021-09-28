package view;

import javax.swing.*;
import java.awt.*;

public class FuncionariosTab extends JPanel {
    ListaPanel listaFuncionarios;

    FuncionarioDetails details;

    public FuncionariosTab() {
        setLayout(new BorderLayout(0, 0));

        listaFuncionarios = new ListaPanel(ListaPanel.FUNCIONARIO);
        add(listaFuncionarios, BorderLayout.LINE_START);

        details = new FuncionarioDetails();
        add(details, BorderLayout.CENTER);
    }
}
