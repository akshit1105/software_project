package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {  // ActionListner have to be overridden
                                                                // by actionperformed Method

    Choice loginASCho;  // dropdown global value
    TextField meterText, EmployerText, UserName, nameText, passwordText;
    JButton create, back;
    Signup(){
      super("Signup Page");   // for giving title in the JFrame
      getContentPane().setBackground(new Color(168,203,255));

      JLabel createAs = new JLabel("Create Account AS");
      createAs.setBounds(30,50,125,20);
      add(createAs);

      loginASCho = new Choice();
      loginASCho.add("Admin");
      loginASCho.add("Customer");
      loginASCho.setBounds(170,50,120,20);
      add(loginASCho);

      JLabel meterNo = new JLabel("Meter Number");
      meterNo.setBounds(30,100,125,20);
      meterNo.setVisible(false);
      add(meterNo);

      meterText = new TextField();
      meterText.setBounds(170,100,125,20);
      meterText.setVisible(false);
      add(meterText);

      JLabel Employer = new JLabel("Employer ID");
      Employer.setBounds(30,100,125,20);
      Employer.setVisible(true);
      add(Employer);

      EmployerText = new TextField();
      EmployerText.setBounds(170,100,125,20);
      EmployerText.setVisible(true);
      add(EmployerText);

      JLabel Username = new JLabel("UserName");
      Username.setBounds(30,140,125,20);
      add(Username);

      UserName = new TextField();
      UserName.setBounds(170,140,125,20);
      add(UserName);

      JLabel name = new JLabel("Name");
      name.setBounds(30,180,125,20);
      add(name);

      nameText = new TextField();
      nameText.setBounds(170,180,125,20);
      add(nameText);

      JLabel password = new JLabel("Password");
      password.setBounds(30,220,125,20);
      add(password);

      passwordText = new TextField();
      passwordText.setBounds(170,220,125,20);
      add(passwordText);

      // Action for dropdown menu
      loginASCho.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent e) {
              String user = loginASCho.getSelectedItem();    // getting the selected item in dropdown
              if(user.equals("Customer")){
                  Employer.setVisible(false);  // Changing the visibility as per requirement
                  EmployerText.setVisible(false);
                  meterNo.setVisible(true);
                  meterText.setVisible(true);
              }
              else{
                  Employer.setVisible(true);
                  EmployerText.setVisible(true);
                  meterNo.setVisible(false);
                  meterText.setVisible(false);
              }
          }
      });

      create = new JButton("Create");
      create.setBounds(50,280,100,25);
    //  create.setBackground(Color.GREEN); --> it will add the green color to button but if we want customized color then,
        // customizing button color using rgb value
      create.setBackground(new Color(66,127,219));

      // changing the text color
      create.setForeground(Color.black);
      create.addActionListener(this);  // It will tell action listner ki button clicked
      add(create);

      back = new JButton("Back");
      back.setBounds(175,280,100,25);
      back.setBackground(new Color(66,127,219));
      back.setForeground(Color.black);
      back.addActionListener(this); // it will tell action listner ki button clicked
      add(back);

      // adding image in the JFrame
      ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
      Image imageOne = imageicon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
      ImageIcon fimageicon = new ImageIcon(imageOne);
      JLabel imageLabel = new JLabel(fimageicon);
      imageLabel.setBounds(330,40,250,250);
      add(imageLabel);

      setSize(600,380);
      setLocation(500,200);
      setLayout(null);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   // button click hone par action ke liye
      if(e.getSource() == create){

          String  sloginAS = loginASCho.getSelectedItem();
          String susername = UserName.getText();
          String sname = nameText.getText();
          String spassword = passwordText.getText();
          String smeter = meterText.getText();

          try{
              database c = new database();
              String query = null;
              query = "insert into signup value('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+sloginAS+"')";
              c.statement.executeUpdate(query);

              JOptionPane.showMessageDialog(null,"Account Created");
              setVisible(false);
              new Login();

          }catch (Exception E){
              E.printStackTrace();
          }
      } else if (e.getSource() == back){
          setVisible(false);
          new Login();
      }
    }

    public static void main(String args[]){
        new Signup();
    }
}
