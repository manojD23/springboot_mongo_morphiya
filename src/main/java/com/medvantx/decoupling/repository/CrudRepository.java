package com.medvantx.decoupling.repository;

import com.mongodb.WriteResult;
import dev.morphia.FindAndModifyOptions;
import dev.morphia.Key;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    Key<T> create(T entity);

    Iterable<Key<T>> createAll(Iterable<T> entities);

    T findById(String id);

    List<T> findAll();

    UpdateResults update(Query<T> query, UpdateOperations<T> operations);

    WriteResult delete(T entity);

    UpdateOperations<T> createOperations();

    Query<T> createQuery();

    UpdateOperations<T> createUpdateOperations();

    T findAndDelete(Query<T> query);

    T findAndModify(Query<T> query, UpdateOperations<T> operations, FindAndModifyOptions var3);

    T findAndModify(Query<T> query, UpdateOperations<T> operations);


}
