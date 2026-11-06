import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentManager implements StudentOperations {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();

    public boolean isIdExists(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addStudent(Student student) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == student.getId()) {
                System.out.println("Student ID already exists.");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    @Override
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            students.get(i).displayDetails();
        }
    }

    @Override
    public void searchStudent(int id) {

        for (int i = 0; i < students.size(); i++){
            if(id==students.get(i).getId()){
                students.get(i).displayDetails();
                return;
            }

        }
        System.out.println("Student not found.");
    }


    @Override
    public void updateStudent(int id) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {

                System.out.println("1. update name .");
                System.out.println("2. update Age .");
                System.out.println("3. update Marks .");
                System.out.println("4. update All Details .");

                System.out.println("Enter choice:");
                int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        String updatedName;

                        do {
                            System.out.println("Enter new name:");
                            updatedName = sc.next();

                            if (!updatedName.matches("[a-zA-Z]+")) {
                                System.out.println("Invalid name! Use letters only.");
                            }

                        } while (!updatedName.matches("[a-zA-Z]+"));

                        students.get(i).setName(updatedName);
                        System.out.println("Student name updated successfully.");
                        break;
                    case 2:
                        int age;

                        while (true) {
                            try {
                                System.out.println("Enter new Age:");
                                age = sc.nextInt();

                                if (age > 0) {
                                    break;
                                }

                                System.out.println("Age must be greater than 0.");

                            } catch (InputMismatchException e) {
                                System.out.println("Invalid age! Enter numbers only.");
                                sc.next();
                            }
                        }

                        students.get(i).setAge(age);
                        System.out.println("Student Age updated successfully.");
                        break;
                    case 3:
                        int marks;

                        while (true) {
                            try {
                                System.out.println("Enter new Marks:");
                                marks = sc.nextInt();

                                if (marks >= 0 && marks <= 100) {
                                    break;
                                }

                                System.out.println("Marks must be between 0 and 100.");

                            } catch (InputMismatchException e) {
                                System.out.println("Invalid marks! Enter numbers only.");
                                sc.next();
                            }
                        }

                        students.get(i).setMarks(marks);
                        System.out.println("Student Marks updated successfully.");
                        break;
                    case 4:
                        String newName;

                        do {
                            System.out.println("Enter new name:");
                            newName  = sc.next();

                            if (!newName .matches("[a-zA-Z]+")) {
                                System.out.println("Invalid name! Use letters only.");
                            }
                        } while (!newName .matches("[a-zA-Z]+"));

                        students.get(i).setName(newName );

                        int updatedAge;
                        do {
                            System.out.println("Enter new Age:");
                            updatedAge = sc.nextInt();

                            if (updatedAge <= 0) {
                                System.out.println("Age must be greater than 0.");
                            }
                        } while (updatedAge <= 0);

                        students.get(i).setAge(updatedAge);

                        int updatedMarks;
                        do {
                            System.out.println("Enter new Marks:");
                            updatedMarks = sc.nextInt();

                            if (updatedMarks < 0 || updatedMarks > 100) {
                                System.out.println("Marks must be between 0 and 100.");
                            }
                        } while (updatedMarks < 0 || updatedMarks > 100);

                        students.get(i).setMarks(updatedMarks);

                        System.out.println("All student details updated successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }

    }

    @Override
    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
