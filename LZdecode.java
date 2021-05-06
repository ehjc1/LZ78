/*
    Names:  Eugene Chew     ,   Zachary Cui
    IDs:    1351553         ,   1364880

*/

import java.util.*;
import java.io.*;

public class LZdecode {

    // Two array lists - the dictionary uses a list of arrays to store the tuple.
    ArrayList<String> stack = new ArrayList<String>();
    ArrayList<String[]> dictionary = new ArrayList<String[]>();

    public static void main(String[] args) {

        LZdecode decoder = new LZdecode();
        decoder.decode();
    }

    private void decode() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // A reader for the data being
                                                                                      // piped in
        String currentLine;

        try {
            currentLine = reader.readLine();
            while (currentLine != null) {
                dictionary.add(currentLine.split(" ")); // Add the next phrase
                get();
                printStack();
                currentLine = reader.readLine(); // Read the next
            }
            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void get() {
        String[] tuple = dictionary.get(dictionary.size() - 1); // Get the last tuple in the dictionary
        try {
            stack.add(tuple[1]); // Add the mismatch to the stack
            while (Integer.parseInt(tuple[0].trim()) != 0) { // Keep tracing back up until we reach the end (aka phrase
                                                             // number = 0)
                tuple = dictionary.get(Integer.parseInt(tuple[0]) - 1);
                stack.add(tuple[1]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printStack() {

        PrintStream writer = new PrintStream(System.out);

        for (int i = stack.size() - 1; i >= 0; i--) {
            writer.write(Integer.parseInt(stack.get(i))); // Print out our values in reverse order
        }
        stack.clear();
    }
}
