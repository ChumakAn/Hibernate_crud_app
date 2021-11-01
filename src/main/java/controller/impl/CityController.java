package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.CityDaoImpl;
import model.entities.City;

import java.util.List;

public class CityController extends AbstractGenericControllerImpl<City>{
    private final CityDaoImpl cityDao = new CityDaoImpl();

    @Override
    public AbstractGenericDaoImpl<City> getDao(){
        return cityDao;
    }



}
