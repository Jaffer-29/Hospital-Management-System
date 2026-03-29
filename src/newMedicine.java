import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class newMedicine extends JFrame {

    DefaultTableModel model;
    JCheckBox c1;
    JTextField textName,txtPrice;
    JLabel name,price;
    String newName,newPrice;
    Boolean Status;
    JButton save;

    newMedicine(DefaultTableModel model){
        this.model = model;
        name = new JLabel();
        name.setText("Medicine Name  :");
        name.setForeground(Color.BLACK);
        name.setBounds(20,25,200,30);
        name.setFont(new Font("Roboto",Font.BOLD,18));
        add(name);

        textName = new JTextField();
        textName.setBorder(null);
        textName.setBounds(210,25,170,30);
        textName.setForeground(Color.GRAY);
        textName.setFont(new Font("Arial",Font.BOLD,18));
        add(textName);

        price = new JLabel();
        price.setText("Medicine Price  :");
        price.setForeground(Color.BLACK);
        price.setBounds(20,70,200,30);
        price.setFont(new Font("Roboto",Font.BOLD,18));
        add(price);

        txtPrice = new JTextField();
        txtPrice.setBorder(null);
        txtPrice.setBounds(210,70,170,30);
        txtPrice.setForeground(Color.GRAY);
        txtPrice.setFont(new Font("Arial",Font.BOLD,18));
        add(txtPrice);

        c1 = new JCheckBox("Is Available");
        c1.setBounds(75,112,150,30);
        c1.setBorder(null);
        c1.setFocusPainted(false);
        c1.setBackground(null);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Arial",Font.BOLD,17));
        add(c1);


        save = new JButton("Add Medicine");
        save.setBounds(170, 170, 150, 35);
        save.setFocusPainted(false);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(ae -> {
            if (textName.getText().isEmpty() || txtPrice.getText().isEmpty() || !c1.isSelected()) {
                JOptionPane.showMessageDialog(this,
                        "All Fields are Required to Process",
                        "Error to Add Medicine ",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean available = true;
            boolean outOfStock = !available;

            model.addRow(new Object[]{
                    textName.getText(),
                    txtPrice.getText(),
                    available,
                    outOfStock
            });
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("Med.txt",true));
                writer.write(textName.getText()+","+txtPrice.getText()+","+c1.isSelected()+","+!c1.isSelected());
                writer.newLine();
                writer.close();

                JOptionPane.showMessageDialog(null,
                        "Data Saved Successfully",
                        "Save Data",
                        JOptionPane.INFORMATION_MESSAGE);

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,
                        "Unable to load Data",
                        "Loading Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        });
        add(save);

        newName = textName.getText();
        newPrice = txtPrice.getText();
        Status = c1.isSelected();

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(false);
        setTitle("Add New Medicine");
        setLocation(420,300);
        setBounds(550,550,550,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(80, 94, 101));
        setVisible(true);
    }
}