package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.RouteDaoImpl;
import model.entities.Route;

public class RouteController extends AbstractGenericControllerImpl<Route> {
    private final RouteDaoImpl routeDao = new RouteDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Route> getDao() {
        return routeDao;
    }
}
