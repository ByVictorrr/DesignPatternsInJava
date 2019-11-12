package com.company;

class ChiefExecutiveOfficer
{
    // You can make many instances of chiefExecutive officer but it maps to a pair of static vars
    private static String name;
    private static int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    @Override
    public String toString() {
        return "Chief={" + "name=" + name +
                 ", age=" + age + "}";
    }
}

class MonostateDemo{
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("victor");
        ceo.setAge(21);

        // Used for data storage
        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);


    }
}
