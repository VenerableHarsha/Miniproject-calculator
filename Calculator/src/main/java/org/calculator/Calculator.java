package org.calculator;
import java.util.*;
public class Calculator{
    public static double add(double a, double b){
        return a+b;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int option;
        double a,b;
        while(true){
            System.out.println("Calculator choose your operation: ");
            System.out.println("1. Add");
            System.out.println("9. Exit");

            System.out.println("Enter your choice :");
            option = s.nextInt();

        switch(option){
            case 1 :
                System.out.println("Enter any 2 numbers");
                a=s.nextDouble();
                b=s.nextDouble();
                System.out.println("Result of sum of "+ a+ b+"=");
                System.out.println(add(a,b));

            case 9:
                System.out.println("Exiting the calculator");
                s.close();
                break;



            default:
                System.out.println("Wrong choice try again");
                continue;


        }


        }

    }

}