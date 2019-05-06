public class Account
{
    private String name;
    private int age;
    private String programming_language;

    public Account(String name, int age, String programming_language)
    {
        this.name = name;
        this.age = age;
        this.programming_language = programming_language;
    }//END ALTERNATE CONSTRUCTOR

    @Override
    public String toString()
    {
        return String.format("Name: %s\nAge: %d\nFavoourite Programming Language: %s", this.name, this.age, this.programming_language);
    }//END toString
}//END class Account