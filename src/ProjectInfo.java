import java.awt.*;
import javax.swing.*;

public class  ProjectInfo extends JFrame{
    JLabel desc;

    ProjectInfo(){
        JLabel title = new JLabel("Hospital Management System", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 28));
        title.setForeground(new Color(129, 174, 237));
        title.setBounds(0, 20, 800, 40);
        add(title);
        desc = new JLabel("<html><center>This Project is Purely Made in Java. <br>" +
                "We use simple to complex components for development.<br>" +
                "The code is the result of hard work and also uses ChatGPT as an AI tool.<br>"+
                "The code is hardcore and allows data entry only for medicines and patients.<br>" +
                "Data for doctors or faculty cannot be added." +
                "</center></html>", SwingConstants.CENTER);
        desc.setFont(new Font("Arial", Font.BOLD, 15));
        desc.setBounds(0, 100, 800, 50);
        add(desc);

        JLabel thankYou = new JLabel(
                "<html><center>Thank You..!<br><br>" +
                        "Supervised by: Dr. Waqas Jadoon</center></html>",
                SwingConstants.CENTER);
        thankYou.setFont(new Font("Roboto", Font.BOLD, 16));
        thankYou.setForeground(new Color(70, 153, 232));
        thankYou.setBounds(0, 175, 800, 75);
        add(thankYou);

        JLabel footer1 = new JLabel("Developed by: Muhammad Jaffer and Hammad Khan", SwingConstants.CENTER);
        footer1.setFont(new Font("Arial", Font.ITALIC, 14));
        footer1.setBounds(0, 400, 800, 30);
        footer1.setForeground(Color.DARK_GRAY);
        add(footer1);

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(true);
        setLocation(250,250);
        setSize(800, 500);
        setTitle("Project Profile");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
