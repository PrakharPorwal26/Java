package ObjectClass;
// import java.util.Objects;
public class ObjectClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.name = "Prakhar";
        s1.age = 25;

        Student s2 = new Student();
        s2.name = "Prakhar";
        s2.age = 25;

        Student s3 = null;
        System.out.println(s1.equals(s3)); //returns false instead of NullPointerException

        Integer i = 10;
        System.out.println(s1.equals(i)); //returns false instead of ClassCastException

        //Since we have overridden, now s1 and s2 are different references with same values, so now comparison will return true

        System.out.println(s1.equals(s2)); 

        System.out.println(s1.hashCode() == s2.hashCode()); //this will return true because we have overridden the hashCode() method. If we would not have, it would have returned false. 

        //System.out.println(s1.equals(s2)) --> If we don't override, it will return false because equals() method of Object class compares the references of the objects and not the values of the objects. So, it will return false because s1 and s2 are two different objects with different references. 

        //--The equals() method of Integer class overrides the equals() method of Object class to compare the values of the objects and not the references of the objects. So, it will return true because i1 and i2 are two different objects with same values as we have studied before.//

        Student s5 = (Student) s1.clone(); //if Student does not implements Cloneable, this will throw CloneNotSupportedException. 

        System.out.println(s5.name + " " + s5.age);
    }
}

class Student implements Cloneable {
    String name;
    int age;

    @Override
    public boolean equals(Object obj){

        if(this == obj){ //checking if the references of the objects are same or not
            return true;
        }

        if(obj == null){ //checking if the object is null or not --> Prevents NullPointerException
            return false;
        }

        if(this.getClass() != obj.getClass()){ //checking if the classes of the objects are same or not --> Prevents ClassCastException
            return false;
        }

        Student s = (Student) obj; //downcasting the object of Object class to Student class to access the properties of Student class

        return this.name.equals(s.name) && this.age == s.age; //comparing the values of the objects and not the references of the objects
    }

    @Override
    public int hashCode(){
        int result = 17; //initializing the result with a prime number

        result = result*31 + age; //multiplying the result with a prime number and adding the age to it

        result = result*31 + (name == null ? 0 : name.hashCode()); //multiplying the result with a prime number and adding the hashcode of name to it, hashCode() method of String class overrides the hashCode() method of Object class. We check if name is null or not to prevent NullPointerException

        return result; //returning the hashcode of the object

        //We can also use Objects.hash() here, internally it implements the same logic as above 

        //return Objects.hash(name, age); 

    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone(); //calling the clone() method of Object class to create a copy of the object
    }
}
