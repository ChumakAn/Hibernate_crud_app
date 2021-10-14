package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.HotelDaoImpl;
import model.entities.Hotel;

public class HotelController extends AbstractGenericControllerImpl<Hotel>{

    private final HotelDaoImpl hotelDao = new HotelDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Hotel> getDao(){
        return hotelDao;
    }
}
