package by.balashevich.shapeapp.parser;

import by.balashevich.shapeapp.exception.ShapeProjectException;
import by.balashevich.shapeapp.validator.PointValidator;
import by.balashevich.shapeapp.validator.QuadrangleValidator;

import java.util.ArrayList;
import java.util.List;

public class EntityParser {
    private static final String POINTS_DELIMITER = ";";
    private static final String COORDINATES_DELIMITER = "\\s";

    public List<List<Double>> parseQuadrangles(List<String> quadranglesData) {
        List<List<Double>> quadranglesCoordinatesList = new ArrayList<>();

        for (String quadrangleDataElement : quadranglesData) {
            try {
                quadranglesCoordinatesList.add(parseQuadrangle(quadrangleDataElement));
            } catch (ShapeProjectException e){
                // TODO: 18.08.2020 add logger
            }

        }

        return quadranglesCoordinatesList;
    }

    public List<Double> parseQuadrangle(String quadrangleData) throws ShapeProjectException {
        QuadrangleValidator validator = new QuadrangleValidator();
        List<Double> quadrangleCoordinates = new ArrayList<>();

        if (validator.isQuadrangleDataCorrect(quadrangleData)) {
            String[] pointsData = quadrangleData.split(POINTS_DELIMITER);
            for(String pointDataElement : pointsData){
                quadrangleCoordinates.addAll(parsePoint(pointDataElement));
            }
        } else{
            throw new ShapeProjectException();
            // TODO: 18.08.2020 add logger
        }

        return quadrangleCoordinates;
    }

    public List<Double> parsePoint(String pointData) throws ShapeProjectException {
        PointValidator validator = new PointValidator();
        List<Double> pointCoordinates = new ArrayList<>();

        if (validator.isPointDataCorrect(pointData)) {
            String[] coordinatesData = pointData.trim().split(COORDINATES_DELIMITER);
            pointCoordinates.add(Double.parseDouble(coordinatesData[0].trim()));
            pointCoordinates.add(Double.parseDouble(coordinatesData[1].trim()));
        } else{
            throw new ShapeProjectException();
            // TODO: 18.08.2020 add logger
        }

        return pointCoordinates;
    }
}
