package com.company;


class LazySingleton{
    private static LazySingleton instance;

    private LazySingleton()
    {
        System.out.println("init a lazy singleton");
    }

    /*
    // Lets wait until someone actually wants it
    public static synchronized LazySingleton getInstance() // synchronized helps thread safety
    {
        if (instance == null) {
           instance = new LazySingleton();
        }
        return instance;
    }
     */
    // double-checked locking
    public static synchronized LazySingleton getInstance() // synchronized helps thread safety
    {
        if (instance == null) {
            synchronized (LazySingleton.class)
            {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}

