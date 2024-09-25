package com.mycompany.property_management.controller;


import com.mycompany.property_management.dto.CalculatorDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // class level mapping to  url to a controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    @GetMapping("/add") //method level mapping to a url to a controller functions
    public Integer add(@RequestParam("num123") Integer num1, @RequestParam("num2") Integer num2){

        return num1+num2;

    }


   /* @GetMapping("/sub/{num1}/{num2}") //Map the values od variable with path variable
    public Double Substract(){


        public Integer  sub(@PathVariable("num1") Integer  num1, @PathVariable("num2") Integer num2){
            Integer result =null;

            if(num1>num2){
                result = num1-num2;

            }else{
                result= num2 - num1;


            }
            return result;

        }
*/
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody  CalculatorDTO calculatorDTO){
        Double result= null;
        result = CalculatorDTO.getNum1() *CalculatorDTO.getNum2()*CalculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity= new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;


    }



    }



