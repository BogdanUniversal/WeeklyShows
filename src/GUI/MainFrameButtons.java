package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Derived class from MainFrameLabels that has the buttons for all the types of shows and also implements
 * the ActionListener interface.
 */
public class MainFrameButtons extends MainFrameLabels implements ActionListener {
    private final JButton buttonMovies = new JButton();
    private final JButton buttonJournals = new JButton();
    private final JButton buttonShows = new JButton();
    private final JButton buttonSports = new JButton();
    private final JButton buttonWeek = new JButton();

    /**
     * Default constructor.
     */
    public MainFrameButtons()
    {
        setButtonMovies();
        setButtonJournals();
        setButtonShows();
        setButtonSports();
        setButtonWeek();

        mainFrame.setVisible(true);
    }

    /**
     * Sets the options for the movies button.
     */
    public void setButtonMovies()
    {
        buttonMovies.setBounds(20,150,150,50);
        buttonMovies.setText("Filme");
        buttonMovies.setFont(new Font("Comic Sans", Font.BOLD,15));
        buttonMovies.setBackground(Color.LIGHT_GRAY);
        buttonMovies.setFocusable(false);
        buttonMovies.addActionListener(this);
        mainFrame.add(buttonMovies);
    }

    /**
     * Sets the options for the journals button.
     */
    public void setButtonJournals()
    {
        buttonJournals.setBounds(350,150,150,50);
        buttonJournals.setText("Jurnale");
        buttonJournals.setFont(new Font("Comic Sans", Font.BOLD,15));
        buttonJournals.setBackground(Color.LIGHT_GRAY);
        buttonJournals.setFocusable(false);
        buttonJournals.addActionListener(this);
        mainFrame.add(buttonJournals);
    }

    /**
     * Sets the options for the shows button.
     */
    public void setButtonShows()
    {
        buttonShows.setBounds(20,410,150,50);
        buttonShows.setText("Show-uri");
        buttonShows.setFont(new Font("Comic Sans", Font.BOLD,15));
        buttonShows.setBackground(Color.LIGHT_GRAY);
        buttonShows.setFocusable(false);
        buttonShows.addActionListener(this);
        mainFrame.add(buttonShows);
    }

    /**
     * Sets the options for the sports button.
     */
    public void setButtonSports()
    {
        buttonSports.setBounds(350,410,150,50);
        buttonSports.setText("Sporturi");
        buttonSports.setFont(new Font("Comic Sans", Font.BOLD,15));
        buttonSports.setBackground(Color.LIGHT_GRAY);
        buttonSports.setFocusable(false);
        buttonSports.addActionListener(this);
        mainFrame.add(buttonSports);
    }

    /**
     * Sets the options for the week button.
     */
    public void setButtonWeek()
    {
        buttonWeek.setBounds(130,700,300,50);
        buttonWeek.setText("Program TV pentru o zi");
        buttonWeek.setFont(new Font("Comic Sans", Font.BOLD,15));
        buttonWeek.setBackground(Color.LIGHT_GRAY);
        buttonWeek.setFocusable(false);
        buttonWeek.addActionListener(this);
        mainFrame.add(buttonWeek);
    }

    /**
     * Action listener for the buttons, that opens a new frame based on the clicked button.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonWeek)
        {
            new SubmitFrame();
        }
        else if(e.getSource()==buttonMovies)
        {
            new MoviesFrame();
        }
        else if(e.getSource()==buttonJournals)
        {
            new JournalsFrame();
        }
        else if(e.getSource()==buttonShows)
        {
            new ShowsFrame();
        }
        else if(e.getSource()==buttonSports)
        {
            new SportsFrame();
        }
    }
}
