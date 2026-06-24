package Inheritance;

/*
    Multi Level Inheritance
    A-->B-->C (A class is parent of B class, B class is parent of C class and so on...)
*/

public class MultiLevelInheritance {
    public static void main(String[] args) {
        
    }
}

class Student{ //Parent Class
    String name;
    int age;
    public void markAttendance(){
        System.out.println("Attendance Marked");
    }
}

class EngineeringStudent extends Student{ //Child class of Student, Parent class of CSE Engineering Student
    void attendLab(){
        System.out.println("Lab Attended");
    }
}

class CSEEngineeringStudent extends EngineeringStudent{
    void attendCSELab(){
        System.out.println("Attended Coding Lab");
    }
}

/*
Student -> can call only markAttendance method
   |
EngineeringStudent -> can call both markAttendance and attendLab methods
   |
CSEEngineeringStudent -> can call every method

*/