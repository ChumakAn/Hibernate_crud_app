package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.TransportTypeDaoImpl;
import model.entities.TransportType;

public class TransportTypeController extends AbstractGenericControllerImpl<TransportType>{

    private final TransportTypeDaoImpl transportTypeDao = new TransportTypeDaoImpl();

    @Override
    public AbstractGenericDaoImpl<TransportType> getDao(){
        return transportTypeDao;
    }
}
