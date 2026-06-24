package SuperKeyword;

public class SuperKeyword {
    public static void main(String[] args) {

        //---------Second Use Case-------------//
        // EngineeringStudent es1 = new EngineeringStudent();
        // es1.name = "Prakhar";
        // es1.age = 25;
        // es1.rollNumber = 1110;
        // es1.college = "IIIT Kota";

        // es1.print();

        //--------Third Use Case----------------//
        EngineeringStudent es2 = new EngineeringStudent("Prakhar", 25, 1110, "IIIT Kota");
        es2.print();

    }
}

/* First use case -> To access parent class variables 
class Student{
    String name;
    int age;
    int rollNumber;
    int x;

    void print
}

class EngineeringStudent extends Student{
    String college;
    int x;
    void print(){
        System.out.println(super.name + ", " + super.age + ", " + super.rollNumber + ", " + x (this is x from child class) + ", " + super.x (this is x from parent class));
    }
}
*/
/* Second Use Case -> To access member function of parent class
class Student{
    String name;
    int age;
    int rollNumber;

    void print(){
        System.out.println(name + ", " + age + ", " + rollNumber);
    }
}

class EngineeringStudent extends Student{
    String college;
    void print(){
        super.print();
        System.out.println(college);
    }
}
*/

class Student{
    String name;
    int age;
    int rollNumber;

    Student(){} //making a default constructor, because if we make a parameterized constructor, then default constructor will not be created by default.

    Student(String name, int age, int rollNumber){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }
}

class EngineeringStudent extends Student{
    String college;

    EngineeringStudent(String name, int age, int rollNumber, String college){ //passing the parameters to parent class constructor
        super(name, age, rollNumber);//super keyword is used to call the parent class constructor.
        this.college = college;
    }

    void print(){
        System.out.println(name + ", " + age + ", " + rollNumber + ", " + college);
    }
}