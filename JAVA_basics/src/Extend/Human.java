package Extend;

public class Human
{
    private int age;
    private String name;

    public int getAge()
    {
        return age;
    }

    public void setAge( int age ) throws Exception
    {
        //封装age的检验逻辑，而不是暴露给每个调用者去处理
        if( age > 120 )
        {
            throw new Exception( "Invalid value of age" );
        }
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}