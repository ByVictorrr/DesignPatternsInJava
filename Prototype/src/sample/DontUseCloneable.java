package sample;


import java.util.Arrays;

/*
class Address implements Cloneable
{
   public String streetName;
   public int houseNumber;

   public Address(String streetName, int houseNumber)
   {
      this.streetName = streetName;
      this.houseNumber = houseNumber;
   }

   @Override
   public String toString() {
     return "Address{" +
             "streetName=" + streetName + "," +
             " houseNumber="+houseNumber + "}";
   }

   // Deep copy
   @Override
   public Object clone() throws CloneNotSupportedException {
       return new Address(streetName, houseNumber);
   }
}

class Person implements Cloneable
{
   public String [] names;
   public Address address;
   public Person(String[] names, Address address){
      this.address = address;
      this.names = names;
   }

   @Override
   public String toString() {
     return "Person{" +
             "names="+ Arrays.toString(names)+
             ", address="+address+"}";
   }

   @Override
   public Object clone() throws CloneNotSupportedException {

       return new Person(
               names.clone(),
               (Address) address.clone()
       );
   }
}

class Demo{
   public static void main(String [] args )throws Exception{
      Person john = new Person(new String[]{"John", "Smith"},
              new Address("London Road", 123));
      // What if we want to create a neighbor of john
      Person jane = (Person) (john.clone());
      jane.names[0] = "Jane";
      jane.address.houseNumber = 124;
      System.out.println(john);
      System.out.println(jane);


   }
}
*/
