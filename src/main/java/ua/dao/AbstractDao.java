package ua.dao;

import org.hibernate.ObjectNotFoundException;
import ua.config.PersistenceProvider;
import ua.model.Customers;
import ua.model.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {

    private final Class<T> entityType;
    protected EntityManager em = PersistenceProvider.getEntityManager();

    public AbstractDao(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public void create(T entity) throws SQLException {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) throws SQLException {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
         entity = em.merge(entity);
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        Query getAll = em.createQuery("from " + entityType.getSimpleName(),entityType);
        return getAll.getResultList();
    }

    @Override
    public Optional get(Long id) throws SQLException {
        try {
            T entity = em.find(entityType, id);
            return Optional.of(entity);
        } catch (ObjectNotFoundException e) {
            return Optional.empty();
        }
    }
}
