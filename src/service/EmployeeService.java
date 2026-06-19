package service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import model.Employee;
public class EmployeeService {
    //No other class should directly modify the employee list by importing...
    private ArrayList<Employee> employees = new ArrayList<>();
    //add
    public void addEmployee(Employee employee)
    {    int id = employee.getId();
        Optional<Employee> emp = searchEmployee(id);
        if(emp.isPresent())
        {
            System.out.println("Employee"+" "+id +" "+"Already Exist.");
            return;
        }
         if(employees!=null){
        employees.add(employee);
        System.out.println("Employee added sucessfully.");
         }
         else{
            System.out.println("Enter valid details.");
         }
    }
    //view
    public void viewEmployees()
    {
        if(employees.isEmpty())
        {
            System.out.println("No employees found.");
            return ;
        }
            for(Employee emp : employees)
            {
                System.out.println(emp);
            }
        
    }
    //search->optimal->helps avoid NullPointerException if employee not found
    public Optional<Employee> searchEmployee(int id)
    {
      return employees.stream()
                      .filter(emp -> emp.getId() == id)
                      .findFirst();  
      
    }
    public boolean deleteEmployee(int id)
    {   
        Optional<Employee> employee = searchEmployee(id);
        employee.ifPresent(employees::remove);
        if(employee.isPresent())
        {
            System.out.println("Employee deleted successfully.");
            return true;
        }
        System.out.println("Employee Not Found..");
        return false;
    }
    public boolean updateSalary(int id, double newSalary)
    {
        Optional<Employee>employee = searchEmployee(id);
        
         if(employee.isPresent())
         {
            //employee.ifPresent(emp -> emp.setSalary(newSalary));
            employee.get().setSalary(newSalary);
            System.out.println("Salary updated successfully.");
            return true;
         }
         System.out.println("Employee not found.");
        return false;
    }
    public void sortBySalary()
    {
       employees.sort( Comparator.comparing(Employee::getSalary));
        System.out.println("Employees sorted successfully.");
    }
    public ArrayList<Employee> getEmployees() 
    {
        return employees;
   }
    public void setEmployees(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }
}
