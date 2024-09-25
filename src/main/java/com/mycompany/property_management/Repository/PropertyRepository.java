package com.mycompany.property_management.Repository;

import com.mycompany.property_management.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropertyRepository  extends CrudRepository<PropertyEntity, Long>  {

}
