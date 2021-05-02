package com.medvantx.decoupling.model;

import com.mongodb.WriteResult;
import dev.morphia.Datastore;
import dev.morphia.FindAndModifyOptions;
import dev.morphia.Key;
import dev.morphia.annotations.PrePersist;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Version;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class  BaseModel<T> {

    @Autowired
    private Datastore datastore;

    @Property("date_created")
    private Date dateCreated;

    @Property("date_modified")
    private Date dateModified;

    @Version
    private Long version;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", version=" + version +
                '}';
    }

    public Key<T> create(T entity) {
        return datastore.save(entity);
    }

    public Iterable<Key<T>> createAll(Iterable<T> entities) {
        return datastore.save(entities);
    }

    public T findById(String id) {
        System.out.println(datastore.getDatabase());
        return (T) datastore.get(this.getClass(), id);
    }

    public List<T> findAll() {
        System.out.println("In find ALl method");
        System.out.println("Class :"+this.getClass());
        System.out.println(datastore.getDatabase());
        return (List<T>) datastore.find(this.getClass()).find().toList();
    }

    public UpdateResults update(Query<T> query, UpdateOperations<T> operations) {
        return datastore.update(query, operations);
    }

    public WriteResult delete(T entity) {
        return datastore.delete(entity);
    }

    public UpdateOperations<T> createOperations() {
        return (UpdateOperations<T>) datastore.createUpdateOperations(this.getClass());
    }

    public Query<T> createQuery() {
        return (Query<T>) datastore.createQuery(this.getClass());
    }

    public UpdateOperations<T> createUpdateOperations() {
        return (UpdateOperations<T>) datastore.createUpdateOperations(this.getClass());
    }

    public T findAndDelete(Query<T> query) {
        return datastore.findAndDelete(query);
    }

    public T findAndModify(
            Query<T> query, UpdateOperations<T> operations, FindAndModifyOptions var3) {
        return datastore.findAndModify(query, operations, var3);
    }

    public T findAndModify(Query<T> query, UpdateOperations<T> operations) {
        return datastore.findAndModify(query, operations);
    }
}
