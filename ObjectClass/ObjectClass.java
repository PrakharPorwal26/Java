package ObjectClass;

public class ObjectClass {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Prakhar";
        s.age = 25;

        System.out.println(s.toString()); //prints the string representation of the object (ClassName@HashCode) --> For our code, it will print packageName.ClassName@HashCode.  

        System.out.println(s); //this will also print the string representation of the object (ClassName@HashCode) as toString() method is called implicitly by System.out.println().
    }
}

class Student {
    String name;
    int age;

    /*
    @Override
    public String toString(){
        return ("Student name: " + name + ", Student age: " + age);
    }

    if we print this in main class --> System.out.println(s), it will print Student name: Prakhar, Student age: 25.  
    */
}
