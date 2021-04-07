package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame of the main menu.
 */
public class MainFrame {
    protected JFrame mainFrame = new JFrame();

    /**
     * Default constructor.
     */
    public MainFrame() {
        setMainFrame();
    }

    /**
     * Sets the options of the frame.
     */
    public void setMainFrame() {
        mainFrame.setTitle("Program TV");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(550, 850);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
    }
}
