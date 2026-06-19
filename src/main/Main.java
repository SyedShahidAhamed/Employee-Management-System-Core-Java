
package main;
import java.util.Optional;
import java.util.Scanner;
import model.Employee;
import service.EmployeeService;
import util.FileManager;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        FileManager fileManager = new FileManager();
        Employee emp;
                
        boolean running = true;
        while(running)
        { 
            System.out.println("====================================");
                System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("====================================");
                System.out.println();
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Update Salary");
                System.out.println("5. Delete Employee");
                System.out.println("6. Sort By Salary");
                System.out.println("7. Save Employees");
                System.out.println("8. Load Employees");
                System.out.println("9. Exit");
                System.out.println();
                System.out.print("Enter Choice: ");

                 int choice = sc.nextInt();
                switch(choice)
                {
                   case 1 : System.out.println("Enter Id:");
                            int id = sc.nextInt();
                            System.out.println("Enter Name:");
                            sc.nextLine();
                            String name = sc.next();
                            System.out.println("Enter Age:");
                            int age = sc.nextInt();
                            System.out.println("Enter Department:");
                            String department = sc.next();
                            System.out.println("Enter Salary:");
                            double salary = sc.nextDouble();
                            emp = new Employee(id,name,age,department,salary);
                            service.addEmployee(emp);
                            break;
                    
                    case 2:   System.out.println("Displaying all Employees Of Company:");
                             service.viewEmployees();
                              break;
                     
                    case 3: System.out.println("Enter EmployeeId To Search:"); 
                            int emp_id = sc.nextInt();
                             Optional<Employee> employ =service.searchEmployee(emp_id);
                                    if (employ.isPresent()) {
                                        System.out.println(employ.get());
                                    } else {
                                        System.out.println("Employee not found.");
                                    }  
                                     break;  
                            
                    case 4: System.out.println("Enter employeeId:");
                            int changesalary_id = sc.nextInt();
                            System.out.println("Enter the Updated Salary:");
                            double update_salary = sc.nextDouble();
                            service.updateSalary(changesalary_id, update_salary);
                            break; 

                    case 5: System.out.println("Enter EmployeeId To Be Deleted:"); 
                              int del_empid =sc.nextInt();
                              service.deleteEmployee(del_empid);
                              break; 

                   case 6:  System.out.println("Sorting Salaries");
                            service.sortBySalary();
                            break; 

                    case 7: System.out.println("Saving the Employees Data");
                             fileManager.saveEmployees(service.getEmployees());
                             break; 

                    case 8: System.out.println("Loading the Employees Data.");
                             service.setEmployees(fileManager.loadEmployees());
                            break; 
                            
                    case 9: System.out.println("Thank You...");
                            running = false;    
                            break;
                    
                    default:
                             System.out.println("Invalid Choice!");
                            break;
                }
        }
         
    }
}
