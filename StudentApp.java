import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

    static ArrayList<Student> students = FileManager.loadStudents();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);

        students.add(student);

        FileManager.saveStudents(students);

        System.out.println("Student Added Successfully.");
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());

                FileManager.saveStudents(students);

                System.out.println("Student Updated Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}