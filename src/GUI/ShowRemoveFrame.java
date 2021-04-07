package GUI;

import Service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for removing a show object.
 */
public class ShowRemoveFrame implements ActionListener {
    private final JFrame showRemoveFrame = new JFrame();

    private final Service serviceFrame= new Service();

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

    private int pushes = 0, zi, ora, minut, durata;

    /**
     * Default constructor.
     */
    public ShowRemoveFrame()
    {
        setShowRemoveFrame();
        setTextFieldZi();
        setTextFieldOra();
        setTextFieldMinut();
        setTextFieldDurata();

        showRemoveFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setShowRemoveFrame()
    {
        showRemoveFrame.setTitle("Stergere show");
        showRemoveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showRemoveFrame.setSize(300,350);
        showRemoveFrame.setResizable(false);
        showRemoveFrame.setLayout(null);
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
        showRemoveFrame.add(submitButtonZi);

        textLabelZi.setText("Introduceti ziua:");
        textLabelZi.setBounds(10,0,300,25);
        textLabelZi.setFont(new Font("Comic Sans", Font.BOLD,20));
        showRemoveFrame.add(textLabelZi);

        textFieldZi.setBounds(10,35,150,25);
        textFieldZi.setFont(new Font("Comic Sans", Font.BOLD,15));
        showRemoveFrame.add(textFieldZi);
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
        showRemoveFrame.add(submitButtonOra);

        textLabelOra.setText("Introduceti ora:");
        textLabelOra.setBounds(10,80,300,25);
        textLabelOra.setFont(new Font("Comic Sans", Font.BOLD,20));
        showRemoveFrame.add(textLabelOra);

        textFieldOra.setBounds(10,115,150,25);
        textFieldOra.setFont(new Font("Comic Sans", Font.BOLD,15));
        showRemoveFrame.add(textFieldOra);
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
        showRemoveFrame.add(submitButtonMinut);

        textLabelMinut.setText("Introduceti minut:");
        textLabelMinut.setBounds(10,160,300,25);
        textLabelMinut.setFont(new Font("Comic Sans", Font.BOLD,20));
        showRemoveFrame.add(textLabelMinut);

        textFieldMinut.setBounds(10,195,150,25);
        textFieldMinut.setFont(new Font("Comic Sans", Font.BOLD,15));
        showRemoveFrame.add(textFieldMinut);
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
        showRemoveFrame.add(submitButtonDurata);

        textLabelDurata.setText("Introduceti durata:");
        textLabelDurata.setBounds(10,240,300,25);
        textLabelDurata.setFont(new Font("Comic Sans", Font.BOLD,20));
        showRemoveFrame.add(textLabelDurata);

        textFieldDurata.setBounds(10,275,150,25);
        textFieldDurata.setFont(new Font("Comic Sans", Font.BOLD,15));
        showRemoveFrame.add(textFieldDurata);
    }

    /**
     * Action listener for the buttons, that automatically removes a show if all the textFields have been completed.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButtonZi)
        {
            zi=Integer.parseInt(textFieldZi.getText());
            submitButtonZi.setVisible(false);
            textLabelZi.setVisible(false);
            textFieldZi.setVisible(false);
            pushes++;
            if(pushes==4)
            {
                serviceFrame.remove(ora,minut,zi,durata,"show");
                showRemoveFrame.dispose();
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
                serviceFrame.remove(ora,minut,zi,durata,"show");
                showRemoveFrame.dispose();
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
                serviceFrame.remove(ora,minut,zi,durata,"show");
                showRemoveFrame.dispose();
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
                serviceFrame.remove(ora,minut,zi,durata,"show");
                showRemoveFrame.dispose();
            }
        }

    }
}
