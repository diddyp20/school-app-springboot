package com.bndnetworks.net.schoolAppdemo.config;

import com.bndnetworks.net.schoolAppdemo.classes.entity.ClassEntity;
import com.bndnetworks.net.schoolAppdemo.classes.repository.ClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bndnetworks.net.schoolAppdemo.util.SchoolCacheConstant.*;

@EnableJpaRepositories(basePackages = "com.bndnetworks.net.schoolAppdemo")
@Component
public class LocalCacheConfig implements ApplicationListener<ApplicationStartedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalCacheConfig.class);

    @Autowired
    CacheManager cacheManager;

    @Autowired
    ClassRepository classRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        LOGGER.info("appName: School App Demo || message: Initializing local caches.");
        populateCaches();
        LOGGER.info("appName: School App Demo || message: Initializing local caches complete.");

    }

    void populateCaches() {
        try {
            List<ClassEntity> classList = classRepository.findAllBy();
            if (!classList.isEmpty()) {
                populateIndividualClass(classList);
            }
            classRepository.findById(1);
        } catch (Exception e) {
            LOGGER.error("appName: School App Demo || Critical Error retrieving local cache");
        }
    }

    private void populateIndividualClass(List<ClassEntity> classList) {
        for (ClassEntity individualClass : classList) {
            Integer classId = individualClass.getId();
            try {
                classRepository.findById(classId);
            } catch (Exception e) {
                LOGGER.error("appName: School App Demo || Critical Error retrieving individual classes");
            }
        }
    }
}
