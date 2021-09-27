package view;


import javax.swing.*;
import java.awt.*;

public class Tab extends JPanel {
    public Tab() {
        setLayout(new BorderLayout(20, 0));


        add(new ListaPanel(), BorderLayout.LINE_START);
        add(new DetailsPanel(), BorderLayout.CENTER);
    }
}
