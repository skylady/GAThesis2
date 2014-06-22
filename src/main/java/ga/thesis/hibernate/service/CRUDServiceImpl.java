package ga.thesis.hibernate.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by sky_lady on 6/17/14.
 */
public abstract class CRUDServiceImpl<T, ID extends Serializable> implements CRUDService<T, ID> {

    protected abstract CrudRepository<T, ID> getRepository();

    @Override
    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public void create(T entity) {
        getRepository().save(entity);
    }

    @Override
    public T update(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        getRepository().delete(entityId);
    }
}
