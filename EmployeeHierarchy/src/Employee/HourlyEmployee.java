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
public class HourlyEmployee extends Employee
{
    private double hourlyWage;//wage
    private double hoursWorked;//amount of hours employee worked
    public double overtime = 40;//set amount of hours to work until payed overtime (time and a half)
    
    //five argument constructor
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hourlyWage, double hoursWorked)
    {
        super(firstName, lastName, socialSecurityNumber);
        
        //if hourlywage is invalid throw exception
        if (hourlyWage <= 0.0)
            throw new IllegalArgumentException("Hourly wage must be > 0.0");
        
        this.hourlyWage = hourlyWage;
        
        //if hoursWorked is invalid throw exception
        if (hoursWorked < 1.0 || hoursWorked >= 168.0)
            throw new IllegalArgumentException("Hours worked must be >= 1.0 and < 168.0");
        
        this.hoursWorked = hoursWorked;
    }//end constructor
    
    //set hourlywage amount
    public void setHourlyWage(double hourlyWage)
    {
        if (hourlyWage <= 0.0)
            throw new IllegalArgumentException("Hourly wage must be > 0.0");
        
        this.hourlyWage = hourlyWage;
    }
    
    // set hoursworked
    public void setHoursWorked(double hoursWorked)
    {
        if (hoursWorked < 1.0 || hoursWorked >= 168.0)
            throw new IllegalArgumentException("Hours worked must be >= 1.0 and < 168.0");
        
        this.hoursWorked = hoursWorked;
    }
    
    //return hourly wage
    public double getHourlyWage()
    {
        return hourlyWage;
    }
    
    //return hours worked
    public double getHoursWorked()
    {
        return hoursWorked;
    }
    
    //calculate earnings
    public double earnings()
    {
        if (hoursWorked > overtime)
        {
            return (overtime * getHourlyWage() + ((getHoursWorked() - overtime) * (1.5 * getHourlyWage())));
        }
        else
        {
            return getHourlyWage() * getHoursWorked();
        }
            
    }//end calculate earnings
    
    @Override
    public String toString()
    {
        return String.format(("%s %s\n\t%s: %.2f\n\t%s: %.2f\n\t%s: $%.2f\n"), "Hourly", super.toString(), "Hourly Wage", getHourlyWage(), "Hours Worked", getHoursWorked(), "Earnings", earnings());
    }
}//end subclass HourlyEmployee
