package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.PlaceDaoImpl;
import model.entities.Place;

public class PlaceController extends AbstractGenericControllerImpl<Place>{
    private final PlaceDaoImpl placeDao = new PlaceDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Place> getDao(){
        return placeDao;
    }
}
