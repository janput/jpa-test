package org.example.jpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AuditedRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T create(T entity, String username);

    T update(T entity, String userName);

    T save(T entity, String userName);
}
