package Inheritance;

//Simple Inheritance 

public class SimpleInheritance {
    public static void main(String[] args){
        EngineeringStudent es = new EngineeringStudent();
        es.markAttendance(); //can call this too
        es.attendLab();

        Student s1 = new Student();
        s1.markAttendance();
        // s1.attendLab(); can't do this, because parent class doesn't have attendLab() function.
    }
}

class Student{
    String name;
    int age;

    protected void markAttendance(){ //if markAttendace() is private, no one can call this method, not even Student class's object. public access modifier is also fine.
        System.out.println("Attendance marked!");
    }
}

class EngineeringStudent extends Student{
    //do not need to write markAttendance again.

    void attendLab(){
        System.out.println("Lab Attended");
    }
}
