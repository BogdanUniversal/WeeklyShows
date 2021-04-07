package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for showing all show objects.
 */
public class ShowTable {
    private final JFrame showFrame = new JFrame();
    private final Service serviceShowFrame = new Service();

    /**
     * Default constructor.
     */
    public ShowTable() {
        setShowFrame();
        setShowTable();

        showFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setShowFrame()
    {
        showFrame.setTitle("Show-uri");
        showFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showFrame.setSize(550, 450);
        showFrame.setResizable(false);
        showFrame.setLayout(null);
    }

    /**
     * Sets the options of the label and populates the table with all show objects.
     */
    private void setShowTable()
    {
        JLabel moviesLabel = new JLabel();
        moviesLabel.setText("Show-urile saptamanii");
        moviesLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        moviesLabel.setBounds(20, 0, 300, 50);
        showFrame.add(moviesLabel);

        String[] columnNamesShows = {"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataShows = new String[100][6];
        int j = 0;
        for (int i = 0; i < serviceShowFrame.getSizeShow(); i++) {
            dataShows[j][0] = String.valueOf(serviceShowFrame.getShow(i).getZi());
            dataShows[j][1] = String.valueOf(serviceShowFrame.getShow(i).getOra());
            dataShows[j][2] = String.valueOf(serviceShowFrame.getShow(i).getMinut());
            dataShows[j][3] = String.valueOf(serviceShowFrame.getShow(i).getDurata());
            dataShows[j][4] = serviceShowFrame.getShow(i).getCategorie();
            j++;
        }
        JTable weekShows = new JTable(dataShows, columnNamesShows);
        JPanel panelShows = new JPanel();
        panelShows.setBounds(20, 50, 500, 300);
        JScrollPane scrollPaneMovies = new JScrollPane(weekShows);
        panelShows.add(scrollPaneMovies);
        showFrame.add(panelShows);
    }
}
