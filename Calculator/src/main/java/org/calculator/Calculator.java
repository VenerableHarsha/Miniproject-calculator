package org.calculator;
import java.util.*;
public class Calculator {
//test comment
        public static double add(double a, double b){
            return a + b;
        }

        public static double sub(double a, double b){
            return a - b;
        }

        public static double mul(double a, double b){
            return a * b;
        }

        public static double div(double a, double b){
            return a / b;
        }

        public static double sqrroot(double a){
            return Math.sqrt(a);
        }

        public static double power(double a, double b){
            return Math.pow(a,b);
        }

        public static double natlog(double a){
            return Math.log(a);
        }

        public static long factorial(int a){
            if(a < 0){
                throw new IllegalArgumentException("Factorial not defined for negative numbers");
            }

            if(a <= 1){
                return 1;
            }

            return a * factorial(a - 1);
        }

        public static void main(String[] args){

            Scanner s = new Scanner(System.in);
            int option;
            double a,b;

            while(true){

                System.out.println("\nCalculator choose your operation:");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Square Root");
                System.out.println("6. Power");
                System.out.println("7. Natural Log");
                System.out.println("8. Factorial");
                System.out.println("9. Exit");

                System.out.print("Enter your choice: ");
                option = s.nextInt();

                switch(option){

                    case 1:
                        System.out.println("Enter two numbers:");
                        a = s.nextDouble();
                        b = s.nextDouble();
                        System.out.println("Result = " + add(a,b));
                        break;

                    case 2:
                        System.out.println("Enter two numbers:");
                        a = s.nextDouble();
                        b = s.nextDouble();
                        System.out.println("Result = " + sub(a,b));
                        break;

                    case 3:
                        System.out.println("Enter two numbers:");
                        a = s.nextDouble();
                        b = s.nextDouble();
                        System.out.println("Result = " + mul(a,b));
                        break;

                    case 4:
                        System.out.println("Enter two numbers:");
                        a = s.nextDouble();
                        b = s.nextDouble();
                        System.out.println("Result = " + div(a,b));
                        break;

                    case 5:
                        System.out.println("Enter a number:");
                        a = s.nextDouble();
                        System.out.println("Result = " + sqrroot(a));
                        break;

                    case 6:
                        System.out.println("Enter base and exponent:");
                        a = s.nextDouble();
                        b = s.nextDouble();
                        System.out.println("Result = " + power(a,b));
                        break;

                    case 7:
                        System.out.println("Enter a number:");
                        a = s.nextDouble();
                        System.out.println("Result = " + natlog(a));
                        break;

                    case 8:
                        System.out.println("Enter an integer:");
                        int n = s.nextInt();
                        System.out.println("Result = " + factorial(n));
                        break;

                    case 9:
                        System.out.println("Exiting calculator...");
                        s.close();
                        return;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }