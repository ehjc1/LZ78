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
        Reader reader = new FileReader("./test.txt");
        // create the empty phrase
        Trie root = new Trie();
        Trie currNode;
        Trie previousNode = null;
        int phraseCounter = 1;
        try {
            root.add(0, 0); // initialise the root
            // stores byte that is read in as an integer
            int b = reader.read();
            currNode = root; // start at the root
            // while where are still data to be read
            while (b >= 0) {
                previousNode = currNode;
                currNode = currNode.find(b, 0);
                if (currNode == null) { // check if we have the mmChar in the root's children
                    previousNode.add(b, phraseCounter);
                    System.out.println(previousNode.getPhraseNum() + "," + (char) b);
                    phraseCounter++;
                    currNode = root;
                } else if (currNode != null) {
                    // we have found a match in our children
                    previousNode = currNode;
                }
                b = reader.read(); // read the next byte
            }
            reader.close();
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}