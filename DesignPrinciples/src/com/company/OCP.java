// OCP - open close princicple
// Specification (design pattern)
// Making a website like amazon and filter object by critea

package com.company;

import java.util.List;
import java.util.stream.Stream;

enum Color{
    RED, GREEN, BLUE
}
enum Size{
    SMALL, MEDIUM,LARGE,YUGE
}
class Product{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size){
        this.name = name;
        this.color = color;
        this.size = size;
    }
}
class ProductFilter{

    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(p->p.color == color);
    }
    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(p->p.size == size);
    }
    public Stream<Product> filterBySizeAndColor(
            List<Product> products,
            Size size,
            Color color
    ){
        return products.stream().filter(p->p.size == size && p.color == color);
    }
}
interface Specification<T>{
    boolean isSatisfied(T item);
}
interface Filter<T>{
    Stream <T> filter(List<T> items, Specification<T> spec);
}
class BetterFilter implements  Filter<Product>{
    @Override
    public Stream <Product> filter(List<Product> items, Specification<Product> spec){
        return items.stream().filter(p->spec.isSatisfied(p));
    }
}
class ColorSpecification implements  Specification<Product>{
    private Color color;
    public ColorSpecification(Color color){
        this.color = color;
    }
    @Override
    public boolean isSatisfied(Product item){
        return item.color == this.color;
    }
}
class SizeSpecification implements  Specification<Product>{
    private Size size;
    public SizeSpecification(Size size){
        this.size = size;
    }
    @Override
    public boolean isSatisfied(Product item){
        return item.size == this.size;
    }
}
// Combinator
class AndSpecification<T> implements Specification<T>{

    private Specification<T> first, second;
    public AndSpecification(Specification<T> first, Specification<T> second){
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

/*
class Demo {

    public static void main(String[] args) throws Exception {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("TREE", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.print("green products(old): ");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p->System.out.println(" - " + p.name + " is green"));


        // Better filter
        BetterFilter bf = new BetterFilter();
        System.out.print("green products(old): ");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p->System.out.println(" - " + p.name + " is green"));

        // Combinator filter
        System.out.println("large blue items");
        bf.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.LARGE)
                )).forEach(p->System.out.println(" - " + p.name + " is blue and large"));

    }
}

 */

