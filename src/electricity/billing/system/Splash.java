package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame {
    Splash(){
        // Importing the image from the folder
        // classloader is used to get something from the local pc, getsystemrouserce is used to get path of image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/Splash.jpg"));
        // scaling the image size so that it can fit in splash sceen
        Image imageOne = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imageIcon2);  // loading image in java
        add(imageLabel);  // adding the image in the box

        setSize(400,400); //setting the size of frame
        setLocation(500,200);
        setVisible(true);  // by default visibility of frame if false

        // time for splash Window

        try{
            // creating timer
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        new Splash();
    }
}
