package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocCho, meterTypCho, phaseCodeCho, billTypCho;
    JButton submit;
    String meternum;
    meterInfo(String meternum){

        this.meternum = meternum;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252, 186, 3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meternumText = new JLabel(meternum);
        meternumText.setBounds(180,80,150,20);
        panel.add(meternumText);

        JLabel meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50, 120, 100, 20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180, 120, 150, 20);
        panel.add(meterLocCho);

        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        meterTypCho = new Choice();
        meterTypCho.add("Electric Meter");
        meterTypCho.add("Solar Meter");
        meterTypCho.add("Smart Meter");
        meterTypCho.setBounds(180, 160, 150, 20);
        panel.add(meterTypCho);

        JLabel phaseCode = new JLabel("phase Code");
        phaseCode.setBounds(50, 200, 100, 20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.setBounds(180, 200, 150, 20);
        panel.add(phaseCodeCho);

        JLabel billTyp = new JLabel("Bill Type");
        billTyp.setBounds(50, 240, 100, 20);
        panel.add(billTyp);

        billTypCho = new Choice();
        billTypCho.add("Normal");
        billTypCho.add("Industrial");
        billTypCho.setBounds(180, 240, 150, 20);
        panel.add(billTypCho);

        JLabel day = new JLabel("30 Days Billing Time.......");
        day.setBounds(50, 280, 100, 20);
        panel.add(day);

        JLabel note = new JLabel("Note-");
        note.setBounds(50, 320, 100, 20);
        panel.add(note);

        JLabel note1 = new JLabel("By Default the bill is calculated for 30 days Only ..");
        note1.setBounds(50, 340, 220, 20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220, 390, 100, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);


        setSize(700,500);
        setLocation(400, 200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
             String smeterNum = meternum;
             String smeterLoc = meterLocCho.getSelectedItem();
             String smeterTyp = meterTypCho.getSelectedItem();
             String sphaseCode = phaseCodeCho.getSelectedItem();
             String sbillTyp = billTypCho.getSelectedItem();
             String sday = "30";

             String query_meterInfo = "insert into meter_info values('"+smeterNum+"', '"+smeterLoc+"','"+smeterTyp+"','"+sphaseCode+"', '"+sbillTyp+"','"+sday+"')";

             try{

                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter information submitted");
                setVisible(false);
             }catch(Exception E){
 
                E.printStackTrace();
             }
        }
    }

    public static void main(String args[]){
        new meterInfo("");
    }
}
