package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final MainToolBar toolBar;
    private final JTabbedPane tabs;

    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tabs = new JTabbedPane();

        tabs.add("Aba 1", new Tab());
        tabs.add("Aba 2", new Tab());
        tabs.add("ClientesTab", new ClientesTab());

        toolBar = new MainToolBar();

        getContentPane().add(tabs, BorderLayout.CENTER);
        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);

        setSize(1000, 800);
        //pack();
        setVisible(true);
        setResizable(false);
    }

}
