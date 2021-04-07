package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for showing all journal objects.
 */
public class JournalTable {
    private final JFrame journalFrame = new JFrame();
    private final Service serviceMovieFrame = new Service();

    /**
     * Default constructor
     */
    public JournalTable() {
        setJournalFrame();
        setJournalTable();

        journalFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setJournalFrame()
    {
        journalFrame.setTitle("Jurnale");
        journalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        journalFrame.setSize(550, 450);
        journalFrame.setResizable(false);
        journalFrame.setLayout(null);
    }

    /**
     * Sets the options of the label and populates the table with all journal objects.
     */
    private void setJournalTable()
    {
        JLabel journalsLabel = new JLabel();
        journalsLabel.setText("Jurnalele saptamanii");
        journalsLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        journalsLabel.setBounds(20, 0, 300, 50);
        journalFrame.add(journalsLabel);

        String[] columnNamesJournals = {"Zi", "Ora", "Minut", "Durata", "Categorie"};
        String[][] dataJournals = new String[100][6];
        int j = 0;
        for (int i = 0; i < serviceMovieFrame.getSizeJurnal(); i++) {
            dataJournals[j][0] = String.valueOf(serviceMovieFrame.getJurnal(i).getZi());
            dataJournals[j][1] = String.valueOf(serviceMovieFrame.getJurnal(i).getOra());
            dataJournals[j][2] = String.valueOf(serviceMovieFrame.getJurnal(i).getMinut());
            dataJournals[j][3] = String.valueOf(serviceMovieFrame.getJurnal(i).getDurata());
            dataJournals[j][4] = serviceMovieFrame.getJurnal(i).getCategorie();
            j++;
        }
        JTable weekJournals = new JTable(dataJournals, columnNamesJournals);
        JPanel panelJournals = new JPanel();
        panelJournals.setBounds(20, 50, 500, 300);
        JScrollPane scrollPaneJournals = new JScrollPane(weekJournals);
        panelJournals.add(scrollPaneJournals);
        journalFrame.add(panelJournals);
    }
}
