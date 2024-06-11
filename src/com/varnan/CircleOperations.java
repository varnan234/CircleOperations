package com.varnan;

/**
 * @author Varnan Goenka
 * date 04/04/2024 
 * Processing for circle operations.
 */

public class CircleOperations {
    private int x;
    private int y;
    private int radius;

    /**
     * Default constructor. Initializes circle at origin (0,0) with radius 1.
     */
    public CircleOperations() {
        this(0, 0, 1);
    }

    /**
     * Constructor that sets only the radius.
     * @param radius The radius of the circle.
     */
    public CircleOperations(int radius) {
        this();
        this.radius = radius;
    }

    /**
     * Constructor that sets all variables (x, y, radius).
     * @param x The x-coordinate of the circle's origin.
     * @param y The y-coordinate of the circle's origin.
     * @param radius The radius of the circle.
     */
    public CircleOperations(int x, int y, int radius) {
        this.x = validateCoordinate(x);
        this.y = validateCoordinate(y);
        this.radius = validateRadius(radius);
    }

    /**
     * Calculate and return the area of the circle.
     * @return The area of the circle.
     */
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Calculate and return the circumference of the circle.
     * @return The circumference of the circle.
     */
    public double perimeter() {
        return diameter() * Math.PI;
    }

    /**
     * Update the origin of the circle to the new coordinates.
     * @param x The new x-coordinate of the circle's origin.
     * @param y The new y-coordinate of the circle's origin.
     */
    public void move(int x, int y) {
        this.x = validateCoordinate(x);
        this.y = validateCoordinate(y);
    }

    /**
     * Update the size of the circle's radius.
     * @param radius The new radius of the circle.
     */
    public void resize(int radius) {
        this.radius = validateRadius(radius);
    }

    /**
     * Calculate and return the diameter of the circle.
     * @return The diameter of the circle.
     */
    private int diameter() {
        return 2 * this.radius;
    }

    /**
     * Validate the radius value.
     * @param radius The radius to validate.
     * @return The validated radius.
     */
    private int validateRadius(int radius) {
        if (radius < 0) {
            return 1;
        } else if (radius > 100) {
            return 100;
        } else {
            return radius;
        }
    }

    /**
     * Validate the coordinate value.
     * @param coordinate The coordinate to validate.
     * @return The validated coordinate.
     */
    private int validateCoordinate(int coordinate) {
        if (coordinate > 100) {
            return 100;
        } else if (coordinate < -100) {
            return -100;
        } else {
            return coordinate;
        }
    }

    /**
     * Get the radius of the circle.
     * @return The radius of the circle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Get the origin coordinates of the circle.
     * @return An array containing the x and y coordinates of the circle's origin.
     */
    public int[] getOrigin() {
        return new int[]{x, y};
    }

    /**
     * Combine the circle with another circle by updating its radius and moving its origin.
     * @param c The circle to combine with.
     */
    public void combineCircle(CircleOperations c) {
        this.radius += c.getRadius();
        int newX = (this.x + c.getOrigin()[0]) / 2;
        int newY = (this.y + c.getOrigin()[1]) / 2;
        move(newX, newY);
    }

    /**
     * Double the size of the circle by combining it with itself.
     */
    public void doubleCircle() {
        combineCircle(this);
    }

    /**
     * Return a string representation of the circle.
     * @return A string representation of the circle.
     */
    @Override
    public String toString() {
        return "(x-" + x + ")^2 + (y-" + y + ")^2 = " + radius + "^2";
    }

    public static void main(String[] args) {
        CircleOperations c1 = new CircleOperations(3, 4, 5);
        CircleOperations c2 = new CircleOperations(2);
        CircleOperations c3 = new CircleOperations();

        System.out.println("Circle 1: " + c1);
        System.out.println("Area: " + c1.area());
        System.out.println("Perimeter: " + c1.perimeter());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Origin: (" + c1.getOrigin()[0] + ", " + c1.getOrigin()[1] + ")");
        System.out.println();

        System.out.println("Circle 2: " + c2);
        System.out.println("Area: " + c2.area());
        System.out.println("Perimeter: " + c2.perimeter());
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Origin: (" + c2.getOrigin()[0] + ", " + c2.getOrigin()[1] + ")");
        System.out.println();

        System.out.println("Circle 3: " + c3);
        System.out.println("Area: " + c3.area());
        System.out.println("Perimeter: " + c3.perimeter());
        System.out.println("Radius: " + c3.getRadius());
        System.out.println("Origin: (" + c3.getOrigin()[0] + ", " + c3.getOrigin()[1] + ")");
        System.out.println();

        c1.combineCircle(c2);
        System.out.println("Combined Circle 1 and Circle 2: " + c1);
        System.out.println("Area: " + c1.area());
        System.out.println("Perimeter: " + c1.perimeter());
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Origin: (" + c1.getOrigin()[0] + ", " + c1.getOrigin()[1] + ")");
        System.out.println();

        c2.doubleCircle();
        System.out.println("Doubled Circle 2: " + c2);
        System.out.println("Area: " + c2.area());
        System.out.println("Perimeter: " + c2.perimeter());
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Origin: (" + c2.getOrigin()[0] + ", " + c2.getOrigin()[1] + ")");
    }
}
