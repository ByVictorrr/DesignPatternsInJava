package com.company;


import java.io.StreamCorruptedException;

enum CoordinateSystem{
    CARTESIAN,
    POLAR
}


class Point
{
    private double x,y;

    // Made private so forces you to use static methodsG
    private Point(double x, double y){
        this.x= x;
        this.y= y;
    }
    /*
    public Point(double rho, double theta){
        this.x= rho*Math.cos(theta);
        this.x= rho*Math.cos(theta);
    }
     */

    /*
   private Point(double a, double b, CoordinateSystem cs){
        switch (cs){
            case POLAR:
                this.x= a*Math.cos(b);
                this.y= a*Math.cos(b);
                break;
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
        }
    }
     */

    public static class PointFactory
    {
        public static Point newCartesianPoint(double x, double y)
        {
            return new Point(x,y);
        }
        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }

    }
}



class Demo
{
    public static void main(String[] args) {
        Point point = Point.PointFactory.newCartesianPoint(1,3);

    }
}

