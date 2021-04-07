package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for showing all sport objects.
 */
public class SportTable {
    private final JFrame sportFrame = new JFrame();
    private final Service serviceSportFrame = new Service();

    /**
     * Default constructor.
     */
    public SportTable() {
        setSportFrame();
        setSportTable();

        sportFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setSportFrame()
    {
        sportFrame.setTitle("Sporturi");
        sportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sportFrame.setSize(550, 450);
        sportFrame.setResizable(false);
        sportFrame.setLayout(null);
    }

    /**
     * Sets the options of the label and populates the table with all journal objects.
     */
    private void setSportTable()
    {
        JLabel sportsLabel = new JLabel();
        sportsLabel.setText("Sporturile saptamanii");
        sportsLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sportsLabel.setBounds(20, 0, 300, 50);
        sportFrame.add(sportsLabel);

        String[] columnNamesSports = {"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataSports = new String[100][6];
        int j = 0;
        for (int i = 0; i < serviceSportFrame.getSizeSport(); i++) {
            dataSports[j][0] = String.valueOf(serviceSportFrame.getSport(i).getZi());
            dataSports[j][1] = String.valueOf(serviceSportFrame.getSport(i).getOra());
            dataSports[j][2] = String.valueOf(serviceSportFrame.getSport(i).getMinut());
            dataSports[j][3] = String.valueOf(serviceSportFrame.getSport(i).getDurata());
            dataSports[j][4] = serviceSportFrame.getSport(i).getCategorie();
            j++;
        }
        JTable weekSports = new JTable(dataSports, columnNamesSports);
        JPanel panelSports = new JPanel();
        panelSports.setBounds(20, 50, 500, 300);
        JScrollPane scrollPaneJournals = new JScrollPane(weekSports);
        panelSports.add(scrollPaneJournals);
        sportFrame.add(panelSports);
    }
}
