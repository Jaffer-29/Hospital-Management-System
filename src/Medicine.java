import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Medicine extends JFrame {

    JTable table;
    DefaultTableModel model;
    JScrollPane sp;
    JButton add,update,back;
    JLabel title;
    JLabel disclaimer;

    Medicine() throws IOException {

        title = new JLabel("\"Medicine Inventory\"");
        title.setFont(new Font("Roboto",Font.BOLD,25));
        title.setForeground(Color.BLACK);
        title.setBounds(305,0,350,100);
        add(title);

        disclaimer = new JLabel();
        disclaimer.setText("<html>"
                + "This hospital does not deal with local medicines or narcotics<br>"
                + "Only Authorized person can add Medicine in Inventory"
                + "</html>");
        disclaimer.setForeground(Color.RED);
        disclaimer.setBackground(Color.LIGHT_GRAY);
        disclaimer.setOpaque(true);
        disclaimer.setFont(new Font("Roboto", Font.ITALIC, 12));
        disclaimer.setBounds(220, 72, 400, 51);
        add(disclaimer);


        File f = new File("Med.txt");

        if(!f.exists()){
            JOptionPane.showMessageDialog(null,
                    "Unable to load Data",
                    "Loading Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        BufferedReader reader =new BufferedReader(new FileReader("Med.txt"));
        String line =  reader.readLine().trim();
        String[] colTitle =line.split("\\|");
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colTitle);

        Object[] fileData = reader.lines().toArray();

        for(int i = 0; i<fileData.length; i++){
            String lineNew = fileData[i].toString().trim();
            String[] store =lineNew.split(",");

            Object[] rowData = new Object[store.length];
            rowData[0] = store[0];
            rowData[1] = store[1];
            rowData[2] = Boolean.parseBoolean(store[2]);
            rowData[3] = Boolean.parseBoolean(store[3]);
            model.addRow(rowData);
        }

        table = new JTable(model){

            public Class<?> getColumnClass(int col){
                if(col == 2 || col ==3){
                    return Boolean.class;
                }
                return Object.class;
            }
            public boolean isCellEditable(int row,int col){
                return col == 2 || col ==3;
            }
        };

        table.getModel().addTableModelListener(ae->{
            int row  = ae.getFirstRow();
            int col =  ae.getColumn();

            if(row < 0 || col < 0){
                return;
            }
            if(col==2){
                Boolean available =(Boolean) model.getValueAt(row,col);
                if(available) model.setValueAt(false,row,3);

            } else if (col==3) {
                Boolean outOFStock = (Boolean) model.getValueAt(row,col);
                if(outOFStock)model.setValueAt(false,row,2);
            }
        });

        table.setForeground(Color.BLACK);
        table.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setSelectionBackground(new Color(81, 152, 152));

        sp = new JScrollPane(table);
        sp.setBounds(165,145,500,150);
        add(sp);

        add= new JButton("Add New Medicine");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setFocusPainted(false);
        add.setBorder(null);
        add.setBounds(185,400,145,37);
        add.addActionListener(ae->{
            new newMedicine(model);
        });
        add(add);

        update= new JButton("Update Status");
        update.setBorder(null);
        update.setFocusPainted(false);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(350,400,145,37);
        update.addActionListener(ae->{
            updateFile();
        });
        add(update);

        back= new JButton("Back");
        back.setBorder(null);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(515,400,145,37);
        back.addActionListener(ae->{
            dispose();
        });
        add(back);

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(true);
        setLocation(175,250);
        setSize(850,550);
        setTitle("Medicine Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(129, 133, 137));
        setVisible(true);

    }

    private void updateFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Med.txt"))) {
            writer.write("Name | Price | Available | Out Of Stock");
            writer.newLine();
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(
                        model.getValueAt(i, 0) + "," +
                                model.getValueAt(i, 1) + "," + model.getValueAt(i, 2) + "," + model.getValueAt(i, 3));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null,
                    "Data Updated Successfully",
                    "Data Saved",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to update file",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}