package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for the sport class options.
 */
public class SportsFrame implements ActionListener {
    private final JFrame sportsFrame = new JFrame();
    private final JButton addButton = new JButton();
    private final JButton deleteButton = new JButton();
    private final JButton updateButton = new JButton();
    private final JButton showSportsButton = new JButton();
    private final JButton orderButton = new JButton();

    /**
     * Default constructor.
     */
    public SportsFrame()
    {
        setSportsFrame();
        setAddButton();
        setDeleteButton();
        setUpdateButton();
        setOrderButton();
        setSportButton();

        sportsFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setSportsFrame()
    {
        sportsFrame.setTitle("Sporturi");
        sportsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sportsFrame.setSize(300,400);
        sportsFrame.setResizable(false);
        sportsFrame.setLayout(null);
    }

    /**
     * Sets the options of the add button.
     */
    private void setAddButton()
    {
        addButton.setBounds(65,20,150,50);
        addButton.setText("Adaugare sport");
        addButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        sportsFrame.add(addButton);
    }

    /**
     * Sets the options of the delete button.
     */
    private void setDeleteButton()
    {
        deleteButton.setBounds(65,90,150,50);
        deleteButton.setText("Stergere sport");
        deleteButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        deleteButton.setBackground(Color.LIGHT_GRAY);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        sportsFrame.add(deleteButton);
    }

    /**
     * Sets the options of the update button.
     */
    private void setUpdateButton()
    {
        updateButton.setBounds(65,160,150,50);
        updateButton.setText("Update sport");
        updateButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        updateButton.setBackground(Color.LIGHT_GRAY);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        sportsFrame.add(updateButton);
    }

    /**
     * Sets the options of the sport button.
     */
    private void setSportButton()
    {
        showSportsButton.setBounds(65,300,150,50);
        showSportsButton.setText("Afisare sporturi");
        showSportsButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        showSportsButton.setBackground(Color.LIGHT_GRAY);
        showSportsButton.setFocusable(false);
        showSportsButton.addActionListener(this);
        sportsFrame.add(showSportsButton);
    }

    /**
     * Sets the options of the order Button.
     */
    private void setOrderButton()
    {
        orderButton.setBounds(15,230,260,50);
        orderButton.setText("Ordonare sporturi dupa durata");
        orderButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        orderButton.setBackground(Color.LIGHT_GRAY);
        orderButton.setFocusable(false);
        orderButton.addActionListener(this);
        sportsFrame.add(orderButton);
    }

    /**
     * Action listener for the buttons that opens a new frame based on the clicked button.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton)
        {
            new SportSubmitFrame();
        }
        else if(e.getSource()==deleteButton)
        {
            new SportRemoveFrame();
        }
        else if(e.getSource()==updateButton)
        {
            new SportSubmitIndexFrame();
        }
        else if(e.getSource()==orderButton)
        {
            new SportOrderFrame();
        }
        else if(e.getSource()==showSportsButton)
        {
            new SportTable();
        }
    }
}
