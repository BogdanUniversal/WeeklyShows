package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for showing all movie objects.
 */
public class MovieTable {
    private final JFrame movieFrame = new JFrame();
    private final Service serviceMovieFrame = new Service();

    /**
     * Default constructor.
     */
    public MovieTable() {
        setMovieFrame();
        setMovieTable();

        movieFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setMovieFrame()
    {
        movieFrame.setTitle("Filme");
        movieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        movieFrame.setSize(550, 450);
        movieFrame.setResizable(false);
        movieFrame.setLayout(null);
    }
    /**
     * Sets the options of the label and populates the table with all movie objects.
     */

    private void setMovieTable()
    {
        JLabel moviesLabel = new JLabel();
        moviesLabel.setText("Filmele saptamanii");
        moviesLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        moviesLabel.setBounds(20, 0, 300, 50);
        movieFrame.add(moviesLabel);

        String[] columnNamesMovies = {"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataMovies = new String[100][6];
        int j = 0;
        for (int i = 0; i < serviceMovieFrame.getSizeFilm(); i++) {
            dataMovies[j][0] = String.valueOf(serviceMovieFrame.getFilm(i).getZi());
            dataMovies[j][1] = String.valueOf(serviceMovieFrame.getFilm(i).getOra());
            dataMovies[j][2] = String.valueOf(serviceMovieFrame.getFilm(i).getMinut());
            dataMovies[j][3] = String.valueOf(serviceMovieFrame.getFilm(i).getDurata());
            dataMovies[j][4] = serviceMovieFrame.getFilm(i).getCategorie();
            j++;
        }
        JTable weekMovies = new JTable(dataMovies, columnNamesMovies);
        JPanel panelMovies = new JPanel();
        panelMovies.setBounds(20, 50, 500, 300);
        JScrollPane scrollPaneMovies = new JScrollPane(weekMovies);
        panelMovies.add(scrollPaneMovies);
        movieFrame.add(panelMovies);
    }
}
