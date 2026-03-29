import java.awt.*;
import javax.swing.*;

class Department extends JFrame {
    JTable tb;
    JScrollPane sp;
    JButton back;

    Department(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,5,840,540);
        panel.setBackground(new Color(129, 133, 137	 ));
        add(panel);

        JLabel labelName= new JLabel("\"Hospital Department Directory\"");
        labelName.setForeground(Color.BLACK);
        labelName.setBounds(50, 30, 550, 50);
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setFont(new Font("Roboto",Font.BOLD,20));
        panel.add(labelName);

        String[][] data = {
                {"Emergency Department", "Dr. Zohaib Ahmed", "Ground Floor", "24/7"},
                {"Radiology Department","Dr. Saira","Ground Floor", "10:00 AM – 5:00 PM"},
                {"Outpatient Department", "Dr. Ali Raza", "1st Floor", "9:30 AM – 5:30 PM"},
                {"Cardiology Department","Dr. Farhan","1st Floor","10:00 AM – 5:00 PM"},
                {"Pediatrics Department","Dr. Hira","1st Floor","9:00 AM – 4:30 PM"},
                {"Laboratory Department", "Dr. Asfand Yar", "1st Floor", "9:00 AM – 6:00 PM"},
                {"Intensive Care Unit", "Dr. Inaya", "2nd Floor", "On-Call (24/7)"},
                {"Surgery Department", "Dr. Babar Ali", "2nd Floor", "On-Call (Emergency 24/7)"}
        };
        String[] colData = {
                "Department","Head of Department","Location","Operating Hours"
        };

        tb = new JTable(data,colData){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tb.setForeground(Color.BLACK);
        tb.setBackground(Color.LIGHT_GRAY);
        tb.setSelectionForeground(Color.BLACK);
        tb.getTableHeader().setResizingAllowed(false);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tb.setSelectionBackground(new Color(184, 207, 229));
        sp = new JScrollPane(tb);
        sp.setBounds(20, 120, 600, 153);
        panel.add(sp);

        back= new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(260,355,120,30);
        back.setFocusPainted(false);
        back.setBorder(null);
        back.addActionListener(ae->{
            dispose();
        });
        panel.add(back);

       ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
       setIconImage(iconImage.getImage());

        setResizable(true);
        setLocation(300,285);
        setSize(650,450);
        setTitle("Hospital Department Directory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}