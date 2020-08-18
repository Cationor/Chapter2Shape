package by.balashevich.shapeapp.validator;

import by.balashevich.shapeapp.entity.Quadrangle;

public class QuadrangleValidator {
    private static final String DOUBLE_VALUE = "\\d+\\.\\d+"; // TODO: 17.08.2020 add "regex"
    private static final String POINT_VALUE = DOUBLE_VALUE + "\\s" + DOUBLE_VALUE;
    private static final String QUADRANGLE_DATA = "(" + POINT_VALUE + "\\;\\s){3}" + POINT_VALUE + "\\b";

    public boolean isQuadrangleDataCorrect(String testData) {

        return testData.matches(QUADRANGLE_DATA);
    }

    public boolean isQuadrangleExist(Quadrangle quadrangle) {
        boolean isExist = false;

        if (!quadrangle.getPointA().equals(quadrangle.getPointB())
                && !quadrangle.getPointB().equals(quadrangle.getPointC())
                && !quadrangle.getPointC().equals(quadrangle.getPointD())) {
            double abcLeftEquationPart = (quadrangle.getPointA().getCoordinateX() - quadrangle.getPointC().getCoordinateX())
                    / (quadrangle.getPointB().getCoordinateX() - quadrangle.getPointC().getCoordinateX());
            double abcRightEquationPart = (quadrangle.getPointA().getCoordinateY() - quadrangle.getPointC().getCoordinateY())
                    / (quadrangle.getPointB().getCoordinateY() - quadrangle.getPointC().getCoordinateY());
            double acdLeftEquationPart = (quadrangle.getPointA().getCoordinateX() - quadrangle.getPointD().getCoordinateX())
                    / (quadrangle.getPointC().getCoordinateX() - quadrangle.getPointD().getCoordinateX());
            double acdRightEquationPart = (quadrangle.getPointA().getCoordinateY() - quadrangle.getPointD().getCoordinateY())
                    / (quadrangle.getPointC().getCoordinateY() - quadrangle.getPointD().getCoordinateY());
            if (abcLeftEquationPart != abcRightEquationPart && acdLeftEquationPart != acdRightEquationPart) {
                isExist = true;
            }
        }

        return isExist;
    }
}
