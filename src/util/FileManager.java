package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Employee;
public class FileManager {
   
         public void saveEmployees(ArrayList<Employee> employees)
         {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser")))
            {
                    oos.writeObject(employees);
                    System.out.println("Saved Employee data.");
            }catch(IOException e)
            {
                e.printStackTrace();
            }
         }
         public ArrayList<Employee> loadEmployees()
         {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser")))
                {
                    System.out.println("Employess loaded sucessfully.");
                  return (ArrayList<Employee>) ois.readObject();
                }catch(IOException | ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
                return new ArrayList<>();
         }

          
}
