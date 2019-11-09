// LSP - Liskov subsituion principle (LSP)
// subclass should be subbed out for base class with no breaks
package com.company;

import org.w3c.dom.css.Rect;

class Rectangle {
    protected int width, height;


    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
    }
    public boolean isSquare(){
        return width == height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "}";
    }
}

class Square extends Rectangle{
    public Square(int size){
        width = height = size;
    }
    @Override
    public void setWidth(int width){
        super.setWidth(width); // violation of LSP
        super.setHeight(width);
    }
    @Override
    public void setHeight(int height){
        super.setWidth(height); // violation of LSP
        super.setHeight(height);
    }
}
// Solve the problem of LSP
class RectangleFactory
{
    public static Rectangle newRectangle(int width, int height){
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side){
        return new Rectangle(side, side);
    }
}

/*
class Demo{
    static void userIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);
        // area  = width *10
        System.out.println(
                "Expected area of " + (width*10)+
                        ", got " + r.getArea()
        );
    }
    public static void main(String[] args){
        Rectangle rc = new Rectangle(2,3);
        userIt(rc);
        Rectangle sq = new Square(5);
        userIt(sq);
    }
}

 */
