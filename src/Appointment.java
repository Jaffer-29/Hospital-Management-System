import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Appointment extends JFrame{
    JTable table;
    DefaultTableModel model;
    JScrollPane sp;

    Appointment() throws IOException {

        File f = new File("Appointment.txt");
        if(!f.exists()){
            JOptionPane.showMessageDialog(null,
                    "File Not Found in System",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));
        model = new DefaultTableModel();

        String line = reader.readLine().trim();
        String[] colTitle = line.split(",");
        model.setColumnIdentifiers(colTitle);

        Object[] appointmentData = reader.lines().toArray();

        for(int i = 0; i<appointmentData.length; i++){

            String lineNew = appointmentData[i].toString().trim();
            String[] store =lineNew.split("\\|");

            Object[] rowData = new Object[store.length];

            for (int j = 0; j < store.length; j++) {
                if (j == 4) {
                    rowData[j] = true;
                } else {
                    rowData[j] = store[j].trim();
                }            }
            model.addRow(rowData);
        }

        table = new JTable(model){

            public Class<?> getColumnClass(int column) {
                return column == 4 ? Boolean.class : String.class;
            }
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.LIGHT_GRAY);
        table.setSelectionBackground(new Color(81, 152, 152));

        sp = new JScrollPane(table);
        sp.setBounds(165,145,500,150);
        add(sp);

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());


        setResizable(true);
        setLocation(300,285);
        setSize(650,250);
        setTitle("Registered Patients");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}