package GUI;

import javax.swing.*;

/**
 * Derived class from Mainframe that has all the labels for all the types of shows.
 */
public class MainFrameLabels extends MainFrame{
    public MainFrameLabels()
    {
        setMoviesLabel();
        setJournalsLabel();
        setShowsLabel();
        setSportsLabel();
        setWeekLabel();
    }

    /**
     * Sets the label for movies.
     */
    private void setMoviesLabel()
    {
        ImageIcon movies=new ImageIcon("movies.png");

        JLabel moviesLabel=new JLabel();
        moviesLabel.setIcon(movies);
        moviesLabel.setBounds(20,0,150,150);
        mainFrame.add(moviesLabel);
    }

    /**
     * Sets the label for journals.
     */
    private void setJournalsLabel()
    {
        ImageIcon journals=new ImageIcon("news.png");

        JLabel journalsLabel=new JLabel();
        journalsLabel.setIcon(journals);
        journalsLabel.setBounds(350,0,150,150);
        mainFrame.add(journalsLabel);
    }

    /**
     * Sets the label for shows.
     */
    private void setShowsLabel()
    {
        ImageIcon shows=new ImageIcon("shows.png");

        JLabel showsLabel=new JLabel();
        showsLabel.setIcon(shows);
        showsLabel.setBounds(10,250,150,150);
        mainFrame.add(showsLabel);
    }

    /**
     * Sets the label for sports.
     */
    private void setSportsLabel()
    {
        ImageIcon sports=new ImageIcon("sports.png");

        JLabel sportsLabel=new JLabel();
        sportsLabel.setIcon(sports);
        sportsLabel.setBounds(350,250,150,150);
        mainFrame.add(sportsLabel);
    }

    /**
     * Sets the label for week.
     */
    private void setWeekLabel()
    {
        ImageIcon week=new ImageIcon("week.png");

        JLabel weekLabel=new JLabel();
        weekLabel.setIcon(week);
        weekLabel.setBounds(130,500,300,200);
        mainFrame.add(weekLabel);
    }
}
