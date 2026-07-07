package Strings;

public class StringBuilderMethods {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //append();
        sb.append("Prakhar");
        sb.append(" Porwal");

        //insert()
        sb.insert(2,'o'); //offset = index at which insertion should happen, 'o'-> the character to insert, not replace but insert. o/p: Proakhar Porwal

        //delete()
        sb.delete(0,2); //deletes the string from 0 to 2(exclusive)

        //deleteCharAt()
        sb.deleteCharAt(1);

        //replace()
        sb.replace(1,3,"xy"); //replaces the characters from index 1 to 3(exclusive) by xy.

        //reverse();
        sb.reverse(); //reverses the string

        //charAt()
        sb.charAt(2);

        //setCharAt()
        sb.setCharAt(1,'R'); //sets 'R' at index 1

        //length()
        sb.length(); //prints length of string

        //capacity() --> prints size of byte[] array's capacity.
        System.out.println(sb.capacity());

        //ensureCapacity()
        sb.ensureCapacity(100); //set minimum capacity of byte[] arr to 100;

        //trimToSize()
        sb.trimToSize(); //removes unused space from the byte[] arr.
        
    }
}
