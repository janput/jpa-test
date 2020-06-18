package org.example.jpa.controller;

import org.example.jpa.model.TestEntity;
import org.example.jpa.persistence.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestEntityController {

    TestEntityRepository testEntityRepository;

    @Autowired
    public TestEntityController(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    @PostMapping("/create")
    public TestEntity createTestEntity() {
        TestEntity entity = new TestEntity();
        entity.setValue("bla");
        entity = testEntityRepository.create(entity, "jan");
        return entity;
    }

    @PostMapping(value = "/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TestEntity updateTestEntity(@PathVariable("id") Long id, @RequestBody TestEntity entity) {
        TestEntity fromDb = testEntityRepository.findOne(id);
        fromDb.setValue(entity.getValue());
        return testEntityRepository.update(fromDb, "jan2");
    }
}
