package org.example.jpa.persistence;

import org.example.jpa.model.AuditedModel;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class AuditedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements AuditedRepository<T, ID> {

    public AuditedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public T create(T entity, String userName) {
        return save(entity, userName);
    }

    @Override
    public T update(T entity, String userName) {
        return save(entity, userName);
    }

    @Override
    public T save(T entity, String userName) {
        if (entity instanceof AuditedModel) {
            AuditedModel audited = (AuditedModel) entity;
            audited.touch(userName);
        }
        return save(entity);
    }
}
