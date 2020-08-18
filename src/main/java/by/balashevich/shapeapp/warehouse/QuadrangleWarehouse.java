package by.balashevich.shapeapp.warehouse;

import by.balashevich.shapeapp.exception.ShapeProjectException;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleWarehouse {
    private Map<Long, QuadrangleCharacteristic> characteristicList;
    private static QuadrangleWarehouse instance;

    private QuadrangleWarehouse (){
        characteristicList = new HashMap<>();
    }

    public static QuadrangleWarehouse getInstance(){
        if (instance == null){
            instance = new QuadrangleWarehouse();
        }

        return instance;
    }

    public QuadrangleCharacteristic addCharacteristic(long id, QuadrangleCharacteristic parameters) throws ShapeProjectException {
        QuadrangleCharacteristic addedCharacteristic = characteristicList.put(id, parameters);

        if (addedCharacteristic == null){
            throw new ShapeProjectException(); // TODO: 17.08.2020  add log
        }
        return characteristicList.put(id, parameters);
    }

    public QuadrangleCharacteristic getCharacteristic(long id) throws ShapeProjectException {
        QuadrangleCharacteristic quadrangleCharacteristic;
        if (characteristicList.containsKey(id)){
            quadrangleCharacteristic = characteristicList.get(id);
        } else{
            throw new ShapeProjectException(); // TODO: 17.08.2020  add log
        }

        return quadrangleCharacteristic;
    }

    public QuadrangleCharacteristic removeCharacteristic(long id) throws ShapeProjectException {
        QuadrangleCharacteristic removedCharacteristic = characteristicList.remove(id);

        if (removedCharacteristic == null){
            throw new ShapeProjectException(); // TODO: 17.08.2020  add log
        }
        return removedCharacteristic;
    }
}
