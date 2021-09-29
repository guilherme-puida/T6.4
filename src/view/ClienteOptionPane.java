package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteOptionPane extends JDialog{
    private final ClienteDetails details;

    public ClienteOptionPane(JFrame parent) {
        super(parent, "Cliente");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        details = new ClienteDetails();
        add(details);

        details.getSubmit().addActionListener(e -> dispose());


        setMinimumSize(new Dimension(600, 200));
        pack();
        setVisible(true);
    }

    public ClienteDetails getDetails() {
        return details;
    }
}
