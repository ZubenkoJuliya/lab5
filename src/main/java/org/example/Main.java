package org.example;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import exceptions.InvalidDimensionException;
import exceptions.InvalidFigureException;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        // Настройка логирования для вывода в консоль
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        logger.setLevel(java.util.logging.Level.FINE);
    }

    public static void main(String[] args) {
        // Тестирование с корректными значениями
        try {
            Circle circle = new Circle(5);
            logger.fine("Created Circle: " + circle);
            System.out.println(circle);

            Rectangle rectangle = new Rectangle(4, 6);
            logger.fine("Created Rectangle: " + rectangle);
            System.out.println(rectangle);

            Cylinder cylinder = new Cylinder(circle, 10);
            logger.fine("Created Cylinder: " + cylinder);
            System.out.println(cylinder);
        } catch (InvalidDimensionException | InvalidFigureException e) {
            logger.severe("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Тестирование Circle с некорректным значением
        try {
            Circle invalidCircle = new Circle(-3);
            logger.fine("Created invalid Circle: " + invalidCircle);
            System.out.println(invalidCircle);
        } catch (InvalidDimensionException e) {
            logger.severe("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Тестирование Rectangle с некорректным значением
        try {
            Rectangle invalidRectangle = new Rectangle(0, 5);
            logger.fine("Created invalid Rectangle: " + invalidRectangle);
            System.out.println(invalidRectangle);
        } catch (InvalidDimensionException e) {
            logger.severe("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Тестирование Cylinder с некорректным основанием
        try {
            Cylinder invalidCylinder = new Cylinder(null, 7);
            logger.fine("Created invalid Cylinder with null base: " + invalidCylinder);
            System.out.println(invalidCylinder);
        } catch (InvalidFigureException e) {
            logger.severe("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Тестирование Cylinder с некорректной высотой
        try {
            Circle validCircle = new Circle(4);
            Cylinder invalidCylinderHeight = new Cylinder(validCircle, -5);
            logger.fine("Created invalid Cylinder with negative height: " + invalidCylinderHeight);
            System.out.println(invalidCylinderHeight);
        } catch (InvalidDimensionException e) {
            logger.severe("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}