package com.mycompany.property_management.Service.impl;

import com.mycompany.property_management.Converter.PropertyConverter;
import com.mycompany.property_management.Entity.PropertyEntity;
import com.mycompany.property_management.Repository.PropertyRepository;
import com.mycompany.property_management.Service.PropertyService;
import com.mycompany.property_management.dto.PropertyDTO;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mycompany.property_management.Repository.PropertyRepository.*;

@Service
public class PropertyServiceImpl implements PropertyService {
    private ClassValue<Object> OptEn;

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =PropertyRepository.findById(propertyId);
        if(optEn.isPresent()){
           PropertyEntity pe =optEn.get(); // data from databasee
           pe.setTitle(propertyDTO.getTitle());
           pe.setAddress(propertyDTO.getAddress());  //Adapter Design pattern (converting Dto to the entity vise versa)
           pe.setOwnerEmail(propertyDTO.getOwnerEmail());
           pe.setOwnerName(propertyDTO.getOwnerName());
           pe.setPrice(propertyDTO.getPrice());
           pe.setDescription(propertyDTO.getDescription());


           propertyRepository.save(pe);

       }
        return dto;
    }

    @Override
    public   PropertyDTO UpdatePropertyDescription(PropertyDTO propertyDTO , Long propertyId){

        Optional<PropertyEntity> optEn =PropertyRepository.findById(propertyId);
        if(optEn.isPresent()){
            PropertyEntity pe =optEn.get(); // data from databasee

            pe.setDescription(propertyDTO.getDescription());


            propertyRepository.save(pe);

        }
        return dto;

    }

    @Override
    public void deleteProperty(Long PropertyId) {
      propertyRepository.deleteById(propertyId);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
       List<PropertyEntity> ListOfProps=(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
       for(PropertyEntity pe :ListOfProps){
          PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
           propList.add(dto);
       }
        return propList;
    }

    @Autowired
    private PropertyRepository propertyRepository;
     @Autowired

     private PropertyConverter propertyConverter;


    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

       PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

      pe=   propertyRepository.save(pe);

        propertyDTO  =PropertyConverter.convertEnitiyToDTO(pe);

        return propertyDTO;
    }
}
