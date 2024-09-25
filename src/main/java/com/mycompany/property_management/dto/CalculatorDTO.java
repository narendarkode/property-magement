package com.mycompany.property_management.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


public class CalculatorDTO {

    private static Double num1;
    private static Double num2;
    private static Double num3;
    private Double num4;

    public static Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum4() {
        return num4;
    }

    public void setNum4(Double num4) {
        this.num4 = num4;
    }

    public static Double getNum3() {
        return num3;
    }

    public void setNum3(Double num3) {
        this.num3 = num3;
    }

    public static Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }
}
