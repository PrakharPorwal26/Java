package Comparator_Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsingLambdaExpression {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Prakhar",25,101));
        list.add(new Student("Tushar",24,102));
        list.add(new Student("Aman",23,103));

        //Instead of writing different classes and then creating its objects and passing them into the Collections.sort() OR passing anonymous class into Collections.sort(). We can use Lambda Expression as so:

        Collections.sort(list,(s1,s2)-> s1.age - s2.age);
        
        for(Student s: list){
            System.out.println(s.name + " " + s.age + " " + s.rollNo);
        }
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