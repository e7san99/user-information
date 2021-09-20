package com.company;

import javax.swing.*;

public class Information {

    User user;
    public Information(User user){
        this.user = user;
    }

    private JPanel panel;
    private JFrame frame;
    private JLabel label;
    private JButton exit;
    private JButton create;

    public void info(){
        panel = new JPanel();
        panel.setLayout(null);

        frame = new JFrame();
        frame.setSize(300,350);
        frame.setTitle("User Information");
        frame.setLocationRelativeTo(null); //frame aka la cenetr pshan dadat
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Label Information

        label = new JLabel("Result User Information");
        label.setBounds(70,30,150,40);
        panel.add(label);

        label = new JLabel("\uD83D\uDC7D");
        label.setBounds(210,30,150,40);
        panel.add(label);

        label = new JLabel("\uD83D\uDC7D");
        label.setBounds(55,30,150,40);
        panel.add(label);

                //First Name Information
        label = new JLabel("Your First Name is:");
        label.setBounds(30,90,150,40);
        panel.add(label);

        label = new JLabel(user.getFirstName());
        label.setBounds(160,100,150,20);
        panel.add(label);

        label = new JLabel("_____________________________");
        label.setBounds(20,100,200,40);
        panel.add(label);

                    //Last Name Information
        label = new JLabel("Your Last Name is:");
        label.setBounds(30,130,150,40);
        panel.add(label);

        label = new JLabel(user.getLastName());
        label.setBounds(160,140,150,20);
        panel.add(label);

        label = new JLabel("_____________________________");
        label.setBounds(20,140,200,40);
        panel.add(label);

                    //Email Information
        label = new JLabel("Your Email is:");
        label.setBounds(30,170,150,40);
        panel.add(label);

        label = new JLabel(user.getEmail());
        label.setBounds(120,180,250,20);
        panel.add(label);

        label = new JLabel("_____________________________");
        label.setBounds(20,180,200,40);
        panel.add(label);

                    //Password Infromation
        label = new JLabel("Your Pass is:");
        label.setBounds(30,210,150,40);
        panel.add(label);

        label = new JLabel(user.getPasswordField());
        label.setBounds(120,220,250,20);
        panel.add(label);

        label = new JLabel("_____________________________");
        label.setBounds(20,220,200,40);
        panel.add(label);

                //Gender
        label = new JLabel("Your Gender is:");
        label.setBounds(30,240,150,40);
        panel.add(label);

        label = new JLabel(user.getGender());
        label.setBounds(140,250,250,20);
        panel.add(label);

        label = new JLabel("_____________________________");
        label.setBounds(20,220,200,40);
        panel.add(label);

/////////////////////////////////
        exit = new JButton("Exit");
        exit.setBounds(10,285,60,20);
        exit.addActionListener(e-> {
            int response = JOptionPane.showConfirmDialog(null, "You want Exit", "EXIT",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response==JOptionPane.YES_OPTION)
            System.exit(0);
        });
        panel.add(exit);
////////////////////////////////

        create = new JButton("Create New Account");
        create.setBounds(110,285,160,20);
        create.addActionListener(e->{
            frame.setVisible(false);
            SignUp signUp = new SignUp();
            signUp.register();
        });
        panel.add(create);

        frame.setVisible(true);
    }
}
