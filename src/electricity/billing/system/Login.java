package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    JTextField userText,passwordText;  // making them global Variable so that it can be accessed
    Choice logginChoice;  // creating a gloabl choice / dropdown menu
    JButton logginButton,cancelButton,signupButton;  // creating global Buttons
    Login(){

        // add heading in the JFrame use super
        // java rule super should be the first statement.
        super("Login");

        // adding background color
        getContentPane().setBackground(Color.cyan);
        // adding text on the JFrame
        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20); // setting the size of the text label
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300,140,100,20);
        add(loggin);

        logginChoice = new Choice();
        logginChoice.add("Admin");
        logginChoice.add("Customer");
        logginChoice.setBounds(400,140,150,20);
        add(logginChoice);

        logginButton = new JButton("Login");
        logginButton.setBounds(330,180,100,20);
        logginButton.addActionListener(this);
        add(logginButton);

        cancelButton = new JButton("Cancel"); // creating cancel Button , setting size and adding on jframe
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("SignUp");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        //Adding Image Icon in the JFrame
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image imageicon2 = imageicon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fimageicon = new ImageIcon(imageicon2);
        JLabel imageLabel = new JLabel(fimageicon);
        imageLabel.setBounds(5,5,200,200);
        add(imageLabel);
        // we have to customize the frame as per our design so we have
        // to remove the default Layout. Border Layout
        setLayout(null);

        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == logginButton){

            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = logginChoice.getSelectedItem();

            try{
               database c = new database();
               String query = "select * from signup where username ='"+susername+"' and password ='"+spassword+"' and usertype ='"+suser+"'";
               ResultSet resultset = c.statement.executeQuery(query);

               if(resultset.next()){
                setVisible(false);
                new main_class();
               }else{
                JOptionPane.showMessageDialog(null, "Invalid Login");
               }
            }catch(Exception E){
                E.printStackTrace();
            }

        } else if(e.getSource() == cancelButton){
            setVisible(false);
        }
        else if(e.getSource() == signupButton){
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String args[]){
        new Login();
    }
}
