package controller.impl;

import controller.AbstractGenericController;
import model.dao.impl.AbstractGenericDaoImpl;

import java.util.List;

public abstract class AbstractGenericControllerImpl<E> implements AbstractGenericController<E> {
    public abstract AbstractGenericDaoImpl<E> getDao();

    @Override
    public List<E> findAll() {
        return (List<E>) getDao().findAll();
    }

    @Override
    public E findOne(Integer id) {
        return getDao().findOne(id);
    }

    @Override
    public void create(E object) {
        getDao().create(object);
    }

    @Override
    public void update(Integer id, E object) {
        getDao().update(id, object);
    }

    @Override
    public void delete(Integer id) {
        getDao().delete(id);
    }

}
