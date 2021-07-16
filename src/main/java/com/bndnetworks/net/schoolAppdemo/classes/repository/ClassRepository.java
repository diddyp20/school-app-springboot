package com.bndnetworks.net.schoolAppdemo.classes.repository;

import com.bndnetworks.net.schoolAppdemo.classes.entity.ClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
    List<ClassEntity> findAllBy();

   Optional<ClassEntity> findById(final Integer classId);
}
