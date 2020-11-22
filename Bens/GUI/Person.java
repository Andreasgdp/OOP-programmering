import java.io.*;
class Person implements Serializable
{
    private String  name;
    private int     age;

    
    public Person()
    {
        name        = "";
        age         = 0;
    }
    
    public Person(String aName, int anAge)
    {
        name        = aName;
        age         = anAge;
    }
    
    public int getAge()
    {
        return age;
    }

    

    public String getName()
    {
        return name;
    }
    
    public void setAge(int anAge)
    {
        age = anAge;
    }


    public void setName(String aName)
    {
        name = aName;
    }

    
}
