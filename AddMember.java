import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddMember
{
    Frame f;
    JPanel p;
    JPanel p1;
    JPanel p2;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JLabel l;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JButton b1;
    
    AddMember() {
        f = new Frame("Add member");
        l = new JLabel("Welcome to Sign-up page");
        l.setFont(new Font("Comic Sans MS", 0, 23));
        p = new JPanel();
        p1 = new JPanel();
        p.setLayout(null);
        l1 = new JLabel("Enter UserName");
        l1.setBounds(30, 30, 110, 20);
        l2 = new JLabel("Phone number");
        l2.setBounds(30, 60, 110, 20);
        l3 = new JLabel("Create Password");
        l3.setBounds(30, 90, 110, 20);
        t1 = new JTextField();
        t1.setBounds(140, 30, 110, 20);
        t2 = new JTextField();
        t2.setBounds(140, 60, 110, 20);
        t3 = new JTextField();
        t3.setBounds(140, 90, 110, 20);
        p.add(l1);
        p.add(l2);
        p.add(t1);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        f.add(p);
        p1.add(l);
        b1 = new JButton("Sign-in");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Member m1=new Member(t1.getText(),t2.getText(),t3.getText());
                if(new Handler().save(m1))
                {
                    clear();
                    JOptionPane.showMessageDialog(null,"Account registered");
                    f.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }
            }
        });
        
        f.add(this.b1, "South");
        f.add(this.p1, "North");
        f.setSize(300, 250);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    
    void clear() {
        this.t1.setText("");
        this.t2.setText("");
        this.t3.setText("");
    }
}