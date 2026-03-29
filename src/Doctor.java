import java.awt.*;
import javax.swing.*;

public class Doctor extends JFrame {
    JButton back;
    JComboBox<String> docBox;
    JLabel nameLabel, deptLabel, desigLabel, scheduleLabel, daysLabel, contactLabel, roomLabel;

    DoctorInfo[] doc = {
            new DoctorInfo("Select Employee","","","","","",""),
            new DoctorInfo("Dr. Zohaib Ahmed","Emergency Department","Head Supervisor (CEO)","9am to 6pm","Monday to Saturday","0319-9625846","Room # 001 G-Floor"),
            new DoctorInfo("Dr. Inaya","Intensive Care Unit","Senior Consultant","1am to 6pm","Monday to Saturday (On Call Emergency)","0312-1232132 ","Room # 201 2-Floor"),
            new DoctorInfo("Dr. Ali Raza","Outpatient Department","Consultant","9am to 4pm","Monday to Friday","0312-1243523","Room # 102 1-Floor"),
            new DoctorInfo("Dr. Babar Ali","Surgery Department","Senior Consultant","12am to 5pm","Monday, Wednesday and Thursday","0312-1236456","Room # 202 2-Floor"),
            new DoctorInfo("Dr. Asfand Yar","Laboratory Department","Lab In-Charge","11am to 4pm","Monday to Friday","0332-1236456","Room # 101 1-Floor"),
            new DoctorInfo("Dr. Farhan","Cardiology Department","Cardiologist (Head of Depart.)","11am to 3pm","Monday adn Friday","0312-1233412","Room # 103 1-Floor"),
            new DoctorInfo("Dr. Saira","Radiology Department","Senior Radiologist","10am to 7pm","Monday to Saturday","0312-123542","Room # 002 G-Floor"),
            new DoctorInfo("Dr. Hira","Pediatrics Department","Pediatrician","10am to 5pm","Monday to Friday","0312-1231233","Room # 104 1-Floor"),
            new DoctorInfo("Dr. Gul-e-lala (Assistant)","Emergency Department","Assist Doctors","11am to 5pm","Monday to Friday","0312-8785564","Not Assigned")
    };

    Doctor(){

        JLabel title = new JLabel("\"Doctor's Info Panel\"");
        title.setBounds(200,18,330,25);
        title.setFont(new Font("Roboto", Font.BOLD, 23));
        title.setForeground(Color.BLACK);
        add(title);

        String[] docInfo =new String[doc.length];
        for(int i = 0; i < doc.length;i++){
            docInfo[i] = doc[i].name;
        }
        docBox = new JComboBox<>(docInfo);
        docBox.setBounds(10, 55, 150, 20);
        docBox.setFocusable(false);
        docBox.addActionListener(ae ->
                updateLabels(docBox.getSelectedIndex()
                ));
        add(docBox);

        addStaticLabel("Doctor's Name", 35, 95);
        addStaticLabel("Department", 35, 140);
        addStaticLabel("Designation", 35, 180);
        addStaticLabel("Schedule", 35, 215);
        addStaticLabel("Days", 35, 255);
        addStaticLabel("Contact Info", 35, 295);
        addStaticLabel("Room Number", 35, 335);

        nameLabel = createLabel(271, 95);
        deptLabel = createLabel(271, 140);
        desigLabel = createLabel(271, 180);
        scheduleLabel = createLabel(271, 215);
        daysLabel = createLabel(271, 255);
        contactLabel = createLabel(271, 295);
        roomLabel = createLabel(271, 335);

        back= new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(260,430,120,30);
        back.setFocusPainted(false);
        back.setBorder(null);
        back.addActionListener(ae->{
            dispose();
        });
        add(back);

        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());

        setLayout(null);
        setResizable(false);
        setLocation(300,285);
        setSize(650,550);
        setTitle("Doctors Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(129, 133, 137	 ));
        setVisible(true);
    }

    public void addStaticLabel(String text,int x,int y){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 30);
        label.setFont(new Font("Roboto", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        add(label);
    }

    public JLabel createLabel(int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 300, 30);
        label.setFont(new Font("Roboto", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        add(label);
        return label;
    }


    public void updateLabels(int index) {
        DoctorInfo d = doc[index];
        nameLabel.setText(d.name);
        deptLabel.setText(d.department);
        desigLabel.setText(d.designation);
        scheduleLabel.setText(d.schedule);
        daysLabel.setText(d.workdays);
        contactLabel.setText(d.contact);
        roomLabel.setText(d.room);
    }
}