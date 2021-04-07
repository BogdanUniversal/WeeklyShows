package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Frame for entering the index.
 */
public class JournalSubmitIndexFrame implements ActionListener {
    private final JFrame submitFrame = new JFrame();
    private final JButton submitButton = new JButton();
    private final JLabel textLabel = new JLabel();
    private final JTextField textField = new JTextField();
    private String index;

    /**
     * Default constructor.
     */
    public JournalSubmitIndexFrame()
    {
        setSubmitFrame();
        setSubmitTextField();

        submitFrame.setVisible(true);
    }

    /**
     * Sets the options of the frame.
     */
    void setSubmitFrame()
    {
        submitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        submitFrame.setSize(300,200);
        submitFrame.setResizable(false);
        submitFrame.setLayout(null);
        submitFrame.setTitle("Introduceti pozitia!");
    }

    /**
     * Sets the options of the button, label and textField.
     */
    void setSubmitTextField()
    {
        submitButton.setBounds(170,50,100,50);
        submitButton.setText("Trimite");
        submitButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitFrame.add(submitButton);

        textLabel.setText("Introduceti pozitia elementului:");
        textLabel.setBounds(10,10,300,25);
        textLabel.setFont(new Font("Comic Sans", Font.BOLD,17));
        submitFrame.add(textLabel);

        textField.setBounds(5,50,150,50);
        textField.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitFrame.add(textField);
    }

    /**
     * Action listener for the button, that creates a new frame with the given index.
     * @param e = ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton)
        {
            index=new String(textField.getText());
            submitFrame.dispose();
            new JournalUpdateFrame(Integer.parseInt(index));
        }
    }

    /**
     * Get method for the index attribute.
     * @return index = int.
     */
    public String getZi()
    {
        return this.index;
    }
}
