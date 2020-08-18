package by.balashevich.shapeapp.factory;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.Shape;
import by.balashevich.shapeapp.parser.EntityParser;
import by.balashevich.shapeapp.validator.QuadrangleValidator;

import java.util.Optional;

public enum ShapeFactory{
    QUADRANGLE{
        @Override
        public Optional<Shape> createShape(String shapeData) {
            EntityParser parser = new EntityParser();
            QuadrangleValidator validator = new QuadrangleValidator();
            Optional<Shape> optionalShape = Optional.empty();

            Quadrangle quadrangle = parser.parseQuadrangle(shapeData);
            if (validator.isQuadrangleExist(quadrangle)){
                optionalShape = Optional.of(quadrangle);
            }

            return optionalShape;
        }
    },
    CIRCLE{
        @Override
        public Optional<Shape> createShape(String shapeData) {
            return null;
        }
    };

    public abstract Optional<Shape> createShape(String shapeData);
}
