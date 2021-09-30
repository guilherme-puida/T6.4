package view;

import javax.swing.*;
import java.awt.*;

public class FuncionarioDialog extends JDialog {
    private final FuncionarioDetails details;
    private final JFrame parent;

    public FuncionarioDialog(JFrame parent) {
        super(parent, "Funcionário");
        this.parent = parent;
        setModalityType(ModalityType.APPLICATION_MODAL);

        details = new FuncionarioDetails();
        add(details);

        // TODO
        // details.getSubmit().addActionListener(new FuncionarioOptionPaneController(this));
        details.getSubmit().addActionListener(e -> dispose());

        setMinimumSize(new Dimension(600, 200));
        pack();
        setVisible(true);
    }

    public FuncionarioDetails getDetails() { return details; }

}