package com.company;

import java.io.*;
import java.util.Objects;

import static java.lang.System.out;

class BasicSingleton implements Serializable{

  private BasicSingleton(){}

  private static final BasicSingleton INSTANCE
           = new BasicSingleton();
  private int value = 0;
  public static BasicSingleton getInstance()
  {
      return INSTANCE;
  }
  public void setValue(int val){
      this.value = val;
  }
  public int getValue(){
      return this.value;
  }

  // Tells Jvm to make not a new object when serializable
  protected Object readResolve(){
      return INSTANCE;
  }
}


class Demo{
    static void saveToFile(BasicSingleton singleton,
                           String filename)
            throws Exception
    {
       try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out= new ObjectOutputStream(fileOut)){
          out.writeObject(singleton);
       }
    }
    static BasicSingleton readFromFile(String filename)
            throws Exception
    {
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (BasicSingleton) in.readObject();
        }

    }
   public static void main(String[] args)
           throws Exception
   {
       /*
       BasicSingleton singleton = BasicSingleton.getInstance();
       singleton.setValue(123);
       System.out.println(singleton.getValue());
        */
       // 1. Reflection - can make constructor public
       // 2. serialization - can make a new copy
       BasicSingleton singleton = BasicSingleton.getInstance();
       singleton.setValue(111);
       String filename = "singleton.bin";
       saveToFile(singleton, filename); // serializing singleton

       singleton.setValue(222);

       BasicSingleton singleton2 = readFromFile(filename);

       System.out.println(singleton == singleton2);

       System.out.println(singleton.getValue());
       System.out.println(singleton2.getValue());

   }

}

