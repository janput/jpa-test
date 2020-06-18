package org.example.jpa.persistence;

import org.example.jpa.model.TestEntity;

public interface TestEntityRepository extends AuditedRepository<TestEntity, Long> {

}
