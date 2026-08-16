package Comparable_Interface;
import java.util.*;
public class Comparable_Interface {
    public static void main(String[] args) {
        Student s1 = new Student("Prakhar", 95);
        Student s2 = new Student("Tushar",90);
        Student s3 = new Student("Aman", 80);
        Student s4 = new Student("Gaurav", 80);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //If I don't implement Student from Comparable Interface and I do not override compareTo method, this code won't execute: Collections.sort(list) because Java won't know on which basis we have to sort it.

        Collections.sort(list); //this internally calls compareTo()
        for(Student li:list){
            System.out.println(li.name + " " + li.marks);// O/P: Aman 80
                                                            //   Tushar 90
                                                            //   Prakhar 95
        }
    }   
}

class Student implements Comparable<Student>{
    String name;
    int marks;
    public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other){
        // return this.marks - other.marks; //ascending
        //for descending - other.marks - this.marks

        //If marks are same, and we then we want the order to be lexicographically sorted:
        if(this.marks!=other.marks){
            return this.marks - other.marks;
        }
        return this.name.compareTo(other.name); //String overrides compareTo method 
    }
}

/*
if:
this.marks - other.marks < 0 -> this.marks is less than other.marks, therefore this.marks should come before other.marks in the sorting sequence.

if:
this.marks - other.marks = 0 -> this.marks and other.marks are equal

if
this.marks - other.marks > 0 -> other.marks should come before this.marks in the sequence
*/
