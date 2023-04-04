package dao;

import java.util.List;

// Specification of the DAO interface
// T is the type of the entity
// PK is the type of the primary key
// The DAO interface is parameterized with the entity type and the primary key type

public interface Dao<T, PK> {
    List<T> findAll();

    T findByID(PK pk);

    void insert(T item);

    Boolean update(T item);

    Boolean delete(PK pk);
}
