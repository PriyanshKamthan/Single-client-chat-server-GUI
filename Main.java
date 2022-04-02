import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main
{
    Frame f;
    JPanel p,p1,p2;
    JButton b1,b2,b3;
    JLabel l;
    Main()
    {
        f=new Frame("Main");
        l=new JLabel("Welcome to messenger");
        l.setFont(new Font("Comic Sans MS",0,23));
        p=new JPanel();
        p1=new JPanel();
        p2=new JPanel();
        p2.setLayout(new GridLayout(2,1));
        p1.add(l);
        b1=new JButton("Login to Existing");
        b2=new JButton("Create new Account");
        b3=new JButton("Exit");
        b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){new LoginPage();f.dispose();}});
        b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){new AddMember();}});
        b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){f.dispose();}});
        p2.add(b1);
        p2.add(b2);
        p.add(p2);
        f.add(p1,BorderLayout.NORTH);  
        f.add(b3,BorderLayout.SOUTH);        
        f.add(p);
        f.setSize(300,200);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    public static void main(String ar[]) throws Exception
    {
        new Main();
    }
}