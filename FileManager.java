import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



class FileManager {

    public static void saveStudents(ArrayList<Student>Students){
        try {
            FileWriter writer = new FileWriter("Students.txt");
            for (Student s: Students){
            writer.write(s.toString());
            writer.write("\n");
            
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("error while saving student");
        }
    }
     // Load all students from file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("Students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                Student s = new Student(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2]));

                students.add(s);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }

        return students;
    }
}
    
