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
{//begin subclass SalariedEmployee
    
    //initialization of variables
    private double salary;
    //end initialization of variables
    
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
    }//end setSalary
    
    //return salary amount
    public double getSalary()
    {
        return salary;
    }//end getSalary()
    
    //calculate earnings
    @Override
    public double earnings()
    {
        return getSalary();
    }//end earnings()
    
    //calculate raise amount
    @Override
    public void raise(double percent)//increase the hourly wage by percent specified
    {
        setSalary((1.00 + percent) * getSalary());
    }//end calculate raise amount
    
    //returning String reporesentation of SalariedEmployee
    @Override
    public String toString()
    {
        return String.format(("%s %s\n\t%s: %.2f\n\t%s: $%.2f\n"),
                "Salaried", super.toString(),
                "Salary", getSalary(),
                "Earnings", getSalary());
    }//end toString()
    
}//end subclass salaried employee
