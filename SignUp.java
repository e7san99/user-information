package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp implements ActionListener {
    private JPanel panel;
    private JFrame frame;
    private JLabel label;
    private JLabel gender;
    private JTextField firstName , lastName , email;
    private JPasswordField passwordField;
    private JCheckBox checkBox;
    private JRadioButton radioButton1 , radioButton2;
    private ButtonGroup buttonGroup;
    private JButton button;
    private JButton reset;

    User user = new User();            //User Class

    public void register(){

        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame();
        frame.setSize(350,450);
        frame.setTitle("Sign-up System");
        frame.add(panel);
        frame.setLocationRelativeTo(null); //frame aka la cenetr pshan dadat
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        //label Method
        label();

        //textfield Method
        textfield();

        //Gender
        genderMethod();

        //checkbox Method
        checkbox();

        //button Method
        button();

        //reset
        reset();

        frame.setVisible(true);   //Frame Visibility
    }


    private void label() {
        label = new JLabel("First Name:");                    //firstName label
        label.setBounds(50,2,80,150);
        panel.add(label);

        label = new JLabel("Last Name:");                   //lastName label
        label.setBounds(50,2,80,220);
        panel.add(label);

        label = new JLabel("Email:");                       //email label
        label.setBounds(50,2,80,290);
        panel.add(label);

        label = new JLabel("Password:");                    //password Label
        label.setBounds(50,2,80,350);
        panel.add(label);

    }
    private void textfield() {
        firstName = new JTextField();
        firstName.setBounds(130,70,130,18);
        panel.add(firstName);

        lastName = new JTextField();
        lastName.setBounds(130,105,130,18);
        panel.add(lastName);

        email = new JTextField();
        email.setBounds(130,140,130,18);
        panel.add(email);

        passwordField = new JPasswordField();
        passwordField.setBounds(130,170,130,18);
        panel.add(passwordField);
    }

    private void genderMethod() {
        gender = new JLabel("Gender:");
        gender.setBounds(50,200,80,20);
        panel.add(gender);

        radioButton1 = new JRadioButton();
        radioButton1.setText("Male");
        radioButton1.setBounds(130,200,80,20);
        panel.add(radioButton1);

        radioButton2 = new JRadioButton();
        radioButton2.setText("Female");
        radioButton2.setBounds(210,200,120,20);
        panel.add(radioButton2);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
    }

    private void button() {
        button = new JButton("Sign Up");
        button.setBounds(150,260,80,20);
        button.addActionListener(this);
        panel.add(button);
    }

    private void checkbox() {
        checkBox = new JCheckBox();
        checkBox.setBounds(260,168,20,20);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected())
                passwordField.setEchoChar((char) 0);
            else
                passwordField.setEchoChar('*');
        });
        panel.add(checkBox);
    }

    private void reset() {
        reset = new JButton("Reset");
        reset.setBounds(230,300,75,15);
        reset.addActionListener(e->{
            firstName.setText(null);
            lastName.setText(null);
            email.setText(null);
            passwordField.setText(null);
        });
        panel.add(reset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());
        user.setEmail(email.getText());
        user.setPasswordField(String.valueOf(passwordField.getPassword()));

        if (radioButton1.isSelected())
            user.setGender(radioButton1.getText());
        else if (radioButton2.isSelected())
            user.setGender(radioButton2.getText());

        if ((!user.getFirstName().isEmpty() || !user.getLastName().isEmpty() ||
                !user.getEmail().isEmpty() || !user.getPasswordField().isEmpty())) {

            JOptionPane.showMessageDialog(null, "Sign up successful", "SignUp", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            SignIn signIn = new SignIn(user);
            signIn.loginSystem();

        }else if((user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
                user.getEmail().isEmpty() || user.getPasswordField().isEmpty()) ){
            JOptionPane.showMessageDialog(null,"Blank Filed !","Try Again", JOptionPane.ERROR_MESSAGE);
        }
    }

}
