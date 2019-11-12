package com.company;

import com.google.common.collect.Iterables;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static junit.framework.TestCase2.assertEquals;

interface Database
{
    int getPopulation(String name);
}
class SingletonDatabase implements Database
{
    private Dictionary<String, Integer> capitals
            = new Hashtable<>();
    private static int instanceCount = 0;
    public static int getCount(){return instanceCount;}

    private SingletonDatabase()
    {
        instanceCount++;
        System.out.println("Init database");

        try{
            File file = new File(
                    SingletonDatabase.class.getProtectionDomain()
                            .getCodeSource().getLocation().getPath()
            );
            Path fullPath = Paths.get(file.getPath(), "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);

            Iterables.partition(lines, 2)
                    .forEach(kv -> capitals.put(kv.get(0).trim(),
                            Integer.parseInt(kv.get(1)))
                    );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static final SingletonDatabase INSTANCE = new SingletonDatabase();
    public static SingletonDatabase getInstance(){
        return INSTANCE;
    }
    public int getPopulation(String nameCity)
    {
        return capitals.get(nameCity);
    }
}

class SingletonRecordFinder
{
    public int getTotalPopulation(List<String> names)
    {
        int result = 0;
        for (String name: names)
            result += SingletonDatabase.getInstance().getPopulation(name); // dependcy inversion principle (invasion)
        return result;
    }
}

class ConfigurableRecordFinder{
   private Database database;

   public ConfigurableRecordFinder(Database database)
   {
       this.database = database;
   }
    public int getTotalPopulation(List<String> names)
    {
        int result = 0;
        for (String name: names)
            result += database.getPopulation(name); // dependcy inversion principle
        return result;
    }
}

class DummyDatabase implements Database
{
    private Dictionary<String, Integer> data = new Hashtable<>();

    public DummyDatabase()
    {
        data.put("alpha", 1);
        data.put("gamma", 2);
        data.put("beta", 3);

    }
    @Override
    public int getPopulation(String name) {

        return data.get(name);
    }
}
public class TestingIssues {

    @Test
    public void SingletonTotalPopulationTest()
    {
        SingletonRecordFinder singletonRecordFinder = new SingletonRecordFinder();
        List<String> strings = Arrays.asList("Seoul", "Mexico City");

        int tp = singletonRecordFinder.getTotalPopulation(strings);
        // assert equals assert
        assertEquals(1750000+1740000, tp);

    }
    @Test
    public void dependentPopulationTest()
    {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder configurableRecordFinder = new ConfigurableRecordFinder(db);
        assertEquals(4, configurableRecordFinder.getTotalPopulation(Arrays.asList("alpha", "gamma")));

    }

    public static void main(String[] args) {
    }
}
