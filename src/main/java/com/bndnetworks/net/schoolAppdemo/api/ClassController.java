package com.bndnetworks.net.schoolAppdemo.api;

import com.bndnetworks.net.schoolAppdemo.classes.entity.ClassEntity;
import com.bndnetworks.net.schoolAppdemo.classes.repository.ClassRepository;
import com.bndnetworks.net.schoolAppdemo.model.Classe;
import org.json.simple.JSONObject;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/v1/classes", produces = "application/json")
@RestController
public class ClassController {

    @Autowired
    private ClassRepository classRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassController.class);


    @GetMapping
    public JSONObject getAllClasses() throws JSONException {
        JSONObject response = new JSONObject();
        try {
            List<ClassEntity> classesList = classRepo.findAllBy();
            List<Classe> classes = new ArrayList<>();

            if (!classesList.isEmpty() || null != classesList) {
                for (ClassEntity classe : classesList) {
                    Classe class1 = new Classe();
                    class1.setClassID(classe.getId());
                    class1.setClassName(classe.getClassName());
                    class1.setPension(classe.getSchoolFee());
                    class1.setInscription(classe.getSubscription());
                    class1.setFirstPayment(classe.getFirstPayment());
                    class1.setSecondPayment(classe.getSecondPayment());
                    class1.setThirdPayment(classe.getThirdPayment());
                    class1.setExamFees(classe.getExamFees());
                    classes.add(class1);
                }
            }
            LOGGER.info("Retrieved " + classesList.size() + " rows from the class table.");
            response.put("response", classes);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return response;
    }

    @GetMapping("/{id}")
    public JSONObject getClassById(@PathVariable("id") Integer classId){
        JSONObject response = new JSONObject();
        try{
           Optional<ClassEntity> classEntity  = classRepo.findById(classId);
           if(null != classEntity){
               response.put("response", classEntity);
           }
        }
        catch (Exception e){
            LOGGER.error(e.getMessage());
        }

        return response;
    }
}
