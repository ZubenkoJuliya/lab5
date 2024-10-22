package geometry2d;

import exceptions.InvalidDimensionException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class Circle implements Figure {
    private static final Logger logger = Logger.getLogger(Circle.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("figures.log", true);
            fileHandler.setFormatter(new XMLFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            logger.severe("Attempted to create Circle with invalid radius: " + radius);
            throw new InvalidDimensionException("Radius must be positive");
        }
        this.radius = radius;
        logger.severe("Created Circle: " + this);
    }

    @Override public double area() {
        return 3.14 * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle: radius=%.2f, area=%.2f, perimeter=%.2f", radius, area(), perimeter());
    }
}