package ObjectClass;

public class ObjectClass {
    public static void main(String[] args) {
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

        //System.out.println(s1.equals(s2)) --> If we don't override, it will return false because equals() method of Object class compares the references of the objects and not the values of the objects. So, it will return false because s1 and s2 are two different objects with different references. 

        //--The equals() method of Integer class overrides the equals() method of Object class to compare the values of the objects and not the references of the objects. So, it will return true because i1 and i2 are two different objects with same values as we have studied before.//
    }
}

class Student {
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
}
