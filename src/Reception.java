import java.awt.*;
import java.io.IOException;
import javax.swing.*;

class Reception extends JFrame {

    Reception(){

        JPanel p1  = new JPanel();
        p1.setLayout(null);
        p1.setBounds(5,0,1668,200);
        p1.setBackground(new Color(188, 196, 225));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(5,205,1600,768);
        p2.setBackground(new Color(173, 173, 173));
        add(p2);

        JLabel label = new JLabel("\"Health is Our First Priority\"");
        label.setForeground(Color.BLACK);
        label.setBounds(1050,150,500,300);
        label.setFont(new Font("Roboto",Font.BOLD,30));
        p2.add(label);

        ImageIcon i = new ImageIcon(getClass().getResource("/Reception Icon.png"));
        Image imageI = i.getImage().getScaledInstance(i.getIconWidth(), i.getIconHeight(), Image.SCALE_SMOOTH);
        ImageIcon ii = new ImageIcon(imageI);
        JLabel imageIcon = new JLabel(ii);
        imageIcon.setBounds(1300,15,i.getIconWidth(),i.getIconHeight());
        p1.add(imageIcon);

        JButton bt1 = new JButton("Add New Patient");
        bt1.setBorder(null);
        bt1.setFocusPainted(false);
        bt1.setBackground(Color.WHITE);
        bt1.setBounds(30,35,165,30);
        bt1.setFont(new Font("Roboto",Font.BOLD,14));
        bt1.addActionListener(ae->{
            new AddPatient();
        });
        p1.add(bt1);

        JButton bt2 = new JButton("Patients Info");
        bt2.setBorder(null);
        bt2.setFocusPainted(false);
        bt2.setBackground(Color.WHITE);
        bt2.setBounds(30,85,165,30);
        bt2.setFont(new Font("Roboto",Font.BOLD,14));
        bt2.addActionListener(ae->{
            try {
                new ShowPatient();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        p1.add(bt2);



        JButton bt4 = new JButton("Rooms Status");
        bt4.setBorder(null);
        bt4.setFocusPainted(false);
        bt4.setBackground(Color.WHITE);
        bt4.setBounds(250,35,165,30);
        bt4.setFont(new Font("Roboto",Font.BOLD,14));
        bt4.addActionListener(ae->{
            new RoomStatus();
        });
        p1.add(bt4);

        JButton bt5 = new JButton("Fee Structures");
        bt5.setBorder(null);
        bt5.setFocusPainted(false);
        bt5.setBackground(Color.WHITE);
        bt5.setBounds(250,85,165,30);
        bt5.setFont(new Font("Roboto",Font.BOLD,14));
        bt5.addActionListener(ae->{
            new FeeStructure();
        });
        p1.add(bt5);

        JButton bt6 = new JButton("Departments");
        bt6.setBorder(null);
        bt6.setFocusPainted(false);
        bt6.setBackground(Color.WHITE);
        bt6.setBounds(250,135,165,30);
        bt6.setFont(new Font("Roboto",Font.BOLD,14));
        bt6.addActionListener(ae->{
            new Department();
        });
        p1.add(bt6);

        JButton bt7 = new JButton("Employee's Info");
        bt7.setBorder(null);
        bt7.setFocusPainted(false);
        bt7.setBackground(Color.WHITE);
        bt7.setBounds(470,35,165,30);
        bt7.setFont(new Font("Roboto",Font.BOLD,14));
        bt7.addActionListener(ae->{
            new Employee();
        });
        p1.add(bt7);

        JButton bt8 = new JButton("Medicine");
        bt8.setBorder(null);
        bt8.setFocusPainted(false);
        bt8.setBackground(Color.WHITE);
        bt8.setBounds(470,85,165,30);
        bt8.setFont(new Font("Roboto",Font.BOLD,14));
        bt8.addActionListener(ae->{
            try {
                new Medicine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        p1.add(bt8);

        JButton bt9 = new JButton("Handel Appointments");
        bt9.setBorder(null);
        bt9.setFocusPainted(false);
        bt9.setBackground(Color.WHITE);
        bt9.setBounds(470,135,165,30);
        bt9.setFont(new Font("Roboto",Font.BOLD,14));
        bt9.addActionListener(ae->{
            try {
                new Appointment();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        p1.add(bt9);

        JButton bt10 = new JButton("Logout");
        bt10.setBorder(null);
        bt10.setFocusPainted(false);
        bt10.setBackground(Color.WHITE);
        bt10.setBounds(690,35,165,30);
        bt10.setFont(new Font("Roboto",Font.BOLD,14));
        bt10.addActionListener(ae->{
            int choice = JOptionPane.showConfirmDialog(null,"Do You want to Logout System","Logout Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
            if(choice == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });
        p1.add(bt10);

        JButton bt11 = new JButton("Project Info");
        bt11.setBorder(null);
        bt11.setFocusPainted(false);
        bt11.setForeground(Color.WHITE);
        bt11.setBounds(690, 85, 165, 30);
        bt11.setBackground(new Color(129, 174, 237));
        bt11.setFont(new Font("Roboto", Font.BOLD, 14));
        bt11.addActionListener(ae -> {
            new ProjectInfo();
        });
        p1.add(bt11);


        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(true);
        setTitle("Reception Page");
        setLocation(20, 0);
        setSize(1600,800);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}