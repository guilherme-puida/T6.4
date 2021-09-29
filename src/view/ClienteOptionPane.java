package view;

import javax.swing.*;
import java.awt.*;

public class ClienteOptionPane {
    JFrame clientePane;

    public ClienteOptionPane() {
        clientePane = new JFrame();
        JOptionPane.showInputDialog(clientePane, "Nome do Cliente:"); //acho que só da pra fazer 1 de cada vez com o optionPane

    }
}
