package GUI;

import Service.Service;

import javax.swing.*;

/**
 * MessageDialog class for confirming the reorder.
 */
public class SportOrderFrame {
    private final Service s = new Service();

    /**
     * Default constructor.
     */
    public SportOrderFrame()
    {
        setOrderMessageDialog();
    }

    /**
     * Orders the journals and sets the MessageDialog.
     */
    private void setOrderMessageDialog()
    {
        this.s.sortareSport();
        JOptionPane.showMessageDialog(null, "Ati efectuat sortarea descrescatoare dupa durata!",
                "Sortare efectuata", JOptionPane.PLAIN_MESSAGE);
    }
}
