package by.balashevich.shapeapp.repository;

import by.balashevich.shapeapp.entity.Quadrangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository {
    private List<Quadrangle> quadrangleList;
    private static QuadrangleRepository instance;

    private QuadrangleRepository(){
        quadrangleList = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance(){
        if (instance == null){
            instance = new QuadrangleRepository();
        }

        return instance;
    }

    public boolean add(Quadrangle quadrangle){

        return quadrangleList.add(quadrangle);
    }

    public boolean addAll(List<Quadrangle> quadrangles){

        return  quadrangleList.addAll(quadrangles);
    }

    public boolean remove(Quadrangle quadrangle){

        return quadrangleList.remove(quadrangle);
    }

    public List<Quadrangle> query (Specification specification){  // TODO: 12.08.2020 may be there need to check list on null
        return quadrangleList.stream().filter(specification).collect(Collectors.toList());
    }

    public List<Quadrangle> sort (Comparator<Quadrangle> comparator){

        return quadrangleList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
