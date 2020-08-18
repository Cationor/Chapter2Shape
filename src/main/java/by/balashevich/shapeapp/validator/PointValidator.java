package by.balashevich.shapeapp.validator;

public class PointValidator {
    private static final String DOUBLE_VALUE = "\\d+\\.\\d+";
    private static final String POINT_VALUE = DOUBLE_VALUE + "\\s" + DOUBLE_VALUE;

    public boolean isPointDataCorrect(String testData) {

        return testData.matches(POINT_VALUE);
    }
}
