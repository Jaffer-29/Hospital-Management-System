import java.awt.*;
import javax.swing.*;

public class Faculty  extends JFrame {
    JButton back;
    JComboBox<String> facBox;
    JLabel fName, fRole, fDepartment, fShift, fWeekDays, fContact, fLocation;

    FacultyInfo[] fac = {
            new FacultyInfo("Select Employee","","","","","",""),
            new FacultyInfo("Shahab Abbas", "Admin Manager","Administration Department", "9:30 am to 6pm","Monday to Saturday", "0321-5566778", "Admin Block"),
            new FacultyInfo("Sara Ali", "Receptionist","Administration Department", "9am to 4pm","Monday to Saturday", "0333-1122334", "Main Reception Desk"),
            new FacultyInfo("Imran", "Office Boy","Administration Department", "9am to 5pm","Monday to Saturday", "0301-2244668", "Admin Office"),
            new FacultyInfo("Ahmad Abdullah", "Office Boy","General Services", "9am to 7:30pm","Monday to Saturday", "0315-6677889", "ICU and OPD"),
            new FacultyInfo("Kamran Ali", "Office Boy","General Services", "9am to 5pm","Monday to Saturday", "0345-2213345", "Surgery Block"),
            new FacultyInfo("Shah Jahan", "Nurse","Assistant Staff", "9am to 5pm (reschedule on call)","Monday to Saturday (Sunday Twice a Month)", "0334-451223", "ER and OPD"),
            new FacultyInfo("Atif Ahmed", "Nurse","Assistant Staff", "9am to 5pm (reschedule on call)","Monday to Saturday (Sunday Twice a Month)", "0342-3451223", "ER and OPD"),
            new FacultyInfo("Nadeem", "Surgical Technician","Assistant Staff", "10am to 4pm","Monday to Saturday", "0334-451223", "ICU and OT"),
            new FacultyInfo("Hamza Nasir", "X-Ray Technician","Radiology Department", "10am to 6pm","Monday to Saturday", "0314-9001122", "Radiology Lab"),
            new FacultyInfo("Muhammad Usman", "Lab Technician","Pathology Department", "9am to 5pm","Monday to Saturday", "0342-7711223", "Pathology Lab"),
            new FacultyInfo("Abbas Khan", "Security Guard","Security Department", "8am to 8pm","Monday to Sunday", "0301-4412233", "Main Gate 1"),
            new FacultyInfo("Sarfraz Khan", "Security Guard","Security Department", "8pm to 8am (Night Shift)","Monday to Sunday", "0302-6644511", "Emergency Gate")
    };

    Faculty(){
        JLabel title = new JLabel("\"Faculty's Info Panel\"");
        title.setBounds(200,18,330,25);
        title.setFont(new Font("Roboto", Font.BOLD, 23));
        title.setForeground(Color.BLACK);
        add(title);

        String[] facInfo =new String[fac.length];
        for(int i = 0; i < fac.length;i++){
            facInfo[i] = fac[i].name;
        }
        facBox = new JComboBox<>(facInfo);
        facBox.setBounds(10, 55, 150, 20);
        facBox.setFocusable(false);
        facBox.addActionListener(ae ->
                updateLabels(facBox.getSelectedIndex()
                ));
        add(facBox);


        addStaticLabel("Employee Name", 35, 95);
        addStaticLabel("Role", 35, 140);
        addStaticLabel("Working Department", 35, 180);
        addStaticLabel("Shift Hours", 35, 215);
        addStaticLabel("Working Days", 35, 255);
        addStaticLabel("Contact Info", 35, 295);
        addStaticLabel("Location", 35, 335);

        fName = createLabel(271, 95);
        fRole = createLabel(271, 140);
        fDepartment = createLabel(271, 180);
        fShift = createLabel(271, 215);
        fWeekDays = createLabel(271, 255);
        fContact = createLabel(271, 295);
        fLocation = createLabel(271, 335);


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
        setTitle("Faculty Information");
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
        FacultyInfo f = fac[index];
        fName.setText(f.name);
        fRole.setText(f.role);
        fDepartment.setText(f.department);
        fShift.setText(f.shiftHours);
        fWeekDays.setText(f.workdays);
        fContact.setText(f.contact);
        fLocation.setText(f.location);
    }
}