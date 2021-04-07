package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for the journal class options.
 */
public class JournalsFrame implements ActionListener {
    private final JFrame journalsFrame = new JFrame();
    private final JButton addButton = new JButton();
    private final JButton deleteButton = new JButton();
    private final JButton updateButton = new JButton();
    private final JButton showJournalsButton = new JButton();
    private final JButton orderButton = new JButton();

    /**
     * Default constructor.
     */
    public JournalsFrame()
    {
        setJournalsFrame();
        setAddButton();
        setDeleteButton();
        setUpdateButton();
        setOrderButton();
        setJournalButton();

        journalsFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setJournalsFrame()
    {
        journalsFrame.setTitle("Jurnale");
        journalsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        journalsFrame.setSize(300,400);
        journalsFrame.setResizable(false);
        journalsFrame.setLayout(null);
    }

    /**
     * Sets the options of the add button.
     */
    private void setAddButton()
    {
        addButton.setBounds(65,20,150,50);
        addButton.setText("Adaugare jurnal");
        addButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        journalsFrame.add(addButton);
    }

    /**
     * Sets the options of the delete button.
     */
    private void setDeleteButton()
    {
        deleteButton.setBounds(65,90,150,50);
        deleteButton.setText("Stergere jurnal");
        deleteButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        deleteButton.setBackground(Color.LIGHT_GRAY);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        journalsFrame.add(deleteButton);
    }

    /**
     * Sets the options of the update button.
     */
    private void setUpdateButton()
    {
        updateButton.setBounds(65,160,150,50);
        updateButton.setText("Update jurnal");
        updateButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        updateButton.setBackground(Color.LIGHT_GRAY);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        journalsFrame.add(updateButton);
    }

    /**
     * Sets the options of the journal button.
     */
    private void setJournalButton()
    {
        showJournalsButton.setBounds(65,300,150,50);
        showJournalsButton.setText("Afisare jurnale");
        showJournalsButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        showJournalsButton.setBackground(Color.LIGHT_GRAY);
        showJournalsButton.setFocusable(false);
        showJournalsButton.addActionListener(this);
        journalsFrame.add(showJournalsButton);
    }

    /**
     * Sets the options of the order Button.
     */
    private void setOrderButton()
    {
        orderButton.setBounds(15,230,260,50);
        orderButton.setText("Ordonare jurnale dupa durata");
        orderButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        orderButton.setBackground(Color.LIGHT_GRAY);
        orderButton.setFocusable(false);
        orderButton.addActionListener(this);
        journalsFrame.add(orderButton);
    }

    /**
     * Action listener for the buttons that opens a new frame based on the clicked button.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton)
        {
            new JournalSubmitFrame();
        }
        else if(e.getSource()==deleteButton)
        {
            new JournalRemoveFrame();
        }
        else if(e.getSource()==updateButton)
        {
            new JournalSubmitIndexFrame();
        }
        else if(e.getSource()==orderButton)
        {
            new JournalOrderFrame();
        }
        else if(e.getSource()==showJournalsButton)
        {
            new JournalTable();
        }
    }
}
