import java.io.*;

public class Handler
{
    boolean save(Member m1)
    {
        try
        {
            FileOutputStream fos=new FileOutputStream("account.txt",true);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(m1);
            oos.close();
            fos.close();
            return true;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    boolean check(String name,String pass)
    {
        try
        {
            FileInputStream fis=new FileInputStream("account.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object obj;
            while((obj=ois.readObject())!=null)
            {
                Member m=(Member)obj;
                System.out.println(m);
                if(name.equalsIgnoreCase(m.name) && pass.equals(m.pswd))
                {
                    fis.close();
                    ois.close();
                    return true;
                }
            }
            ois.close();
            fis.close();
            return false;            
        }
        catch(Exception e){return false;}
    }
}
