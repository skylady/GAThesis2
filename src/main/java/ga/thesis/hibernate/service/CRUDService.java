package ga.thesis.hibernate.service;

public interface CRUDService<T, ID> {

    public T findOne(final ID id);

    public Iterable<T> findAll();

    public void create(final T entity);

    public T update(final T entity);

    public void delete(final T entity);

    public void deleteById(final ID entityId);
}
