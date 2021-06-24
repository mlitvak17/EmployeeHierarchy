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
public abstract class Employee
{//begin class Employee

    //begin initialization of variables
    private final String firstName;//first name of employee
    private final String lastName;//last name of employee
    private final String socialSecurityNumber;//social security number of employee
    //end initialization of variables
    
    //three-argument constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        //establish a link b/w initialization variables and variables inside constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }//end constructor
    
    //return first name
    public String getFirstName()
    {            
        return firstName;
    }//end getFirstName
    
    //return last name
    public String getLastName()
    {
        return lastName;
    }//end getLastName
    
    //return social security number
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }//end getSocialSecurityNumber()
 
    //begin toString method
    @Override//toString exists in defalut java library (overriding is proper Object oriented programming)
    public String toString()//return String representation of Employee object
    {
        return String.format(("%s: %s %s %s: %s"),
                "Employee", getFirstName(), getLastName(),
                "with ssn", getSocialSecurityNumber());
    }//end toString() method
    
    //abstract method must be overriden by concrete subclass
    public abstract double earnings(); //no implementation here
    
    //abstract method must be overriden by concrete subclass
    public abstract void raise(double percent);//no implimentation here
    
    //main function
    public static void main(String[] args)
    {
        CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);
        SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        System.out.printf("%s\n%s%s%s%s%s\n","Employee information.", employee1, employee2, employee3, employee4, employee5);
        
        //create five-element Employee array
        Employee[] employees = new Employee[5];
        
        //initialize array with employees
        employees[0] = employee1;//commission employee
        employees[1] = employee2;//base plus commission employee
        employees[2] = employee3;//salaried employee
        employees[3] = employee4;//hourly employee
        employees[4] = employee5;//hourly employee 2
        
        System.out.printf("Employee information after raises.\n");//introduces values in output that will be printed next
                
        //generically process each element in array employees
        for (Employee currentEmployee : employees)
        {
            
            //determien whether current employee is instance of BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee)
            {
                //downcast currentEmployee reference to BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                
                //call the 'raise' method
                employee.raise(0.02);
            }//end if determination for CommissionEmployee (includes instance of BasePlusCommissionEmployee)
            
            //determine whether currentEmployee is instance of CommissionEmployee
            else if (currentEmployee instanceof CommissionEmployee)
            {
                currentEmployee.raise(0.02);
            }//end else if statement
            
            
            //determine whether currentEmployee is a SalariedEmployee
            else if (currentEmployee instanceof SalariedEmployee)
            {
                currentEmployee.raise(0.04);
            }//end else if determination for SalariedEmployee
            
            //determine whether currentEmploye is a HourlyEmployee
            else if (currentEmployee instanceof HourlyEmployee)
            {
                currentEmployee.raise(0.02);
            }//end else if determination for HourlyEmployee
            
            //error check if type of employee doesn't exist
            else
            {
                System.out.println("This type of employee does not exist");
            }//end else statement
            
        System.out.printf("%s", currentEmployee);//invokes toString method    
        
        }//end of for loop
        
    }//end main function
    
}//end abstract class Employee
