import java.util.Scanner;
import java.util.InputMismatchException;

public static void main(String[] args) {

    StudentManager manager = new StudentManager();
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
        try {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int id;

                    while (true) {
                        System.out.println("Enter Student ID:");

                        try {
                            id = sc.nextInt();

                            if (id <= 0) {
                                System.out.println("ID must be greater than 0.");
                                continue;
                            }

                            if (manager.isIdExists(id)) {
                                System.out.println("Student ID already exists. Try another ID.");
                                continue;
                            }

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid ID! Enter numbers only.");
                            sc.next();
                        }
                    }

                    sc.nextLine();

                    String name;

                    do {
                        System.out.println("Enter Name:");
                        name = sc.nextLine().trim();

                        if (!name.matches("[a-zA-Z ]+")) {
                            System.out.println("Invalid name! Use letters only.");
                        }

                    } while (!name.matches("[a-zA-Z ]+") || name.isEmpty());

                    int age;

                    while (true) {
                        System.out.println("Enter Age:");

                        try {
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

                    int marks;

                    while (true) {
                        System.out.println("Enter Marks:");

                        try {
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

                    Student student = new Student(id, name, age, marks);
                    manager.addStudent(student);

                    break;
                case 2:
                    manager.displayAllStudents();
                    break;
                case 3:
                    int searchId;

                    while (true) {
                        try {
                            System.out.println("Enter Student ID:");
                            searchId = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Enter numbers only.");
                            sc.next();
                        }
                    }

                    manager.searchStudent(searchId);
                    break;
                case 4:
                    int updateId;

                    while (true) {
                        try {
                            System.out.println("Enter Student ID:");
                            updateId = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Enter numbers only.");
                            sc.next();
                        }
                    }

                    manager.updateStudent(updateId);
                    break;
                case 5:
                    System.out.println("Enter Student ID:");
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter numbers only.");
            sc.next();
            choice = 0;
        }

    } while (choice != 6) ;

}

