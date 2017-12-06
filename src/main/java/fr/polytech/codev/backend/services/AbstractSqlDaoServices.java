package fr.polytech.codev.backend.services;

import fr.polytech.codev.backend.sessions.HibernateSession;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractSqlDaoServices<T> implements DaoServices<T> {

    public abstract Class<T> getEntityClass();

    @Override
    public T get(Serializable id) {
        final Session session = getSession();

        session.beginTransaction();
        final T entity = session.get(getEntityClass(), id);
        session.getTransaction().commit();

        session.close();

        return entity;
    }

    private Session getSession() {
        return HibernateSession.getSession();
    }

    @Override
    public List<T> getAll() {
        final Session session = getSession();

        session.beginTransaction();
        final List<T> entities = session.createCriteria(getEntityClass()).list();
        session.getTransaction().commit();

        session.close();

        return entities;
    }

    @Override
    public List<T> filter(Map<String, String> parameters) {
        final Session session = getSession();

        session.beginTransaction();
        final List<T> entities = session.createCriteria(getEntityClass()).add(Restrictions.allEq(parameters)).list();
        session.getTransaction().commit();

        session.close();

        return entities;
    }

    @Override
    public int count() {
        final Session session = getSession();

        session.beginTransaction();
        final int nbEntities = ((Long) session.createCriteria(getEntityClass()).setProjection(Projections.rowCount()).uniqueResult()).intValue();
        session.getTransaction().commit();

        session.close();

        return nbEntities;
    }

    @Override
    public void insert(T object) {
        final Session session = getSession();

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void update(T object) {
        final Session session = getSession();

        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(T object) {
        final Session session = getSession();

        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();

        session.close();
    }
}