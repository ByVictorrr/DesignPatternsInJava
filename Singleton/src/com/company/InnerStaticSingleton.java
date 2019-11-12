package com.company;

public class InnerStaticSingleton {
    private InnerStaticSingleton(){}

    // This avoid synchronization of thread
    private static class Impl
    {
        private static  final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }
    public InnerStaticSingleton getInstance()
    {
        return Impl.INSTANCE;
    }
}

