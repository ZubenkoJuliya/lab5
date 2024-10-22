package geometry2d;

import exceptions.InvalidDimensionException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
import java.util.logging.SimpleFormatter;

public class Rectangle implements Figure {
    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

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

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            logger.info("Attempted to create Rectangle with invalid dimensions: width=" + width + ", height=" + height);
            throw new InvalidDimensionException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
        logger.info("Created Rectangle: " + this);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle: width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f", width, height, area(), perimeter());
    }
}