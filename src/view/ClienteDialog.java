package view;

import controller.ClienteDialogController;

import javax.swing.*;
import java.awt.*;

public class ClienteDialog extends JDialog{
    private final ClienteDetails details;
    private final JFrame parent;

    public ClienteDialog(JFrame parent) {
        super(parent, "Cliente");
        this.parent = parent;
        setModalityType(ModalityType.APPLICATION_MODAL);

        details = new ClienteDetails();
        add(details);

        details.getSubmit().addActionListener(new ClienteDialogController(this));


        setMinimumSize(new Dimension(600, 200));
        pack();
        setVisible(true);
    }

    public ClienteDetails getDetails() {
        return details;
    }
}
