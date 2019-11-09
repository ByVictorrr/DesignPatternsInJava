package com.company;

import org.javatuples.Triplet;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// DIP - dependency inversion principle
// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions. (interface or abstract class)
// B. Abstractions should not depend on details.
// Details should depend on abstractions.

enum Relationship{
    PARENT,
    CHILD,
    SIBLING
}
class Person{
    public String name;
    // dob

    public Person(String name){
        this.name = name;
    }
}
interface  RelationshipBrowser{
    List<Person> findAllChildrenOf(String name);
}


class Relationships implements RelationshipBrowser// Low - level (data storage)
{
   private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
   public void addParentAndChild(Person parent, Person child){
       relations.add(new Triplet<>(parent, Relationship.PARENT, child));
       relations.add(new Triplet<>(child, Relationship.CHILD, parent));
   }
   public List<Triplet<Person, Relationship, Person>> getRelations(){
       return  relations;
   }
   @Override // implementing Relationship Browser makes it dependent on Relationship Crowser
    public List<Person> findAllChildrenOf(String name){
       return relations.stream()
               .filter(x-> Objects.equals(x.getValue0().name, name)
               && x.getValue1() == Relationship.PARENT)
               .map(Triplet::getValue2)
               .collect(Collectors.toList());
   }
}

class Research{ // high - level : because allows us to perform operations on the data

    /*
    public Research(Relationships relationships){ // Was depending on a low level so violates DIP
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x->x.getValue0().name.equals("John")
                        && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println(
                        "John has a child called " + ch.getValue2().name
                ));
    }
     */
    public Research(RelationshipBrowser browser){
        List<Person> children = browser.findAllChildrenOf("John");
        for(Person child: children){
            System.out.println(child.name);
        }
    }
}

class Demo{
    public static void main(String[] args){
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);

    }
}






