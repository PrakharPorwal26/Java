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

        // This will not change the address of the student as the Address object is immutable, the code will execute without error but the address of the student will remain the same.

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
        //creating a new object of Address class to prevent the original address object from being modified outside the Student class
        this.address = new Address(address.city, address.state);
    }
    
    //getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(this.address.city, this.address.state); //returning a new object of Address class to prevent the original address object from being modified outside the Student class
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

