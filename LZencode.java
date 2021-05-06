import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class LZencode {

    public static void main(String[] args) throws Exception {
        encode();
    }

    public static void encode() throws Exception {
        // Reader reader = new InputStreamReader(System.in);
        Reader reader = new FileReader("./MobyDick.txt");
        // create the empty phrase
        triell root = new triell();
        triell currNode;
        triell previousNode = null;
        int phraseCounter = 1;
        try {
            root.add(0, 0); // initialise the root
            // stores byte that is read in as an integer
            int mismatch = reader.read();
            currNode = root; // start at the root
            // while where are still data to be read
            while (mismatch >= 0) {
                previousNode = currNode;
                currNode = currNode.find(mismatch);
                if (currNode == null) { // check if we have the mmChar in the root's children
                    previousNode.add(phraseCounter, mismatch);
                    System.out.println(previousNode.getpNumber() + " " + mismatch);
                    phraseCounter++;
                    currNode = root;
                } else if (currNode != null) {
                    // we have found a match in our children
                    previousNode = currNode;
                }
                mismatch = reader.read(); // read the next byte
            }
            reader.close();
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}