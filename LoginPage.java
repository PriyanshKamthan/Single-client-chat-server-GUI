import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginPage 
{
    Frame f;
    JPanel p,p1,p2;
    JTextField t1,t2;
    JLabel l,l1,l2;
    JButton b1;
    LoginPage()
    {
        f=new Frame("Login Page");
        l=new JLabel("Welcome to Login Page");
        l.setFont(new Font("Comic Sans MS",0,23));
        p=new JPanel();
        p1=new JPanel();
        
        p.setLayout(null);
        l1=new JLabel("UserName");
        l1.setBounds(30,20,100,20);
        l2=new JLabel("Password");
        l2.setBounds(30,50,100,20);
        t1=new JTextField();
        t1.setBounds(130,20,100,20);
        t2=new JTextField();
        t2.setBounds(130,50,100,20);
        
        b1=new JButton("Login");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Handler h=new Handler();
                    if(h.check(t1.getText(),t2.getText()))
                    {
                        JOptionPane.showMessageDialog(f,"Account exist... login successfull");
                        f.dispose(); 
                        new Client("Priyansh");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(f,"Account does not exists");
                        clear();
                    }
                }
                catch(Exception x){JOptionPane.showMessageDialog(f,x.getMessage());}
            }
        });

        p.add(l1);
        p.add(l2);
        p.add(t1);
        p.add(t2);
        f.add(p);
        p1.add(l);
        f.add(b1,BorderLayout.SOUTH);
        f.add(p1,BorderLayout.NORTH);        
        f.setSize(300,250);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    void clear()
    {
        t1.setText("");
        t2.setText("");
    }
}