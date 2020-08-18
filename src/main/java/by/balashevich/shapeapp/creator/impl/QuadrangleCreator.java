package by.balashevich.shapeapp.creator.impl;

import by.balashevich.shapeapp.creator.ShapeCreator;
import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.Shape;
import by.balashevich.shapeapp.factory.ShapeFactory;
import by.balashevich.shapeapp.repository.QuadrangleRepository;
import by.balashevich.shapeapp.validator.QuadrangleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuadrangleCreator implements ShapeCreator<Quadrangle> {

    @Override
    public List<Quadrangle> createShapes(List<String> shapeData) {
        QuadrangleValidator validator = new QuadrangleValidator();
        List<Quadrangle> quadrangleList = new ArrayList<>();
        QuadrangleRepository repository = QuadrangleRepository.getInstance();

        for(String shapeDataElement : shapeData){
            if (validator.isQuadrangleDataCorrect(shapeDataElement)){
                Optional<Shape> optionalShape = ShapeFactory.QUADRANGLE.createShape(shapeDataElement);
                if (optionalShape.isPresent()){
                    Quadrangle quadrangle = (Quadrangle) optionalShape.get();
                    quadrangle.notifyObserver();
                    repository.add(quadrangle);
                } else{
                    // TODO: 17.08.2020 add log
                }
            }
        }

        return quadrangleList;
    }
}
