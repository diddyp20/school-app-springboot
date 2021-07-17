package com.bndnetworks.net.schoolAppdemo.classes.repository;

import com.bndnetworks.net.schoolAppdemo.classes.entity.ClassEntity;
import com.bndnetworks.net.schoolAppdemo.util.SchoolCacheConstant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
    @Cacheable(SchoolCacheConstant.SCHOOL_ALL_CLASSES)
    List<ClassEntity> findAllBy();

    @Cacheable(SchoolCacheConstant.SCHOOL_CLASS_BY_ID)
    Optional<ClassEntity> findById(final Integer classId);
}
