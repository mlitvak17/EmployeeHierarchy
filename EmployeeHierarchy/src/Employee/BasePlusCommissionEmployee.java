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
public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;//base salary per week
    
    //six-argument constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary)
    {
        //explicit call to superclass CommissionEmployee constructor
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        
        //if baseSalary is invalid throw exception
        if (baseSalary <= 0.0)
            throw new IllegalArgumentException("Base salary must be > 0.0");
        
        this.baseSalary = baseSalary;
    }//end constructor
    
    //set base salary amount
    public void setBaseSalary(double baseSalary)
    {
        if (baseSalary <= 0.0)
            throw new IllegalArgumentException("Base salary must be > 0.0");
        
        this.baseSalary = baseSalary;
    }
    
    //return base salary
    public double getBaseSalary()
    {
        return baseSalary;
    }
    
    //calculate earnings
    @Override
    public double earnings()
    {
        return getBaseSalary() + super.earnings();
    }
    
    //returning String representation of BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format(("%s: %s %s %s: %s\n\t%s: %.2f\n\t%s: %.2f\n\t%s: $%.2f\n\t%s: $%.2f\n"), "Base Salary Plus Commission Employee",getFirstName(), getLastName(), "with ssn",getSocialSecurityNumber(),"Gross Sales", getGrossSales(), "Commission Rate", getCommissionRate(), "with Base Salary of", getBaseSalary(), "Earnings", earnings());
    }
    
}//end subclass BasePlusCommissionEmployee
