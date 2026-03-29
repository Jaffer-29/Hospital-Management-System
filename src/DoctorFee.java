import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DoctorFee extends JFrame {

    JTable table;
    DefaultTableModel model;
    JScrollPane sp;
    JButton back;

    DoctorFee() {

        JLabel labelName= new JLabel("\"Doctor's Fee Structure\"");
        labelName.setForeground(Color.BLACK);
        labelName.setBounds(12, 20, 650, 50);
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setFont(new Font("Roboto",Font.BOLD,20));
        add(labelName);

        String[][] data = {
                {"Emergency", "General Checkup", "Dr. Zohaib Ahmed", "900 PKR"},
                {"Radiology", "X-Ray / Scan", "Dr. Saira", "700 PKR"},
                {"OPD", "General Checkup", "Dr. Ali Raza", "1000 PKR"},
                {"Cardiology", "Heart Checkup", "Dr. Farhan", "1500 PKR"},
                {"Pediatrics", "Child Checkup", "Dr. Hira", "1000 PKR"},
                {"Laboratory", "Lab Tests", "Dr. Asfand Yar", "800 PKR"},
                {"ICU", "Critical Care Checkup", "Dr. Inaya", "1500 PKR"},
                {"Surgery", "Surgical Consultation", "Dr. Babar Ali", "1500 PKR"}
        };

        String[] colData = {
                "Department", "Service", "Doctor Name", "Fee"
        };

        table = new JTable(data, colData) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };



        table.setFillsViewportHeight(true);
        table.setForeground(Color.BLACK);
        table.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setSelectionBackground(new Color(184, 207, 229));

        sp = new JScrollPane(table);
        sp.setBounds(45, 80, 550, 220);
        add(sp);


        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270, 320, 110, 35);
        back.setFocusPainted(false);
        back.setBorder(null);
        back.addActionListener(ae -> dispose());
        add(back);

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(false);
        setTitle("Fee Structure");
        setLocation(250, 260);
        setSize(650, 420);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}