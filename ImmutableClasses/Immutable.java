package ImmutableClasses;

public class Immutable {
    public static void main(String[] args) {
        //First we will see not purely immutable class, it uses object of a mutable class which can be changed using object of immutable class. So it is not purely immutable class.
        Address address = new Address("Indore", "Madhya Pradesh");
        Student student = new Student("Prakhar", 25, address);
        System.out.println("Student name: " + student.getName());
        System.out.println("Student age: " + student.getAge());
        System.out.println("Student city: " + student.getAddress().city);
        System.out.println("Student state: " + student.getAddress().state);

        //now, changing the address of student using object of immutable class

        student.getAddress().city = "Nagpur";
        student.getAddress().state = "Maharashtra";

        System.out.println("Updated Student city: " + student.getAddress().city);
        System.out.println("Updated Student state: " + student.getAddress().state);
    }
}

final class Student {
    private final String name;
    private final int age;
    private final Address address; //object of mutable class

    
    Student(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    //getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}

class Address{
    String city;
    String state;

    Address(String city, String state){
        this.city = city;
        this.state = state;
    }
}

