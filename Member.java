import java.io.*;

public class Member implements Serializable
{
    String name;
    String pno;
    String pswd;

    Member(String name,String pno,String pswd)
    {
        this.name=name;
        this.pno=pno;
        this.pswd=pswd;
    }
    public String toString()
    {
        return name+":"+pno+":"+pswd;
    }
}
