public class Student extends Person {

    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        super(id, name);
        this.age = age;
        this.marks = marks;
    }

    public int getAge(){
        return this.age;
    }
    public int getMarks(){
        return this.marks;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }

    @Override
    void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("ID : "+ this.getId());
        System.out.println("NAME : "+ this.getName());
        System.out.println("AGE : "+ this.getAge());
        System.out.println("MARKS : "+ this.getMarks());
        Marks marks = new Marks();
        System.out.println("Student Grade :"+marks.calculateGrade(this.getMarks()));

    }
}
