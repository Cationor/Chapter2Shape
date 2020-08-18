package by.balashevich.shapeapp.comparator;

import by.balashevich.shapeapp.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleAPointXCoordinateComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle q1, Quadrangle q2) {
        return (int)(q1.getPointA().getCoordinateX() - q2.getPointA().getCoordinateX());
    }
}
