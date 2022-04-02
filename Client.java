import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client implements ActionListener
{
    Frame f;
    JTextField t;
    JPanel p,p1;
    JList<String> lis;
    DefaultListModel<String> demoList;
    JButton b;
    JLabel l;
    Socket s;
    Client(String name)
    {
        f=new Frame(name+"'s messenger");
        l=new JLabel("Welcome to messenger "+name);
        l.setFont(new Font("Comic Sans MS",0,23));
        p=new JPanel();
        
        p1=new JPanel();
        p1.setLayout(new BorderLayout());
        b=new JButton("Send");
        t=new JTextField();
        t.setFont(new Font("Comis Sans MS",0,15));

        demoList= new DefaultListModel<String>();
        lis = new JList<String>(demoList);
        lis.setFont(new Font("Comic Sans MS",0,15));

        b.addActionListener(this);

        p.add(l);
        p1.add(t);
        p1.add(b,BorderLayout.EAST);
        f.add(p,BorderLayout.NORTH);
        f.add(p1,BorderLayout.SOUTH); 
        f.add(lis);
        f.setSize(600,500);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}}); 
        try
        {
            s=new Socket("localhost",4001);
            while(true)
            {
                ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                String str=(String)ois.readObject();
                demoList.addElement("Friend: "+str);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(f,e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(t.getText());
            demoList.addElement("Me: "+t.getText());
            t.setText("");
        }
        catch(Exception x){JOptionPane.showMessageDialog(f,x.getMessage());}
    }
    public static void main(String ar[])
    {
        new Client("Bajirao");
    }
}