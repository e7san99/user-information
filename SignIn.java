package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn implements ActionListener {
    User user;
    public SignIn(User user){
        this.user = user;
    }

    private JPanel panel;
    private JFrame frame;
    private JLabel label;
    private JTextField email;
    private JPasswordField passwordField;
    private JCheckBox checkbox;
    private JButton button;
    public void loginSystem(){
        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame();
        frame.setSize(350,300);
        frame.setTitle("Login System");
        frame.setLocationRelativeTo(null); //frame aka la cenetr pshan dadat
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);


        label = new JLabel("Email:");
        label.setBounds(80,100,80,18);
        panel.add(label);

        email = new JTextField();
        email.setBounds(130,102,120,18);
        panel.add(email);
        ////////////////////////////////////////////////////
                //password
        label = new JLabel("Password:");
        label.setBounds(55,135,80,18);
        panel.add(label);

        passwordField = new JPasswordField();
        passwordField.setBounds(130,135,120,18);
        panel.add(passwordField);
        //////////////////////////////////////////////
        checkbox = new JCheckBox();
        checkbox.setBounds(257,134,20,20);
        checkbox.addActionListener(e->{
            if (checkbox.isSelected())
                passwordField.setEchoChar((char)0);
            else
                passwordField.setEchoChar('*');
        });
        panel.add(checkbox);


                        //button
        button = new JButton("login");
        button.setBounds(155,180,65,20);
        button.addActionListener(this);
        panel.add(button);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(email.getText().equals(user.getEmail()) && String.valueOf(passwordField.getPassword()).equals(user.getPasswordField())) {

            JOptionPane.showMessageDialog(null, "Sign in Successful", "sign in", JOptionPane.INFORMATION_MESSAGE);
            Information information = new Information(user);
            information.info();
            frame.setVisible(false);

        }else if(email.getText().equals(user.getEmail()) && passwordField.getPassword().length!=0)
            JOptionPane.showMessageDialog(null,"Password incorrect","Failed", JOptionPane.ERROR_MESSAGE);

        else if (email.getText().isEmpty() && passwordField.getPassword().length==0)
            JOptionPane.showMessageDialog(null,"Email and Password are Empty","Failed", JOptionPane.INFORMATION_MESSAGE);

        else if (email.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Email is Empty","Failed", JOptionPane.INFORMATION_MESSAGE);

        else if (passwordField.getPassword().length==0)
            JOptionPane.showMessageDialog(null,"password is Empty","Failed", JOptionPane.INFORMATION_MESSAGE);

        else
            JOptionPane.showMessageDialog(null,"invalid Data","Failed", JOptionPane.WARNING_MESSAGE);

    }
}
