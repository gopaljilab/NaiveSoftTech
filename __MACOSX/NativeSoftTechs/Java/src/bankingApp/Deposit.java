package bankingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2;

    Deposit(String pin) {
        this.pin = pin;

        // Load and set background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankingApp/Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        setContentPane(l3);  // Set as background
        l3.setLayout(null);   // Allow absolute positioning

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 180, 400, 35);
        l3.add(label1);

        // Use JTextField instead of AWT's TextField
        textField = new JTextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(430, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        textField.setOpaque(true);  // Ensure it displays correctly
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(650, 358, 150, 35);
        styleButton(b1);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(650, 402, 150, 35);
        styleButton(b2);
        l3.add(b2);

        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(65, 125, 128));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource() == b1) {
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                } else {
                    Con c = new Con();
                    c.statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    new Main_Class(pin);
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
