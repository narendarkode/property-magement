package com.mycompany.property_management.controller;


import com.mycompany.property_management.Service.PropertyService;
import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pmsdb-dev}")
    public String dummy;
   @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String Hello(){
        return  "Hello" ;
    }

   @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){

       propertyDTO= propertyService.saveProperty(propertyDTO);

       ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
       return responseEntity.getBody() ;
   }


   @GetMapping("/properties1")
   public ResponseEntity<List<PropertyDTO>> getAllProperties() {
       System.out.println(dummy);
       List<PropertyDTO> propertyList = propertyService.getAllProperties();
       ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);

       return responseEntity;
   }

   @PutMapping("/Properties3/{propertyId}")
  public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId){
        propertyService.updateProperty(propertyDTO, propertyId);

       ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
       return responseEntity ;

  }

   @PatchMapping("//Properties4/update-description/{propertyId}")
  public ResponseEntity<PropertyDTO> UpdatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
       propertyDTO= propertyService.saveProperty(propertyDTO);

       ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(propertyDTO, HttpStatus.OK);
       return responseEntity;


  }
  @DeleteMapping("/Properties8/{propertyId}")
  public ResponseEntity delete(@PathVariable Long propertyId){
        PropertyService.deleteRepository(propertyId);
      ResponseEntity<Void> responseEntity= new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
      return ResponseEntity;

  }

}
