package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for all options of the "show" object that implements the ActionListener interface.
 */
public class ShowsFrame implements ActionListener {
    private final JFrame showsFrame = new JFrame();
    private final JButton addButton = new JButton();
    private final JButton deleteButton = new JButton();
    private final JButton updateButton = new JButton();
    private final JButton showButton = new JButton();

    /**
     * Default constructor.
     */
    public ShowsFrame()
    {
        setShowsFrame();
        setAddButton();
        setDeleteButton();
        setUpdateButton();
        setShowButton();

        showsFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setShowsFrame()
    {
        showsFrame.setTitle("Show-uri");
        showsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showsFrame.setSize(300,350);
        showsFrame.setResizable(false);
        showsFrame.setLayout(null);
    }

    /**
     * Sets the options of the add button.
     */
    private void setAddButton()
    {
        addButton.setBounds(65,20,150,50);
        addButton.setText("Adaugare show");
        addButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        showsFrame.add(addButton);
    }

    /**
     * Sets the options of the delete button.
     */
     private void setDeleteButton()
    {
        deleteButton.setBounds(65,90,150,50);
        deleteButton.setText("Stergere show");
        deleteButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        deleteButton.setBackground(Color.LIGHT_GRAY);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        showsFrame.add(deleteButton);
    }

    /**
     * Sets the options of the update button.
     */
    private void setUpdateButton()
    {
        updateButton.setBounds(65,160,150,50);
        updateButton.setText("Update show");
        updateButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        updateButton.setBackground(Color.LIGHT_GRAY);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        showsFrame.add(updateButton);
    }

    /**
     * Sets the options of the show button.
     */
    private void setShowButton()
    {
        showButton.setBounds(65,230,150,50);
        showButton.setText("Afisare show-uri");
        showButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        showButton.setBackground(Color.LIGHT_GRAY);
        showButton.setFocusable(false);
        showButton.addActionListener(this);
        showsFrame.add(showButton);
    }

    /**
     * Action listener for the buttons that opens a new frame based on the clicked button.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton)
        {
            new ShowSubmitFrame();
        }
        else if(e.getSource()==deleteButton)
        {
            new ShowRemoveFrame();
        }
        else if(e.getSource()==updateButton)
        {
            new ShowSubmitIndexFrame();
        }
        else if(e.getSource()==showButton)
        {
            new ShowTable();
        }
    }
}
