package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.GuideDaoImpl;
import model.entities.Guide;

public class GuideController extends AbstractGenericControllerImpl<Guide>{

    private final GuideDaoImpl guideDao = new GuideDaoImpl();

    @Override
    public AbstractGenericDaoImpl<Guide> getDao(){
        return guideDao;
    }
}
