package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for showing all types of shows from a given day.
 */
public class WeekFrame{
    private final JFrame weekFrame = new JFrame();
    private final Service serviceWeekFrame = new Service();
    private int zi;

    /**
     * Constructor with a parameter.
     * @param zi = int.
     */
    public WeekFrame(int zi)
    {
        this.zi=zi;

        setWeekFrame();
        setMoviesTable();
        setJournalsTable();
        setShowsTable();
        setSportsTable();

        weekFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setWeekFrame()
    {
        weekFrame.setTitle("Program TV pentru ziua "+zi);
        weekFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        weekFrame.setSize(550,850);
        weekFrame.setResizable(false);
        weekFrame.setLayout(null);
    }

    /**
     * Sets the options of the movies table and populates it.
     */
    private void setMoviesTable()
    {
        JLabel moviesLabel=new JLabel();
        moviesLabel.setText("Filmele din ziua "+zi);
        moviesLabel.setFont(new Font("Comic Sans", Font.BOLD,25));
        moviesLabel.setBounds(20,0,300,50);
        weekFrame.add(moviesLabel);

        String[] columnNamesMovies={"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataMovies=new String[100][6];
        int j=0;
        for(int i=0;i<serviceWeekFrame.getSizeFilm();i++)
        {
            if(serviceWeekFrame.getFilm(i).getZi()==zi)
            {
                dataMovies[j][0]= String.valueOf(serviceWeekFrame.getFilm(i).getZi());
                dataMovies[j][1]= String.valueOf(serviceWeekFrame.getFilm(i).getOra());
                dataMovies[j][2]= String.valueOf(serviceWeekFrame.getFilm(i).getMinut());
                dataMovies[j][3]= String.valueOf(serviceWeekFrame.getFilm(i).getDurata());
                dataMovies[j][4]= serviceWeekFrame.getFilm(i).getCategorie();
                j++;
            }
        }
        JTable weekMovies=new JTable(dataMovies,columnNamesMovies);
        JPanel panelMovies=new JPanel();
        panelMovies.setBounds(20,50,500,100);
        JScrollPane scrollPaneMovies=new JScrollPane(weekMovies);
        panelMovies.add(scrollPaneMovies);
        weekFrame.add(panelMovies);
    }

    /**
     * Sets the options of the journals table and populates it.
     */
    private void setJournalsTable()
    {
        JLabel journalsLabel=new JLabel();
        journalsLabel.setText("Jurnalele din ziua "+zi);
        journalsLabel.setFont(new Font("Comic Sans", Font.BOLD,25));
        journalsLabel.setBounds(20,200,300,50);
        weekFrame.add(journalsLabel);

        String[] columnNamesJournals={"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataJournals=new String[50][6];
        int j=0;
        for(int i=0;i<serviceWeekFrame.getSizeJurnal();i++)
        {
            if(serviceWeekFrame.getJurnal(i).getZi()==zi)
            {
                dataJournals[j][0]= String.valueOf(serviceWeekFrame.getJurnal(i).getZi());
                dataJournals[j][1]= String.valueOf(serviceWeekFrame.getJurnal(i).getOra());
                dataJournals[j][2]= String.valueOf(serviceWeekFrame.getJurnal(i).getMinut());
                dataJournals[j][3]= String.valueOf(serviceWeekFrame.getJurnal(i).getDurata());
                dataJournals[j][4]= serviceWeekFrame.getJurnal(i).getCategorie();
                j++;
            }
        }
        JTable weekJournals=new JTable(dataJournals,columnNamesJournals);
        JPanel panelJournals=new JPanel();
        panelJournals.setBounds(20,250,500,100);
        JScrollPane scrollPaneJournals=new JScrollPane(weekJournals);
        panelJournals.add(scrollPaneJournals);
        weekFrame.add(panelJournals);
    }

    /**
     * Sets the options of the shows table and populates it.
     */
    private void setShowsTable()
    {
        JLabel showsLabel=new JLabel();
        showsLabel.setText("Show-urile din ziua "+zi);
        showsLabel.setFont(new Font("Comic Sans", Font.BOLD,25));
        showsLabel.setBounds(20,400,300,50);
        weekFrame.add(showsLabel);

        String[] columnNamesShows={"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataShows=new String[50][6];
        int j=0;
        for(int i=0;i<serviceWeekFrame.getSizeShow();i++)
        {
            if(serviceWeekFrame.getShow(i).getZi()==zi)
            {
                dataShows[j][0]= String.valueOf(serviceWeekFrame.getShow(i).getZi());
                dataShows[j][1]= String.valueOf(serviceWeekFrame.getShow(i).getOra());
                dataShows[j][2]= String.valueOf(serviceWeekFrame.getShow(i).getMinut());
                dataShows[j][3]= String.valueOf(serviceWeekFrame.getShow(i).getDurata());
                dataShows[j][4]= serviceWeekFrame.getShow(i).getCategorie();
                j++;
            }
        }
        JTable weekShows=new JTable(dataShows,columnNamesShows);
        JPanel panelShows=new JPanel();
        panelShows.setBounds(20,450,500,100);
        JScrollPane scrollPaneShows=new JScrollPane(weekShows);
        panelShows.add(scrollPaneShows);
        weekFrame.add(panelShows);
    }

    /**
     * Sets the options of the sports table and populates it.
     */
    private void setSportsTable()
    {
        JLabel sportsLabel=new JLabel();
        sportsLabel.setText("Sporturile din ziua "+zi);
        sportsLabel.setFont(new Font("Comic Sans", Font.BOLD,25));
        sportsLabel.setBounds(20,600,300,50);
        weekFrame.add(sportsLabel);

        String[] columnNamesSports={"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataSports=new String[50][6];
        int j=0;
        for(int i=0;i<serviceWeekFrame.getSizeSport();i++)
        {
            if(serviceWeekFrame.getSport(i).getZi()==zi)
            {
                dataSports[j][0]= String.valueOf(serviceWeekFrame.getSport(i).getZi());
                dataSports[j][1]= String.valueOf(serviceWeekFrame.getSport(i).getOra());
                dataSports[j][2]= String.valueOf(serviceWeekFrame.getSport(i).getMinut());
                dataSports[j][3]= String.valueOf(serviceWeekFrame.getSport(i).getDurata());
                dataSports[j][4]= serviceWeekFrame.getSport(i).getCategorie();
                j++;
            }
        }
        JTable weekSports=new JTable(dataSports,columnNamesSports);
        JPanel panelSports=new JPanel();
        panelSports.setBounds(20,650,500,100);
        JScrollPane scrollPaneSports=new JScrollPane(weekSports);
        panelSports.add(scrollPaneSports);
        weekFrame.add(panelSports);
    }
}
