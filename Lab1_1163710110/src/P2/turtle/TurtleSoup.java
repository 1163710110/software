/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package src.P2.turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle
     *            the turtle context
     * @param sideLength
     *            length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(sideLength);
        turtle.turn(90.0);
        turtle.forward(sideLength);
        turtle.turn(90.0);
        turtle.forward(sideLength);
        turtle.turn(90.0);
        turtle.forward(sideLength);
        // throw new RuntimeException("implement me!");
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon; you
     * should derive it and use it here.
     * 
     * @param sides
     *            number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        // throw new RuntimeException("implement me!");
        return (sides - 2) * 180.0 / sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular
     * polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see
     * java.lang.Math). HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle
     *            size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        // throw new RuntimeException("implement me!");
        return (int) Math.ceil(2.00 / (1 - angle / 180.00));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to
     * draw.
     * 
     * @param turtle
     *            the turtle context
     * @param sides
     *            number of sides of the polygon to draw
     * @param sideLength
     *            length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        // throw new RuntimeException("implement me!");
        double d = 180 - calculateRegularPolygonAngle(sides);
        for (int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turn(d);
        }
    }

    /**
     * Given the current direction, current location, and a target location,
     * calculate the heading towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in
     * the direction of the target point (targetX,targetY), given that the turtle is
     * already at the point (currentX,currentY) and is facing at angle
     * currentHeading. The angle must be expressed in degrees, where 0 <= angle <
     * 360.
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading
     *            current direction as clockwise from north
     * @param currentX
     *            current location x-coordinate
     * @param currentY
     *            current location y-coordinate
     * @param targetX
     *            target point x-coordinate
     * @param targetY
     *            target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY, int targetX,
            int targetY) {
        // throw new RuntimeException("implement me!");
        double n = 0.0, angle = 0.0;
        int x = targetX - currentX, y = targetY - currentY;
        if (y == 0) {
            angle = 90;
        } else {
            double v = (Math.abs(x) * 1.00 / Math.abs(y));
            angle = Math.toDegrees(Math.atan(v));
        }
        if (x >= 0 && y > 0) {
            n = angle - currentHeading;

        }

        if (x >= 0 && y < 0) {
            n = 180 - angle - currentHeading;
        }
        if (x < 0 && y < 0) {
            n = 180 + angle - currentHeading;
        }
        if (x < 0 && y > 0) {
            n = 360 - angle - currentHeading;
        }
        if (x > 0 && y == 0) {
            n = angle - currentHeading;

        }
        if (x < 0 && y == 0) {
            n = 180 + angle - currentHeading;
        }
        while (n >= 360.0) {
            n -= 360;
        }
        while (n < 0) {
            n += 360;
        }
        return n;

    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get
     * from each point to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0
     * degrees). For each subsequent point, assumes that the turtle is still facing
     * in the direction it was facing when it moved to the previous point. You
     * should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords
     *            list of x-coordinates (must be same length as yCoords)
     * @param yCoords
     *            list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of
     *         points) == 0, otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        // throw new RuntimeException("implement me!");
        List<Double> headings = new ArrayList<Double>();
        double cH = 0.0;
        for (int i = 0; i < xCoords.size() - 1; i++) {
            cH = calculateHeadingToPoint(cH, xCoords.get(i), yCoords.get(i), xCoords.get(i + 1), yCoords.get(i + 1));
            System.out.println(cH);
            headings.add(cH);
        }
        return headings;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a
     * turtle. For this function, draw something interesting; the complexity can be
     * as little or as much as you want.
     * 
     * @param turtle
     *            the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        // throw new RuntimeException("implement me!");
        for (int i = 0; i < 5; i++) {
            turtle.forward(20);
            turtle.turn(144);
            turtle.forward(20);
            turtle.turn(-72);
        }

    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args
     *            unused
     */
    public static void main(String args[]) {

        DrawableTurtle turtle = new DrawableTurtle();

        drawSquare(turtle, 40);
        turtle.forward(20);
        drawRegularPolygon(turtle, 6, 25);
        turtle.forward(20);
        drawPersonalArt(turtle);
        // draw the window
        turtle.draw();
    }

}
