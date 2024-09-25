package com.mycompany.property_management.controller;

import javax.sound.midi.Soundbank;

public class CalculatorMain {


    public  static  void main(String[] args){

        CalculatorController  cc =new CalculatorController();
        Integer result =cc.add(400, 800) ;

        System.out.println(result);
    }
}
