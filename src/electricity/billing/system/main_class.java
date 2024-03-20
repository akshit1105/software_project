package electricity.billing.system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main_class extends JFrame {
    main_class(){

           setExtendedState(JFrame.MAXIMIZED_BOTH);

           ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
           Image image = imageicon.getImage().getScaledInstance(1530,830, Image.SCALE_DEFAULT);
           ImageIcon imageicon2 = new ImageIcon(image);
           JLabel imageLabel = new JLabel(imageicon2);
           add(imageLabel);


           JMenuBar menubar = new JMenuBar();
           setJMenuBar(menubar);

           JMenu menu = new JMenu("Menu");
           menu.setFont(new Font("serif", Font.PLAIN, 15));
           menubar.add(menu);
           
           JMenuItem newcustomer = new JMenuItem("New Customer");
           newcustomer.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image customerImage = customerImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           newcustomer.setIcon(new ImageIcon(customerImage));
           menu.add(newcustomer);

           JMenuItem customerdetails = new JMenuItem("Customer Detials");
           customerdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon customerdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image customerdetailsImage = customerdetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           customerdetails.setIcon(new ImageIcon(customerdetailsImage));
           menu.add(customerdetails);

           JMenuItem depositdetails = new JMenuItem("Customer Deposits");
           depositdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon customerdepositsImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image customerdepositsImage = customerdepositsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           depositdetails.setIcon(new ImageIcon(customerdepositsImage));
           menu.add(depositdetails);

           JMenuItem calculateBill = new JMenuItem("Calculate Bills");
           calculateBill.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon calculatebillImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image calculatebillImage = calculatebillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           calculateBill.setIcon(new ImageIcon(calculatebillImage));
           menu.add(calculateBill);

           // second menu in menubar
           JMenu info = new JMenu("information");
           info.setFont(new Font("serif", Font.PLAIN, 15));
           menubar.add(info);

           JMenuItem upinfo = new JMenuItem("Update Information");
           upinfo.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon upinfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image upinfoImage = upinfoImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           upinfo.setIcon(new ImageIcon(upinfoImage));
           info.add(upinfo);

           JMenuItem viewinfo = new JMenuItem("View Information");
           viewinfo.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon viewinfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image viewinfoImage = viewinfoImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           viewinfo.setIcon(new ImageIcon(viewinfoImage));
           info.add(viewinfo);

           // if it is a customer then
           JMenu user = new JMenu("User");
           user.setFont(new Font("serif", Font.PLAIN, 15));
           menubar.add(user);

           JMenuItem paybill = new JMenuItem("Pay Bills");
           paybill.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image paybillImage = paybillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           paybill.setIcon(new ImageIcon(paybillImage));
           user.add(paybill);

           JMenuItem billdetails = new JMenuItem("Bill Details");
           billdetails.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image billdetailsImage = billdetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           billdetails.setIcon(new ImageIcon(billdetailsImage));
           user.add(billdetails);

           // new option in menu bar
           JMenu bill = new JMenu("Bill");
           bill.setFont(new Font("serif", Font.PLAIN, 15));
           menubar.add(bill);

           JMenuItem genbill = new JMenuItem("Generate Bills");
           genbill.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon genbillImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image genbillImage = genbillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           genbill.setIcon(new ImageIcon(genbillImage));
           bill.add(genbill);

           // new option in menu bar
           JMenu utility = new JMenu("Utility");
           utility.setFont(new Font("serif", Font.PLAIN, 15));
           menubar.add(utility);

           JMenuItem notepad = new JMenuItem("Notepad");
           notepad.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image notepadImage = notepadImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           notepad.setIcon(new ImageIcon(notepadImage));
           utility.add(notepad);

           JMenuItem calculator = new JMenuItem("Calculator");
           calculator.setFont(new Font("monospaced", Font.PLAIN, 15));
           ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
           Image calculatorImage = calculatorImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
           calculator.setIcon(new ImageIcon(calculatorImage));
           utility.add(calculator);

    
           setLayout(new FlowLayout());
           setVisible(true);
    }
    public static void main(String args[]){
        new main_class();
    }
}
