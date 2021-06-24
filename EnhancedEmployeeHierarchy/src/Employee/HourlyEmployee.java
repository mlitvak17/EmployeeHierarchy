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
{//begin subclass HourlyEmployee
    
    //initialization of variables
    private double hourlyWage;//wage
    private double hoursWorked;//amount of hours employee worked
    public double overtime = 40;//set amount of hours to work until payed overtime (time and a half)
    //end initialization of variables
    
    //five-argument constructor
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
    }//end five-argument constructor
    
    //set hourlywage amount
    public void setHourlyWage(double hourlyWage)
    {
        if (hourlyWage <= 0.0)
            throw new IllegalArgumentException("Hourly wage must be > 0.0");
        
        this.hourlyWage = hourlyWage;
    }//end setHourlyWage
    
    // set hoursworked
    public void setHoursWorked(double hoursWorked)
    {
        if (hoursWorked < 1.0 || hoursWorked >= 168.0)
            throw new IllegalArgumentException("Hours worked must be >= 1.0 and < 168.0");
        
        this.hoursWorked = hoursWorked;
    }//end setHoursWorked
    
    //return hourly wage
    public double getHourlyWage()
    {
        return hourlyWage;
    }//end getHourlyWage()
    
    //return hours worked
    public double getHoursWorked()
    {
        return hoursWorked;
    }//end getHoursWorked()
    
    //calculate earnings
    @Override
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
    }//end earnings()
    
    //calculate raise amount
    @Override
    public void raise(double percent)//increase the hourly wage by the percent specified
    {
        setHourlyWage((1.00 + percent) * getHourlyWage());
    }//end calculate raise amount
    
    @Override
    public String toString()
    {
        return String.format(("%s %s\n\t%s: %.2f\n\t%s: %.2f\n\t%s: $%.2f\n"),
                "Hourly", super.toString(),
                "Hourly Wage", getHourlyWage(),
                "Hours Worked", getHoursWorked(),
                "Earnings", earnings());
    }//end toString()
    
}//end subclass HourlyEmployee
