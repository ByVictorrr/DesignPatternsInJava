package com.company;

// ISP - interface segregation principle
// Seperating interfaces into smaller interfaces

import javax.print.Doc;

class Document{

}

interface Machine{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine{
    @Override
    public void print(Document d) {

    }
    @Override
    public void fax(Document d) {
    }
    @Override
    public void scan(Document d) {
    }
}
class OldFashionedPrinter implements  Machine{
    @Override
    public void print(Document d) {
    }
    @Override
    public void fax(Document d) {
    }
    @Override
    public void scan(Document d) {
    }
}
interface Printer{
    void print(Document d);
}
interface Scanner{
    void scan(Document d);
}
// YAGNI = you aint going to need it

class JustAPrinter implements Printer{
    @Override
    public void print(Document d){

    }
}
class Photocopier implements Printer, Scanner{

    @Override
    public void print(Document d){

    }
    @Override
    public void scan(Document d){

    }
}

interface MultiFunctionalDevice extends Printer, Scanner{}


class MultiFunctionMachine implements MultiFunctionalDevice{

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner){
        this.printer = printer;
        this.scanner = scanner;
    }


    @Override
    public void print(Document d){
        // Delegation or decarator design pattern
        printer.print(d);
    }

    @Override
    public void scan(Document d){
        scanner.scan(d);
    }
}

