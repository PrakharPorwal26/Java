package Inheritance;

/*
Hierarchical Inheritance
        A
       / \
      B   C

    Tree Like Structure, both class B and class C gets inherited from parent class A
*/

public class HierarchicalInheritance {
    public static void main(String[] args) {
        
    }
}
class Student{ //Parent Class - A
    String name;
    int age;
    public void markAttendance(){
        System.out.println("Attendance Marked");
    }
}

class EngineeringStudent extends Student{ //Child class - B
    void attendLab(){
        System.out.println("Lab Attended");
    }
}
class MedicalStudent extends Student{ //Child class - C
    void attendBioLab(){
        System.out.println("Attended Bio Lab");
    }
}