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
        //��װage�ļ����߼��������Ǳ�¶��ÿ��������ȥ����
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