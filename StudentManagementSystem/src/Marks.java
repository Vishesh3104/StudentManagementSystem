public class Marks {

    public String calculateGrade(int marks) {

        if (marks > 100 || marks < 0) {
            return "Invalid Marks";
        }
        else if (marks >= 80) {
            return "A";
        }
        else if (marks >= 70) {
            return "B";
        }
        else if (marks >= 50) {
            return "C";
        }
        else if (marks >= 35) {
            return "D";
        }
        else {
            return "F";
        }
    }
}