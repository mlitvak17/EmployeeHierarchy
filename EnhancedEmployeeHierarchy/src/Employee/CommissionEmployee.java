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
public class CommissionEmployee extends Employee
{
    private double grossSales;//gross weekly sales
    private double commissionRate;//commission percentage
    
    //five-argument constructor
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate)
    {
        //explicit call to superclass Employee constructor
        super(firstName, lastName, socialSecurityNumber);
        
        //if grossSales is invalid throw exception
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >=0.0");
        
        
        //if commissionRate is invalid throw exception
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.00");
        
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }//end constructor
    
    //set gross sales amount
    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        
        this.grossSales = grossSales;
    }//end setGrossSales
    
    //return gross sales amount
    public double getGrossSales()
    {
        return grossSales;
    }//end getGrossSales()
    
    //set commission rate
    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate > 1.00)
            throw new IllegalArgumentException("Commission rate msut be > 0.0 and < 1.00");
        
        this.commissionRate = commissionRate;
    }//end setCommissionRate
    
    //return commission rate
    public double getCommissionRate()
    {
        return commissionRate;
    }//end getcommissionRate()
    
    //calculate earnings
    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }//end earnings()
    
    //calculate raise amount
    @Override
    public void raise(double percent)//increase commission rate by percent specified
    {
        setCommissionRate((1.00 + percent) * getCommissionRate());
    }//end calculate raise amount
    
    //return String representation of CommissionedEmployee object
    @Override
    public String toString()
    {
            return String.format(("%s %s\n\t%s: %.2f\n\t%s: %.4f\n\t%s: $%.2f\n"),
                    "Commissioned", super.toString(),
                    "Gross Sales", getGrossSales(),
                    "Commission Rate", getCommissionRate(),
                    "Earnings", earnings());
    }//end toString()
            
}// end subclass CommissionedEmployee
