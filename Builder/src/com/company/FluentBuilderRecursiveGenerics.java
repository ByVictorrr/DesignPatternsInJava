package com.company;
/*
class Person{
    public String name;

    public String position;

    @Override
    public String toString() {
       return "Person{" +
               "name=" + name
               + ", position=" + position + "}";
    }
}


// A way for personBuilder access Employee
class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
    protected  Person person = new Person();

    public SELF withName(String name){
        person.name = name;
        return self();
    }
    public Person build(){
        return person;
    }
    protected SELF self(){
        return (SELF)this;
    }

}

class EmployeeBuilder extends  PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder worksAt(String position){
        person.position = position;
        return this;
    }
    protected EmployeeBuilder self(){
        return this;
    }

}


// We are going to give acess to employee builder from Person builder

class Demo1{
    public static void main(String[] args){
        EmployeeBuilder eb = new EmployeeBuilder();
        Person victor = eb.withName("victor").worksAt("developer").build();
        System.out.println(victor);

    }
}
*/
