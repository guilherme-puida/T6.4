package view;

import javax.swing.*;
import java.awt.*;

public class ProdutoDialog extends JDialog {
    private final ProdutoDetails details;
    private final JComboBox<String> seletor;

    public ProdutoDialog(JFrame parent) {
        super(parent, "Produto");
        setLayout(new BorderLayout());
        setModalityType(ModalityType.APPLICATION_MODAL);

        String[] opcoes = {"Barra", "Chocotone", "Trufa"};
        seletor = new JComboBox<>(opcoes);
        seletor.setSelectedIndex(0);
        add(seletor, BorderLayout.BEFORE_FIRST_LINE);

        details = new ProdutoDetails();
        add(details, BorderLayout.CENTER);

        setMinimumSize(new Dimension(600, 200));
        pack();
        setResizable(false);
        setVisible(true);
    }
}
