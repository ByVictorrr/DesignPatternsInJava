public class FactoryCodingChallenge {
    public static void main(String[] args) {

    }
}
class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private static int countPeople = 0;
    public Person createPerson(String name)
    {
        return new Person(countPeople++, name);
    }
}
