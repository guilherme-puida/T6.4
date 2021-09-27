package view;


import javax.swing.*;

public class DetailsPanel extends JPanel {
    private JLabel test;
    private JButton testButton;

    public DetailsPanel() {
        test = new JLabel("Teste");
        testButton = new JButton("Teste - Botão");

        add(test);
        add(testButton);
    }

}
