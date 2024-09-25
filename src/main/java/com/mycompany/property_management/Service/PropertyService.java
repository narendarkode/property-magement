package com.mycompany.property_management.Service;

import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List <PropertyDTO> getAllProperties();
  PropertyDTO  updateProperty(PropertyDTO propertyDTO , Long propertyId );
    PropertyDTO UpdatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyId);
   void deleteProperty(Long PropertyId);

}
