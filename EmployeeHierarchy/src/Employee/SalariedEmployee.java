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
public class SalariedEmployee extends Employee
{
    private double salary;
    
    
    //four-argument constructor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double salary)
    {
        //explicit call to superclass employee constructor
        super(firstName, lastName, socialSecurityNumber);
     
        //if salary is invalid throw exception
        if (salary <= 0.0)
            throw new IllegalArgumentException("Salary must be > 0.0");
        
        this.salary = salary;
    }//end constructor
    
    //set salary amount
    public void setSalary(double salary)
    {
        if (salary <= 0.0)
            throw new IllegalArgumentException("Salary must be > 0.0");
        
        this.salary = salary;
    }
    
    //return salary amount
    public double getSalary()
    {
        return salary;
    }
    
    //calculate earnings
    public double earnings()
    {
        return getSalary();
    }
    
    //returning String reporesentation of SalariedEmployee
    @Override
    public String toString()
    {
        return String.format(("%s %s\n\t%s: %.2f\n\t%s: $%.2f\n"), "Salaried", super.toString(), "Salary", getSalary(), "Earnings", getSalary());
    }
}//end subclass salaried employee
