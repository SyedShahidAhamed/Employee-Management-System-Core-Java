
package main;
import auth.LoginService;
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
        LoginService Login = new LoginService();
        Employee emp;
        //Login Service
        int Login_attemps =3;
        while(Login_attemps > 0)
        {          System.out.println();
            System.out.println("=======================================");
                System.out.println("EMPLOYEE MANAGEMENT LOGIN SYSTEM");
                System.out.println("=======================================");
                System.out.println();
                System.out.println("Enter USERNAME:");
                
                String username = sc.next();
                System.out.println("Enter PASSWORD:");
                String password = sc.next();
                //if login attempt succesfull
                if(Login.login(username, password))
                {
                        System.out.println("Login successfull..");
                        break;
                }
                Login_attemps--;
                System.out.println("Invalid Credentials.");
                if(Login_attemps>0)
                {
                     System.out.println("Attempts Left:"+Login_attemps);
                }
                
        }
              if(Login_attemps == 0)
                {
                        System.out.println("To many atempts failed ");
                        return;
                }
        
        boolean running = true;
        while(running)
        {     
             System.out.println();
                System.out.println("=====================================");
                System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("=====================================");
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
                             System.out.println();
                            break;
                    
                    case 2:   System.out.println("Displaying all Employees Of Company:");
                             service.viewEmployees();
                              System.out.println();
                              break;
                     
                    case 3: System.out.println("Enter EmployeeId To Search:"); 
                            int emp_id = sc.nextInt();
                             Optional<Employee> employ =service.searchEmployee(emp_id);
                                    if (employ.isPresent()) {
                                        System.out.println("Employee Details:");
                                        System.out.println("Id:"+" "+employ.get().getId());
                                        System.out.println("Name:"+" "+employ.get().getName());
                                        System.out.println("Age:"+" "+employ.get().getAge());
                                        System.out.println("Department:"+" "+employ.get().getDepartment());
                                        System.out.println("Salary:"+" "+employ.get().getSalary());
                                         System.out.println();
                                    } else {
                                        System.out.println("Employee not found.");
                                         System.out.println();
                                    }  

                                     break;  
                            
                    case 4: System.out.println("Enter employeeId:");
                            int changesalary_id = sc.nextInt();
                            System.out.println("Enter the Updated Salary:");
                            double update_salary = sc.nextDouble();
                            service.updateSalary(changesalary_id, update_salary);
                             System.out.println();
                            break; 

                    case 5: System.out.println("Enter EmployeeId To Be Deleted:"); 
                              int del_empid =sc.nextInt();
                              service.deleteEmployee(del_empid);
                               System.out.println();
                              break; 

                   case 6:  System.out.println("Sorting Salaries");
                            service.sortBySalary();
                             System.out.println();
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
