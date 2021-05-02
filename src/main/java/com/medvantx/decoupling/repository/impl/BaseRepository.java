package com.medvantx.decoupling.repository.impl;

import com.medvantx.decoupling.model.BaseModel;
import com.medvantx.decoupling.repository.CrudRepository;
import com.mongodb.WriteResult;
import dev.morphia.Datastore;
import dev.morphia.FindAndModifyOptions;
import dev.morphia.Key;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseRepository< T extends BaseModel, ID extends Serializable> implements CrudRepository<T, ID> {

    @Autowired
    private Datastore datastore;
    private Class<T> t;

    public BaseRepository(Class<T> t) {
        this.t = t;
    }

    @Override
    public Key<T> create(T entity) {
        entity.setDateCreated(new Date());
        entity.setDateModified(new Date());
        return datastore.save(entity);
    }

    @Override
    public Iterable<Key<T>> createAll(Iterable<T> entities) {
        entities.forEach(e -> {
            e.setDateCreated(new Date());
            e.setDateModified(new Date());
        });
        return datastore.save(entities);
    }

    @Override
    public T findById(String id) {
        return datastore.get(t, id);
    }

    @Override
    public List<T> findAll() {
        return datastore.find(t).find().toList();
    }

    @Override
    public UpdateResults update(Query<T> query, UpdateOperations<T> operations) {
        operations.set("date_modified", new Date());
        return datastore.update(query, operations);
    }

    @Override
    public WriteResult delete(T entity) {
        return datastore.delete(entity);
    }

    @Override
    public UpdateOperations<T> createOperations() {
        return datastore.createUpdateOperations(t);
    }

    @Override
    public Query<T> createQuery() {
        return datastore.createQuery(t);
    }

    @Override
    public UpdateOperations<T> createUpdateOperations() {
        return datastore.createUpdateOperations(t);
    }

    @Override
    public T findAndDelete(Query<T> query) {
        return datastore.findAndDelete(query);
    }

    @Override
    public T findAndModify(Query<T> query, UpdateOperations<T> operations, FindAndModifyOptions var3) {
        return datastore.findAndModify(query, operations, var3);
    }

    @Override
    public T findAndModify(Query<T> query, UpdateOperations<T> operations) {
        return datastore.findAndModify(query, operations);
    }


}
