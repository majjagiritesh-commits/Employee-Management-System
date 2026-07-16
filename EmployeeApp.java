import java.util.*;
public class EmployeeApp {
    static ArrayList<Employee> employees= new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. ADD EMPLOYEE");
             System.out.println("2.VIEW EMPLOYEE");
              System.out.println("3.SEARCH EMPLOYEE");
               System.out.println("4.UPDATE EMPLOYEE");
                System.out.println("5. EXIT");
        
    int choice =sc.nextInt();

    switch (choice) {
       case 1-> addEmployee();
       case 2-> ViewEmployee();
       case 3-> SearchEmployee();
       case 4-> updateDepartment();
       case 5-> System.exit(0 );
       
    }
        }
    }

    static void addEmployee(){
        System.out.println("ID:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("name:");
        String name=sc.nextLine();
        System.out.println("department:");
        String dept=sc.nextLine();
        employees.add(new Employee(id,name,dept));
        System.out.println("employee added successfuly");

    }

    static void ViewEmployee(){
        for (Employee e : employees) {
            System.out.println(e.id+"|"+e.name+"|"+e.department);

            
        }
    }
    static void SearchEmployee(){
        System.out.println("enter:ID");
        int id=sc.nextInt();
        for (Employee e : employees) {
            if(e.id==id){
                System.out.println("Found"+e.name+"("+e.department+")");
                return;
            }
            
        }
        System.out.println("Employee not found ");
    }
    
    static void updateDepartment(){
        System.out.println("ID:");
        int id=sc.nextInt();
        sc.nextLine();

        for (Employee e : employees) {
            if (e.id==id){
                System.out.println("new department");
                e.department=sc.nextLine();
                System.out.println("department ypdated succesfully");
                return;

            }
        }
        System.out.println("employee not found");
        
    }
}
