package by.balashevich.shapeapp.observer.impl;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.QuadrangleType;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import by.balashevich.shapeapp.observer.Observer;
import by.balashevich.shapeapp.observer.QuadrangleEvent;
import by.balashevich.shapeapp.service.impl.QuadrangleService;
import by.balashevich.shapeapp.warehouse.QuadrangleCharacteristic;
import by.balashevich.shapeapp.warehouse.QuadrangleWarehouse;

public class QuadrangleObserver implements Observer<QuadrangleEvent> {

    @Override
    public void actionPerformed(QuadrangleEvent eventObject) {
        Quadrangle eventQuadrangle = eventObject.getSource();
        QuadrangleService service = new QuadrangleService();
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();

        double area = service.calculateArea(eventQuadrangle);
        double perimeter = service.calculatePerimeter(eventQuadrangle);
        QuadrangleType type = service.determineQuadrangleType(eventQuadrangle);
        boolean isConvex = service.isQuadrangleConvex(eventQuadrangle);

        QuadrangleCharacteristic characteristic = new QuadrangleCharacteristic(area, perimeter, type, isConvex);

        try {
            warehouse.addCharacteristic(eventQuadrangle.getId(), characteristic);
        } catch (ShapeProjectException e) {
            // TODO: 17.08.2020 add log 
        }
    }
}
