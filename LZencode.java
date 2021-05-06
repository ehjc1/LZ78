/*
    Names:  Eugene Chew     ,   Zachary Cui
    IDs:    1351553         ,   1364880

*/

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class LZencode {

    public static void main(String[] args) throws Exception {
        encode();
    }

    // method that encodes the file
    public static void encode() throws Exception {
        // create the empty phrase
        Trie root = new Trie();
        Trie currNode;
        Trie previousNode = null;
        int phraseCounter = 1; // set phrase Counter
        try {
            root.add(0, 0); // initialise the root
            // stores byte that is read in as an integer
            int mismatch = System.in.read();
            currNode = root; // start at the root
            // while where are still data to be read
            while (mismatch >= 0) {
                previousNode = currNode; // set previous node to the current node
                currNode = currNode.find(mismatch); // finds the next node from current into current
                if (currNode == null) { // check if we need to add a new node
                    previousNode.add(phraseCounter, mismatch); // add the node
                    System.out.println(String.valueOf(previousNode.getpNumber()) + " " + String.valueOf(mismatch)); // output
                                                                                                                    // phrase
                                                                                                                    // number
                                                                                                                    // and
                                                                                                                    // the
                    // mismatch character
                    phraseCounter++; // increment phrase counter
                    currNode = root; // reset currNode back to the root
                } else if (currNode != null) {
                    // we have found a match in our children
                    previousNode = currNode;
                }
                mismatch = System.in.read(); // read the next byte
            }
            System.out.flush();
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}