package by.balashevich.shapeapp.creator;

import by.balashevich.shapeapp.entity.Shape;

import java.util.List;

public interface ShapeCreator<T extends Shape> {
    List<T> createShapes(List<String> shapeData);
}
