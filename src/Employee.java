import java.awt.*;
import javax.swing.*;

public class Employee extends JFrame {
    JButton back = new JButton("Back");
    JRadioButton r1,r2;
    ButtonGroup bg = new ButtonGroup();

    Employee(){
        JLabel label = new JLabel("\"Employee's Status Selection\"");
        label.setBounds(75,5,330,35);
        label.setFont(new Font("Roboto",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        add(label);

        r1 = new JRadioButton("Doctors Information");
        r1.setOpaque(false);
        r1.setFocusPainted(false);
        r1.setBounds(20,70,150,50);
        r1.addActionListener(ae->{
            new Doctor();
        });

        r2 = new JRadioButton("Faculty Information");
        r2.setOpaque(false);
        r2.setFocusPainted(false);
        r2.setBounds(20,125,150,50);
        r2.addActionListener(ae->{
            new Faculty();
        });

        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);

       ImageIcon icon = new ImageIcon(getClass().getResource("/Icon.png"));
       setIconImage(icon.getImage());

       ImageIcon i = new ImageIcon(getClass().getResource("/Employee Icon.png"));
       Image imageI = i.getImage().getScaledInstance(i.getIconWidth(), i.getIconHeight(), Image.SCALE_DEFAULT);
       ImageIcon ii = new ImageIcon(imageI);
       JLabel imageIcon = new JLabel(ii);
       imageIcon.setBounds(400, 15, i.getIconWidth(), i.getIconHeight());
       add(imageIcon);

        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(230, 215, 120, 30);
        back.setFocusPainted(false);
        back.setBorder(null);
        back.addActionListener(ae->{
            dispose();
        });
        add(back);


        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setTitle("Employee's Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(550,550,650,300);
        setLocation(300,285);
        setResizable(false);
        setVisible(true);
    }
}
