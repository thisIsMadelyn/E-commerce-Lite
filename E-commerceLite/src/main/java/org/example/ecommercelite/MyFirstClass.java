package org.example.ecommercelite;

public class MyFirstClass {

//    this is my first class to use for testing

//    this is going to work as a calculator

    public int add(int ...numbers){
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
