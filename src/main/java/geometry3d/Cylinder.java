package geometry3d;

import geometry2d.Figure;
import exceptions.InvalidDimensionException;
import exceptions.InvalidFigureException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Cylinder {
    private static final Logger logger = Logger.getLogger(Cylinder.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("cylinder.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            logger.setLevel(java.util.logging.Level.FINEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) {
        if (base == null) {
            logger.severe("Attempted to create Cylinder with null base figure");
            throw new InvalidFigureException("Base figure cannot be null");
        }
        if (height <= 0) {
            logger.severe("Attempted to create Cylinder with invalid height: " + height);
            throw new InvalidDimensionException("Height must be positive");
        }
        this.base = base;
        this.height = height;
        logger.fine("Created Cylinder: " + this);
    }

    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder: base=[%s], height=%.2f, volume=%.2f", base.toString(), height, volume());
    }
}