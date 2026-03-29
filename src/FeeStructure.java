import java.awt.*;
import javax.swing.*;

public class FeeStructure extends JFrame {
    JButton back = new JButton("Back");
    JRadioButton r1,r2;
    ButtonGroup bg = new ButtonGroup();

    FeeStructure(){
        JLabel label = new JLabel("\"Fee Structure\"");
        label.setBounds(250,10,330,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Roboto",Font.BOLD,20));
        add(label);

        JLabel title = new JLabel();
        title.setText("<html>"
                + "Motive<br>"
                + "\"Purity in Finance\""
                + "</html>");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Roboto",Font.BOLD,15));
        title.setBounds(445, 100, 150, 50);
        add(title);


        r1 = new JRadioButton("Doctors Fee");
        r1.setOpaque(false);
        r1.setFocusPainted(false);
        r1.setBounds(20,70,150,50);
        r1.addActionListener(ae->{
            new DoctorFee();
        });

        r2 = new JRadioButton("Hospital Expense");
        r2.setOpaque(false);
        r2.setFocusPainted(false);
        r2.setBounds(20,125,150,50);
        r2.addActionListener(ae->{
            new RoomFee();
        });
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);

        back.setBorder(null);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(250, 200, 120, 35);
        back.addActionListener(ae->{
            dispose();
        });
        add(back);


        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(false);
        setLocation(200,285);
        setTitle("Accounts Window");
        setSize(650, 300);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
