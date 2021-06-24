/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

/**
 *
 * @author MauriLitvak
 */
public class Employee
{//begin class Employee

    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    //three-argument constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }//end constructor
    
    //return first name
    public String getFirstName()
    {            
        return firstName;
    }
    
    //return last name
    public String getLastName()
    {
        return lastName;
    }
    
    //return social security number
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }
 
    //return String representation of Employee object
    public String toString()
    {
        return String.format(("%s: %s %s %s: %s"), "Employee", getFirstName(), getLastName(), "with ssn", getSocialSecurityNumber());
    }
    
    //main function
    public static void main(String[] args)
    {
        CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);
        SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        System.out.printf("%s%s%s%s%s", employee1, employee2, employee3, employee4, employee5);
    }//end main function

}//end class Employee
