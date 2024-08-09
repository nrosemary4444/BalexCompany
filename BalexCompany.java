/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu_coursework.balexcompany;

/**
 *
 * @author Hp
 */
import java.util.Scanner;
public class BalexCompany {
    //method to calculate the total pay of an employee
    public void calculatePay(double basePay, double hoursWorked) {
        //constants
        final double MINIMUM_WAGE = 8.00;
        final double OVERTIME_RATE = 1.5;
        final double REGULAR_HOURS = 40;
        final double MAXIMUM_HOURS = 60;
        
        //Checking if base pay is below minimum wage
        if (basePay < MINIMUM_WAGE) {
            System.out.println("Error: Base pay is less than the minimum wage of $" + MINIMUM_WAGE + " " + " per hour.");
            return;
        }
        
        //checking if hours worked exceed the maximum hours allowed
        if (hoursWorked > MAXIMUM_HOURS) {
            System.out.println("Error: The number of hours worked is above maximum hours of working" + MAXIMUM_HOURS + " " + "hours");
            return;
        }
        
        //calculate regular and overtime pay
        double regularPay = Math.min(hoursWorked, REGULAR_HOURS) * basePay;
        double overtimePay = (hoursWorked > REGULAR_HOURS)?  ( hoursWorked - REGULAR_HOURS) * basePay * OVERTIME_RATE :0;
        
        //Calculate total pay
        double totalPay = regularPay + overtimePay;
        //output the total pay
        System.out.printf("Total pay: $%.2f%n", totalPay);
    }

    // method to process predefined employees
    public void processPredefinedEmployees() {
        double[][] predefinedEmployees = {
            {7.50, 35},//employee 1
            {8.20, 47},//employee 2
            {10.00, 73}//employee 3
};
for (int i = 0; i < predefinedEmployees.length; i++){
    System.out.println("Predefined employee" + (i + 1) + ":");
    calculatePay(predefinedEmployees[i][0], predefinedEmployees[i][1]);
    System.out.println();
        }       
    }

    //main method to prompt user input and calcuate pay for multiple employees
    public static void main(String[] args) {
            BalexCompany balexCompany = new BalexCompany();
            //Process predefined employees
            balexCompany.processPredefinedEmployees();
            
        try ( //prompt for new employees
                Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    
                    //prompt user for base pay and hours worked
                    System.out.print("Enter base pay for the employee: ");
                    double basePay = scanner.nextDouble();
                    System.out.print("Enter hours worked for the employee: ");
                    double hoursWorked = scanner.nextDouble();
                    
                    //calculate and display total pay
                    balexCompany.calculatePay(basePay, hoursWorked);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter valid numbers.");
                    scanner.nextLine(); //clear the buffer
                }
                
                //ask if the user wants to enter another employee's details
                System.out.println("Do you want another employee? (yes/no): ");
                scanner.nextLine(); //consume newline
                String response = scanner.nextLine();
                if (! response.equalsIgnoreCase("yes")
                        ) {
                    break;
                }
                
            }
            scanner.close();
        }
    }
}

