import java.awt.*;
import javax.swing.*;

public class RoomFee extends JFrame {

    JTable table;
    JScrollPane sp;
    JButton back;


    RoomFee() {
        JLabel labelName= new JLabel("\"Room's Fee Structure\"");
        labelName.setForeground(Color.BLACK);
        labelName.setBounds(12, 20, 650, 50);
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setFont(new Font("Roboto",Font.BOLD,20));
        add(labelName);

        String[][] data = {
                {"Room #001", "Emergency Room", "Ground Floor", "1500 PKR"},
                {"Room #102", "Outpatient Department", "First Floor", "1500 PKR"},
                {"Room #103", "Cardiology Department", "First Floor", "2000 PKR"},
                {"Room #104", "Pediatrics Room", "First Floor", "2000 PKR"},
                {"Room #201", "ICU", "Second Floor", "9000 PKR"},
                {"Room #202", "Surgery Department", "Second Floor", "10000 PKR"},
                {"OT-205", "Operation Theater", "Second Floor", "Depend Upon Case"},
                {"OT-206", "Operation Theater", "Second Floor", "Depend Upon Case"},
                {"OT-207", "Operation Theater", "Second Floor", "Depend Upon Case"},
                {"G-301", "General Ward", "Third Floor", "2000 PKR"},
                {"G-302", "Private Room", "Third Floor", "3000 PKR"},
                {"G-303", "Private Room", "Third Floor", "3000 PKR"}
        };
        String[] columns = {
                "Room No", "Room Type", "Floor", "Fee / Day"
        };

        table = new JTable(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setForeground(Color.BLACK);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setSelectionBackground(new Color(184, 207, 229));

        sp = new JScrollPane(table);
        sp.setBounds(45, 80, 550, 220);
        add(sp);

        back = new JButton("Back");
        back.setBorder(null);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270, 320, 110, 35);
        back.addActionListener(ae ->
                dispose()
        );
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