import java.awt.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

class AddPatient extends JFrame {

    JComboBox comboBox,roomBox;
    JTextField textNumber,textName,textDisease,textDeposit;
    JRadioButton r1,r2;
    JLabel date;
    JButton b1,b2;
    ButtonGroup bg;

    AddPatient(){

        JPanel panel = new JPanel();
        panel.setBounds(0,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(129, 133, 137	 ));
        add(panel);

        JLabel labelName= new JLabel("\"New Patient Form\"");
        labelName.setForeground(Color.BLACK);
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel pid = new JLabel("Patient ID");
        pid.setBounds(35,76,200,14);
        pid.setFont(new Font("Roboto",Font.BOLD,14));
        pid.setForeground(Color.WHITE);
        panel.add(pid);

        comboBox = new JComboBox<>(new String[] {"Select ID","CNIC","Hospital ID"});
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
        comboBox.setBackground(Color.DARK_GRAY);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBounds(271,73,150,20);
        comboBox.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(comboBox);

        JLabel number = new JLabel("ID Number ");
        number.setForeground(Color.WHITE);
        number.setBounds(35,111,200,14);
        number.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(number);

        textNumber = new JTextField();
        textNumber.setBorder(null);
        textNumber.setBounds(271,111,150,20);
        textNumber.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(textNumber);

        JLabel name = new JLabel("Patient Name");
        name.setForeground(Color.WHITE);
        name.setBounds(35,151,200,14);
        name.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(name);

        textName = new JTextField();
        textName.setBorder(null);
        textName.setBounds(271,151,150,20);
        textName.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(textName);

        JLabel gender = new JLabel("Gender ");
        gender.setForeground(Color.WHITE);
        gender.setBounds(35,191,200,14);
        gender.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(gender);

        r1 = new JRadioButton("Male");
        r1.setOpaque(false);
        r1.setFocusPainted(false);
        r1.setForeground(Color.WHITE);
        r1.setBounds(271,191,80,15);
        r1.setFont(new Font("Roboto",Font.BOLD,14));

        r2 = new JRadioButton("Female");
        r2.setOpaque(false);
        r2.setFocusPainted(false);
        r2.setForeground(Color.WHITE);
        r2.setBounds(350,191,80,15);
        r2.setFont(new Font("Roboto",Font.BOLD,14));

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        panel.add(r1);
        panel.add(r2);

        JLabel disease = new JLabel("Disease");
        disease.setForeground(Color.WHITE);
        disease.setBounds(35,231,200,14);
        disease.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(disease);

        textDisease = new JTextField();
        textDisease.setBorder(null);
        textDisease.setBounds(271,231,150,20);
        textDisease.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(textDisease);

        JLabel labelRoom = new JLabel("Room Number");
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(labelRoom);

        roomBox = new JComboBox<>(new String[] {
                "001 - ER", "002 - Imaging", "003 - Dressing",
                "101 - Lab", "102 - OPD", "103 - Cardiology",
                "104 - Pediatrics", "201 - ICU", "202 - Surgery",
                "OT-205", "OT-206", "OT-207",
                "G-301 - General", "G-302 - Private", "G-303 - Private"
        });
        roomBox.setFocusable(false);
        roomBox.setForeground(Color.WHITE);
        roomBox.setBackground(Color.DARK_GRAY);
        roomBox.setBorder(BorderFactory.createEmptyBorder());
        roomBox.setBounds(271, 274, 155, 20);
        roomBox.setFont(new Font("Roboto",Font.BOLD,14));
        roomBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
        panel.add(roomBox);

        JLabel labelDate = new JLabel("Time ");
        labelDate.setForeground(Color.WHITE);
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(labelDate);

        Date datetime = new Date();

        date =  new JLabel(""+datetime);
        date.setForeground(Color.WHITE);
        date.setBounds(271,316,250,14);
        date.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(date);

        JLabel deposit = new JLabel("Deposit");
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(35,359,200,17);
        deposit.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(deposit);

        textDeposit = new JTextField();
        textDeposit.setBorder(null);
        textDeposit.setBounds(271,359,150,20);
        textDeposit.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(textDeposit);

        b1= new JButton("Add");
        b1.setBorder(null);
        b1.setFocusPainted(false);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(100,430,120,30);
        b1.addActionListener(ae->{

            if (comboBox.getSelectedIndex() == 0 || textNumber.getText().trim().isEmpty() ||
                    textName.getText().trim().isEmpty() || textDisease.getText().trim().isEmpty() ||
                    textDeposit.getText().trim().isEmpty() || (!r1.isSelected() && !r2.isSelected())) {
                JOptionPane.showMessageDialog(
                        this,
                        "All fields are required",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String idType = (String) comboBox.getSelectedItem();
            String idNumber = textNumber.getText();
            String name1 = textName.getText();
            String gender1 = "";
            if (r1.isSelected()){
                gender1 = "Male";
            } else if(r2.isSelected()) {
                gender1 = "Female";
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "All Fields are Required",
                        "Input Form",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            String disease1 = textDisease.getText();
            String room = (String) roomBox.getSelectedItem();
            String deposit1 = textDeposit.getText();
            String time1 = new Date().toString();

            String[] Data = { idType, idNumber, name1, gender1, disease1, room, deposit1, time1 };
            String[] Appoint = {idNumber, name1, disease1, room};

            saveData(Data);
            copyData(Data);
            handelApp(Appoint);

            textNumber.setText("");
            textName.setText("");
            textDisease.setText("");
            textDeposit.setText("");
            bg.clearSelection();
        });
        panel.add(b1);

        b2= new JButton("Back");
        b2.setFocusPainted(false);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(260,430,120,30);
        b2.setBorder(null);
        b2.addActionListener(ae->{
            dispose();
        });
        panel.add(b2);

        ImageIcon hospitalIcon = new ImageIcon(getClass().getResource("/Add Patient.png"));
        Image image = hospitalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(550, 150, 200, 200);
        panel.add(iconLabel);


        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(frameIcon.getImage());

        setResizable(true);
        setLocation(300,285);
        setSize(850,550);
        setTitle("Patient Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void saveData(String[] InputData){

        File patients = new File("Patients.txt");
        try {
            patients.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Patients.txt",true));
            for (int i = 0; i < InputData.length; i++) {
                writer.write(InputData[i]);
                if (i < InputData.length - 1) {
                    writer.write(" | ");
                }
            }
            writer.newLine();
            writer.close();

            JOptionPane.showMessageDialog(null,
                    "Data Saved Successfully",
                    "Saved Data",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Unable to load Data in System",
                    "Error in Saving",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void copyData(String[] InputData){

        File patients = new File("ShowData.txt");

        try {
            patients.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("ShowData.txt",true));
            for (int i = 0; i < InputData.length; i++) {
                writer.write(InputData[i]);
                if (i < InputData.length - 1) {
                    writer.write(" | ");
                }
            }
            writer.newLine();
            writer.close();

            JOptionPane.showMessageDialog(null,
                    "Data Saved Successfully",
                    "Saved Data",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Unable to load Data in System",
                    "Error in Saving",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handelApp(String[] appointment){
        boolean empty = true;
        for (String s : appointment) {
            if (s != null && !s.trim().isEmpty()) {
                empty = false;
                break;
            }
        }
        if (empty) return;

        File appoint = new File("Appointment.txt");

        try {
            appoint.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Appointment.txt",true));
            for (int i = 0; i < appointment.length; i++) {
                writer.write(appointment[i]);
                if (i < appointment.length - 1) {
                    writer.write(" | ");
                }
            }

            writer.write(" | true");
            writer.newLine();
            writer.close();

        }catch (IOException ae){
            ae.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}