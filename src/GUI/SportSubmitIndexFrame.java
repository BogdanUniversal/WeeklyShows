package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SportSubmitIndexFrame implements ActionListener {
    JFrame submitFrame;
    JButton submitButton;
    JLabel textLabel;
    JTextField textField;
    String index;

    public SportSubmitIndexFrame()
    {
        submitFrame=new JFrame();
        submitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        submitFrame.setSize(300,200);
        submitFrame.setResizable(false);
        submitFrame.setLayout(null);
        submitFrame.setTitle("Introduceti pozitia!");

        submitButton=new JButton();
        submitButton.setBounds(170,50,100,50);
        submitButton.setText("Trimite");
        submitButton.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitFrame.add(submitButton);

        textLabel=new JLabel();
        textLabel.setText("Introduceti pozitia elementului:");
        textLabel.setBounds(10,10,300,25);
        textLabel.setFont(new Font("Comic Sans", Font.BOLD,17));
        submitFrame.add(textLabel);

        textField=new JTextField();
        textField.setBounds(5,50,150,50);
        textField.setFont(new Font("Comic Sans", Font.BOLD,15));
        submitFrame.add(textField);

        submitFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton)
        {
            index=new String(textField.getText());
            submitFrame.dispose();
            new SportUpdateFrame(Integer.parseInt(index));
        }
    }

    public String getZi()
    {
        return this.index;
    }
}
