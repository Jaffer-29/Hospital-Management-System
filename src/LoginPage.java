import java.awt.*;
import javax.swing.*;

class LoginPage extends JFrame {

    JLabel username, password;
    JTextField text;
    JPasswordField passwordField;
    JButton login,cancel;

    LoginPage(){

        username = new JLabel();
        username.setText("Username  :");
        username.setForeground(Color.BLACK);
        username.setBounds(20,60,150,35);
        username.setFont(new Font("Roboto",Font.BOLD,20));
        add(username);

        text = new JTextField();
        text.setBorder(null);
        text.setForeground(Color.BLACK);
        text.setBounds(150,65,200,30);
        text.setFont(new Font("Arial",Font.BOLD,18));
        add(text);

        password = new JLabel();
        password.setText("Password  :");
        password.setForeground(Color.BLACK);
        password.setBounds(20,110,150,35);
        password.setFont(new Font("Roboto",Font.BOLD,20));
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,110,200,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,18));
        passwordField.setBorder(null);
        add(passwordField);

        JButton eyeBtn = new JButton("👁");
        eyeBtn.setBorder(null);
        eyeBtn.setFocusPainted(false);
        eyeBtn.setContentAreaFilled(false);
        eyeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eyeBtn.setBounds(285,110,160,30);

        char defaultEcho = passwordField.getEchoChar();
        eyeBtn.addActionListener(e -> {
            if (passwordField.getEchoChar() == 0) {
                passwordField.setEchoChar(defaultEcho);
                eyeBtn.setText("👁");
            } else {
                passwordField.setEchoChar((char) 0);
                eyeBtn.setText("Hide");
            }
        });
        add(eyeBtn);

        login = new JButton("Login");
        login.setBorder(null);
        login.setFocusPainted(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Roboto",Font.BOLD,15));
        login.setBounds(155,175,85,25);

        login.addActionListener(ae -> {

            String user = text.getText();
            String pass = new String(passwordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password.",
                        "Input Required",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (user.equalsIgnoreCase("student1") && pass.equals("pass123")
                    ||user.equalsIgnoreCase("student2") && pass.equals("pass123")) {
                new Reception();
                dispose();
            } else{
                JOptionPane.showMessageDialog(null,
                        "Incorrect username or password",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBorder(null);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setFont(new Font("Roboto",Font.BOLD,15));
        cancel.setBounds(270,175,85,25);
        cancel.addActionListener(ae->{
            dispose();
        });
        add(cancel);

       ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
       setIconImage(iconImage.getImage());

       ImageIcon icon2 = new ImageIcon(getClass().getResource("/Login Page Icon.png"));
       JLabel imgLabel = new JLabel(icon2);
       imgLabel.setBounds(500, 15, icon2.getIconWidth(), icon2.getIconHeight());
       add(imgLabel);

        setLayout(null);
        setResizable(false);
        setTitle("Login Page");
        setLocation(450,300);
        setBounds(550,550,750,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(115, 169, 191));
    }
}