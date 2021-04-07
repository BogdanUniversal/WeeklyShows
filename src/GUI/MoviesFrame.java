package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for all options of the movie object that implements the ActionListener interface.
 */
public class MoviesFrame implements ActionListener {
    private final JFrame moviesFrame = new JFrame();
    private final JButton addButton = new JButton();
    private final JButton deleteButton = new JButton();
    private final JButton updateButton = new JButton();
    private final JButton showMoviesButton = new JButton();

    /**
     * Default constructor.
     */
    public MoviesFrame()
    {
        setMoviesFrame();
        setAddButton();
        setDeleteButton();
        setUpdateButton();
        setMovieButton();

        moviesFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setMoviesFrame()
    {
        moviesFrame.setTitle("Filme");
        moviesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        moviesFrame.setSize(300,350);
        moviesFrame.setResizable(false);
        moviesFrame.setLayout(null);
    }

    /**
     * Sets the options of the add button.
     */
    private void setAddButton()
    {
        addButton.setBounds(65,20,150,50);
        addButton.setText("Adaugare film");
        addButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        moviesFrame.add(addButton);
    }

    /**
     * Sets the options of the delete button.
     */
    private void setDeleteButton()
    {
        deleteButton.setBounds(65,90,150,50);
        deleteButton.setText("Stergere film");
        deleteButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        deleteButton.setBackground(Color.LIGHT_GRAY);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        moviesFrame.add(deleteButton);
    }

    /**
     * Sets the options of the update button.
     */
    private void setUpdateButton()
    {
        updateButton.setBounds(65,160,150,50);
        updateButton.setText("Update movie");
        updateButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        updateButton.setBackground(Color.LIGHT_GRAY);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        moviesFrame.add(updateButton);
    }

    /**
     * Sets the options of the movie button.
     */
    private void setMovieButton()
    {
        showMoviesButton.setBounds(65,230,150,50);
        showMoviesButton.setText("Afisare filme");
        showMoviesButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        showMoviesButton.setBackground(Color.LIGHT_GRAY);
        showMoviesButton.setFocusable(false);
        showMoviesButton.addActionListener(this);
        moviesFrame.add(showMoviesButton);
    }

    /**
     * Action listener for the buttons that opens a new frame based on the clicked button.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton)
        {
            new MovieSubmitFrame();
        }
        else if(e.getSource()==deleteButton)
        {
            new MovieRemoveFrame();
        }
        else if(e.getSource()==updateButton)
        {
            new MovieSubmitIndexFrame();
        }
        else if(e.getSource()==showMoviesButton)
        {
            new MovieTable();
        }
    }
}
