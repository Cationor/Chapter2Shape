package by.balashevich.shapeapp.comparator;

import by.balashevich.shapeapp.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleBPointYCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle q1, Quadrangle q2) {
        return (int)(q1.getPointB().getCoordinateY() - q2.getPointB().getCoordinateY());
    }
}
