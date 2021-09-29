package view;

import controller.ClienteOptionPaneController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteOptionPane extends JDialog{
    private final ClienteDetails details;
    private final JFrame parent;

    public ClienteOptionPane(JFrame parent) {
        super(parent, "Cliente");
        this.parent = parent;
        setModalityType(ModalityType.APPLICATION_MODAL);

        details = new ClienteDetails();
        add(details);

        details.getSubmit().addActionListener(new ClienteOptionPaneController(this));


        setMinimumSize(new Dimension(600, 200));
        pack();
        setVisible(true);
    }

    public ClienteDetails getDetails() {
        return details;
    }
}
