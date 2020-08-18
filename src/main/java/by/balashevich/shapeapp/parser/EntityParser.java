package by.balashevich.shapeapp.parser;

import by.balashevich.shapeapp.entity.Point;
import by.balashevich.shapeapp.entity.Quadrangle;

public class EntityParser {
    private static final String POINTS_DELIMITER = ";";
    private static final String COORDINATES_DELIMITER = "\\s";

    public Quadrangle parseQuadrangle(String quadrangleData) {     // TODO: 12.08.2020 may be need there validate string or make it on method what call that method
        String[] pointsData = quadrangleData.split(POINTS_DELIMITER);
        Point pointA = parsePoint(pointsData[0]);
        Point pointB = parsePoint(pointsData[1]);
        Point pointC = parsePoint(pointsData[2]);
        Point pointD = parsePoint(pointsData[3]);

        return new Quadrangle(pointA, pointB, pointC, pointD);
    }

    public Point parsePoint(String pointData) {
        String[] coordinatesData = pointData.trim().split(COORDINATES_DELIMITER);
        double coordinateX = Double.parseDouble(coordinatesData[0].trim());
        double coordinateY = Double.parseDouble(coordinatesData[1].trim());

        return new Point(coordinateX, coordinateY);
    }
}
