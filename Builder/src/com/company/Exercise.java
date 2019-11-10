package com.company;

/* Expected output*
class Person{
    public String name;
    public int age;
}

*/

class CodeBuilder
{
    StringBuilder stringBuilder = new StringBuilder();

    public CodeBuilder(String className)
    {
        stringBuilder.append("public class ").append(className)
                .append("\n{");
    }

    public CodeBuilder addField(String name, String type)
    {
        stringBuilder
                .append("\n\t")
                .append(type)
                .append(" ")
                .append(name)
                .append(";");
        return this;
    }

    @Override
    public String toString()
    {
        return stringBuilder.append("\n}").toString();
    }
}




class ExerciseDemo{
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);

    }
}

