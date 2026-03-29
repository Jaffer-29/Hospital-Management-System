import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShowPatient extends JFrame {

    DefaultTableModel model;
    JTable table;
    JScrollPane sp;

    ShowPatient() throws IOException {

        File f = new File("ShowData.txt");
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null,
                    "File Not Found in System",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine().trim();
        String[] colTitle = line.split(",");

        String[] newColTitle = new String[colTitle.length + 1];
        System.arraycopy(colTitle, 0, newColTitle, 0, colTitle.length);
        newColTitle[colTitle.length] = "Delete";

        model = new DefaultTableModel();
        model.setColumnIdentifiers(newColTitle);

        Object[] fileData = reader.lines().toArray();
        reader.close();

        for (Object obj : fileData) {
            String lineNew = obj.toString().trim();
            String[] store = lineNew.split("\\|");
            Object[] rowData = new Object[store.length + 1];

            for (int j = 0; j < store.length; j++) {
                rowData[j] = store[j];
            }
            rowData[store.length] = "Delete";
            model.addRow(rowData);
        }

        table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return column == model.getColumnCount() - 1;
            }
        };

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (col == model.getColumnCount() - 1) {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Do you want to delete this patient info?", "Confirm Delete",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            deletePatient(row);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionBackground(new Color(184, 207, 229));

        sp = new JScrollPane(table);
        sp.setBounds(165, 145, 500, 150);
        add(sp);


       ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setResizable(true);
        setLocation(180, 285);
        setSize(850, 350);
        setTitle("Saved Patient Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void deletePatient(int row) throws IOException {

        model.removeRow(row);
        File inputFile = new File("ShowData.txt");
        File tempFile = new File("ShowData_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        int lineNum = 0;
        while ((currentLine = reader.readLine()) != null) {
            if (lineNum != row + 1) {
                writer.write(currentLine);
                writer.newLine();
            }
            lineNum++;
        }
        writer.close();
        reader.close();

        if (!inputFile.delete()) {
            JOptionPane.showMessageDialog(null,
                    "Could not delete original file",
                    "Delete File Error",
                    JOptionPane.ERROR_MESSAGE);

        }
        tempFile.renameTo(inputFile);
    }
}