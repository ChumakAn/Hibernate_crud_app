package model.dao.impl;

import model.entities.Country;

public class CountryDaoImpl extends AbstractGenericDaoImpl<Country>{
    public CountryDaoImpl(){
        super(Country.class);
    }
}
