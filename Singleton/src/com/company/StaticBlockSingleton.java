package com.company;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {

    private StaticBlockSingleton() throws IOException
    {
        System.out.println("Singleton is init");
        File.createTempFile(".", ".");
    }
    private static StaticBlockSingleton instance;

    // static block - kinda like a static constructor
    static
    {
        try
        {
           instance = new StaticBlockSingleton();
        }
        catch (Exception e)
        {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
