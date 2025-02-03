package bankingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Main_Class(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankingApp/Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        setContentPane(l3);  // Set background image properly
        l3.setLayout(null);  // Important to allow manual positioning

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(380, 180, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(370, 265, 170, 35);
        styleButton(b1);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(635, 265, 170, 35);
        styleButton(b2);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(370, 310, 170, 35);
        styleButton(b3);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(635, 310, 170, 35);
        styleButton(b4);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(370, 355, 170, 35);
        styleButton(b5);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(635, 355, 170, 35);
        styleButton(b6);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(635, 400, 170, 35);
        styleButton(b7);
        l3.add(b7);

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(65, 125, 128));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b7) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawal(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);
        }else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Main_Class("");
    }
}
