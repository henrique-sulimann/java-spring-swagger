package com.hsulimann.henrique.validators.existsById;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByIdValidator implements ConstraintValidator<ExistsById, Object>{

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsById params){
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = this.manager.createQuery("SELECT 1 FROM " + this.klass.getName() + " WHERE " + this.domainAttribute + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        if(list.isEmpty()){
            return false;
        }
        return true;
    }

}

