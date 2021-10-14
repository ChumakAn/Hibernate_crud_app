package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.CountryDaoImpl;
import model.entities.Country;

public class CountryController extends AbstractGenericControllerImpl<Country> {
    private final CountryDaoImpl countryDao = new CountryDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Country> getDao(){
        return countryDao;
    }

}
