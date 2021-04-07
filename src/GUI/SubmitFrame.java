package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for selecting a desired day for which to show all types of shows.
 */
public class SubmitFrame implements ActionListener {
    private final JFrame submitFrame = new JFrame();
    private final JButton submitButton = new JButton();
    private final JLabel textLabel = new JLabel();
    private final JTextField textField = new JTextField();
    private String zi;

    /**
     * Default constructor.
     */
    public SubmitFrame()
    {
        setSubmitFrame();
        setSubmitTextField();

        submitFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    private void setSubmitFrame()
    {
        submitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        submitFrame.setSize(300,200);
        submitFrame.setResizable(false);
        submitFrame.setLayout(null);
        submitFrame.setTitle("Introduceti ziua!");
    }

    /**
     * Sets the options of the TextField.
     */
    private void setSubmitTextField()
    {
        submitButton.setBounds(170,50,100,50);
        submitButton.setText("Trimite");
        submitButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitFrame.add(submitButton);

        textLabel.setText("Introduceti ziua dorita:");
        textLabel.setBounds(10,0,300,25);
        textLabel.setFont(new Font("Comic Sans", Font.BOLD,23));
        submitFrame.add(textLabel);

        textField.setBounds(5,50,150,50);
        textField.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitFrame.add(textField);
    }

    /**
     * Action listener for the button that opens a new WeekFrame based on the entered day.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton)
        {
            zi=new String(textField.getText());
            new WeekFrame(Integer.parseInt(zi));
            submitFrame.dispose();
        }
    }

    /**
     * Get method for the "zi"(day) attribute.
     * @return zi = String.
     */
    public String getZi()
    {
        return this.zi;
    }
}
