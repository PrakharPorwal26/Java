package InputOutput;

//BufferedReader, InputStreamReader and InputStream, all of these classes are part of java.io package. Here in this file we're going to see workflow of how to read input from console using these three classes.  
import java.io.*;
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {

        //Step 1: Create an object of InputStreamReader class and pass InputStream object(System.in) to its constructor. InputStreamReader is a bridge from byte streams to character streams. It reads bytes and decodes them into characters.
        InputStreamReader isr = new InputStreamReader(System.in);

        //Step 2: Create an object of BufferedReader class and pass InputStreamReader object to its constructor. BufferedReader reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
        BufferedReader br = new BufferedReader(isr);

         
        //Step 3: Use readLine() method of BufferedReader class to read a line of text.
        String input = br.readLine();
        System.out.println("You entered: " + input);
    }   
}
/*-----FLOW OF READING INPUT FROM CONSOLE USING BUFFEREDREADER, INPUTSTREAMREADER AND INPUTSTREAM-----

1. Input = Prakhar
2. OS Buffer stores the input in bytes(ASCII values) : [80, 114, 97, 107, 104, 97, 114, 10] (10 is the ASCII value of newline character)
3. InputStreamReader converts Stream of Bytes to Stream of Characters : ['P', 'r', 'a', 'k', 'h', 'a', 'r', '\n']
4. BufferedReader reads the Stream of Characters and stores it in its buffer : ['P', 'r', 'a', 'k', 'h', 'a', 'r', '\n']
5. BufferedReader's readLine() method reads the characters from its buffer until it encounters a newline character and returns the string "Prakhar" (without the newline character).
6. Output = You entered: Prakhar
*/
