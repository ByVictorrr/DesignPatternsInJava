package com.company;


import java.util.HashMap;

enum SubSystem
{

    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer
{
    private Printer(){
        instanceCount++;
        System.out.println(instanceCount + " printers created" );
    }

    private static HashMap<SubSystem, Printer>
        instances = new HashMap<>();

    private static int instanceCount = 0;

    // Give one ss get a singleton
    // Lazy loading
    public static Printer get(SubSystem ss)
    {
        if (instances.containsKey(ss)){
            return instances.get(ss);
        }
        Printer instance = new Printer();
        instances.put(ss, instance);
       return instance;
    }
}

// tries to allow only some instances ( finite set)
public class Multiton {
    public static void main(String[] args) {
        Printer main = Printer.get(SubSystem.PRIMARY);
        Printer aux = Printer.get(SubSystem.AUXILIARY);
        Printer aux2 = Printer.get(SubSystem.AUXILIARY);

    }
}
