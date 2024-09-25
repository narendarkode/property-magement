package com.mycompany.property_management.Converter;


import com.mycompany.property_management.Entity.PropertyEntity;
import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());  //Adapter Design pattern (converting Dto to the entity vise versa)
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());
        pe.setDescription(propertyDTO.getDescription());
        return pe;

    }

    public static PropertyDTO convertEnitiyToDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());  //Adapter Design pattern (converting Dto to the entity vise versa)
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setDescription(propertyEntity.getDescription());


        return propertyDTO;


    }

    public PropertyDTO convertEntityToDTO(PropertyEntity pe) {
        return null;
    }
}

