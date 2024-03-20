package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mysql.cj.protocol.Resultset;

public class calculate_bill extends JFrame implements ActionListener {

    JLabel nameText, addressText;

    Choice meternumCho;

    calculate_bill(){
 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,197,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70, 10, 300, 20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(50, 80, 100, 20);
        panel.add(meternum);

        meternumCho = new Choice();
        try {

            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                meternumCho.add(resultSet.getString("meter_no"));
            }
            
        } catch (Exception E) {
            // TODO: handle exception
            E.printStackTrace();
        }
        meternumCho.setBounds(180, 80, 100, 20);
        panel.add(meternumCho);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 120, 100, 20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180, 120, 150, 20);
        panel.add(nameText);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 160, 100, 20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180, 160, 150, 20);
        panel.add(addressText);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '"+meternumCho.getSelectedItem()+"'");
            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));

            }
        } catch (Exception E) {
            // TODO: handle exception
            E.printStackTrace();
        }

        meternumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no = '"+meternumCho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
        
                    }
                } catch (Exception E) {
                    // TODO: handle exception
                    E.printStackTrace();
                }
                
            }
        });
        setSize(650,400);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new calculate_bill();
    }
    
}
