package org.academiadecodigo.bootcamp40.persistence.dao.jpa;

import org.academiadecodigo.bootcamp40.persistence.dao.Dao;
import org.academiadecodigo.bootcamp40.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    protected Class<T> modeltype;

    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modeltype) {
        this.modeltype = modeltype;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modeltype);
        Root<T> root = criteriaQuery.from(modeltype);
        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public T findById(Integer id) {
        return em.find(modeltype, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modeltype, id));
    }

}
