package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for adding a new journal that implements the ActionListener interface.
 */
public class JournalSubmitFrame implements ActionListener {
    public JFrame journalSubmitFrame = new JFrame();

    private final Service serviceFrame = new Service();

    private final JButton submitButtonZi = new JButton();
    private final JTextField textFieldZi = new JTextField();
    private final JLabel textLabelZi = new JLabel();

    private final JButton submitButtonOra = new JButton();
    private final JTextField textFieldOra = new JTextField();
    private final JLabel textLabelOra = new JLabel();

    private final JButton submitButtonMinut = new JButton();
    private final JTextField textFieldMinut = new JTextField();
    private final JLabel textLabelMinut = new JLabel();

    private final JButton submitButtonDurata = new JButton();
    private final JTextField textFieldDurata = new JTextField();
    private final JLabel textLabelDurata = new JLabel();

    int pushes = 0, zi, ora, minut, durata;

    /**
     * Default constructor.
     */
    public JournalSubmitFrame()
    {
        setJournalSubmitFrame();
        setTextFieldZi();
        setTextFieldOra();
        setTextFieldMinut();
        setTextFieldDurata();

        journalSubmitFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setJournalSubmitFrame()
    {
        journalSubmitFrame.setTitle("Adaugare jurnal");
        journalSubmitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        journalSubmitFrame.setSize(300,350);
        journalSubmitFrame.setResizable(false);
        journalSubmitFrame.setLayout(null);
    }

    /**
     * Sets the button, label and textField for the "zi"(day) attribute.
     */
    private void setTextFieldZi()
    {
        submitButtonZi.setBounds(170,35,100,25);
        submitButtonZi.setText("Trimite");
        submitButtonZi.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButtonZi.setBackground(Color.LIGHT_GRAY);
        submitButtonZi.setFocusable(false);
        submitButtonZi.addActionListener(this);
        journalSubmitFrame.add(submitButtonZi);

        textLabelZi.setText("Introduceti ziua:");
        textLabelZi.setBounds(10,0,300,25);
        textLabelZi.setFont(new Font("Comic Sans", Font.BOLD,20));
        journalSubmitFrame.add(textLabelZi);

        textFieldZi.setBounds(10,35,150,25);
        textFieldZi.setFont(new Font("Comic Sans", Font.BOLD,15));
        journalSubmitFrame.add(textFieldZi);
    }

    /**
     * Sets the button, label and textField for the "ora"(hour) attribute.
     */
    private void setTextFieldOra()
    {
        submitButtonOra.setBounds(170,115,100,25);
        submitButtonOra.setText("Trimite");
        submitButtonOra.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButtonOra.setBackground(Color.LIGHT_GRAY);
        submitButtonOra.setFocusable(false);
        submitButtonOra.addActionListener(this);
        journalSubmitFrame.add(submitButtonOra);

        textLabelOra.setText("Introduceti ora:");
        textLabelOra.setBounds(10,80,300,25);
        textLabelOra.setFont(new Font("Comic Sans", Font.BOLD,20));
        journalSubmitFrame.add(textLabelOra);

        textFieldOra.setBounds(10,115,150,25);
        textFieldOra.setFont(new Font("Comic Sans", Font.BOLD,15));
        journalSubmitFrame.add(textFieldOra);
    }

    /**
     * Sets the button, label and textField for the "minut"(minute) attribute.
     */
    private void setTextFieldMinut()
    {
        submitButtonMinut.setBounds(170,195,100,25);
        submitButtonMinut.setText("Trimite");
        submitButtonMinut.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButtonMinut.setBackground(Color.LIGHT_GRAY);
        submitButtonMinut.setFocusable(false);
        submitButtonMinut.addActionListener(this);
        journalSubmitFrame.add(submitButtonMinut);

        textLabelMinut.setText("Introduceti minut:");
        textLabelMinut.setBounds(10,160,300,25);
        textLabelMinut.setFont(new Font("Comic Sans", Font.BOLD,20));
        journalSubmitFrame.add(textLabelMinut);

        textFieldMinut.setBounds(10,195,150,25);
        textFieldMinut.setFont(new Font("Comic Sans", Font.BOLD,15));
        journalSubmitFrame.add(textFieldMinut);
    }

    /**
     * Sets the button, label and textField for the "durata"(duration) attribute.
     */
    private void setTextFieldDurata()
    {
        submitButtonDurata.setBounds(170,275,100,25);
        submitButtonDurata.setText("Trimite");
        submitButtonDurata.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButtonDurata.setBackground(Color.LIGHT_GRAY);
        submitButtonDurata.setFocusable(false);
        submitButtonDurata.addActionListener(this);
        journalSubmitFrame.add(submitButtonDurata);

        textLabelDurata.setText("Introduceti durata:");
        textLabelDurata.setBounds(10,240,300,25);
        textLabelDurata.setFont(new Font("Comic Sans", Font.BOLD,20));
        journalSubmitFrame.add(textLabelDurata);

        textFieldDurata.setBounds(10,275,150,25);
        textFieldDurata.setFont(new Font("Comic Sans", Font.BOLD,15));
        journalSubmitFrame.add(textFieldDurata);
    }

    /**
     * Action listener for the buttons, that automatically adds a journal if all the textFields have been completed.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submitButtonZi)
        {
            zi=Integer.parseInt(textFieldZi.getText());
            submitButtonZi.setVisible(false);
            textLabelZi.setVisible(false);
            textFieldZi.setVisible(false);
            pushes++;
            if(pushes==4)
            {
                serviceFrame.add(ora,minut,zi,durata,"journal");
                journalSubmitFrame.dispose();
            }
        }
        else if(e.getSource()==submitButtonOra)
        {
            ora=Integer.parseInt(textFieldOra.getText());
            submitButtonOra.setVisible(false);
            textLabelOra.setVisible(false);
            textFieldOra.setVisible(false);
            pushes++;
            if(pushes==4)
            {
                serviceFrame.add(ora,minut,zi,durata,"journal");
                journalSubmitFrame.dispose();
            }
        }
        else if(e.getSource()==submitButtonMinut)
        {
            minut=Integer.parseInt(textFieldMinut.getText());
            submitButtonMinut.setVisible(false);
            textLabelMinut.setVisible(false);
            textFieldMinut.setVisible(false);
            pushes++;
            if(pushes==4)
            {
                serviceFrame.add(ora,minut,zi,durata,"journal");
                journalSubmitFrame.dispose();
            }
        }
        else if(e.getSource()==submitButtonDurata)
        {
            durata=Integer.parseInt(textFieldDurata.getText());
            submitButtonDurata.setVisible(false);
            textLabelDurata.setVisible(false);
            textFieldDurata.setVisible(false);
            pushes++;
            if(pushes==4)
            {
                serviceFrame.add(ora,minut,zi,durata,"journal");
                journalSubmitFrame.dispose();
            }
        }
    }
}
