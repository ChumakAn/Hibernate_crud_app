package model.dao.impl;

import model.dao.AbstractGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractGenericDaoImpl<E> implements AbstractGenericDao<E> {

    private final Class<E> currentClass;
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public AbstractGenericDaoImpl(Class<E> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<E> findAll() {
        List<E> entities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entities = session.createQuery("from " + currentClass.getName()).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }


    @Override
    public E findOne(Integer id) {
        E entity = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entity = session.get(currentClass, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void update(Integer id, E entity){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(E entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            E entity = session.get(currentClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
