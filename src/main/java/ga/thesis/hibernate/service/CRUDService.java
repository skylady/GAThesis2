package ga.thesis.hibernate.service;

import java.util.List;

public interface CRUDService<T> {

    public T findOne(final long id);

    public Iterable<ga.thesis.hibernate.entities.Teacher> findAll();

    public void create(final T entity);

    public T update(final T entity);

    public void delete(final T entity);

    public void deleteById(final long entityId);
}
