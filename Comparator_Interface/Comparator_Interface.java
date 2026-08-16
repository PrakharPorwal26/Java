package Comparator_Interface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Comparator_Interface {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Prakhar",25,101));
        list.add(new Student("Tushar",24,102));
        list.add(new Student("Aman",23,103));

        //creating objects of the Comparator strategies
        Comparator<Student> c1 = new sortByName();
        // Comparator<Student> c2 = new sortByAge();
        // Comparator<Student> c3 = new sortByrollNo();

        //pass the object of the sorting strategy in .sort
        Collections.sort(list,c1);


        for(Student s: list){
            System.out.println(s.name + " " + s.age + " " + s.rollNo);
        }
    }
}

//sorting strategy by name
class sortByName implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name); //calling compareTo of String
    }
}

//sorting strategy by age
class sortByAge implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.age - s2.age;
    }
}

//sorting strategy by rollNo
class sortByrollNo implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.rollNo - s2.rollNo;
    }
}

class Student{
    String name;
    int age;
    int rollNo;

    public Student(String name, int age, int rollNo){
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }
}
