import java.io.InputStreamReader;
import java.io.Reader;

public class LZencode {

    public static void main(String[] args) throws Exception {
        encode();
    }

    public static void encode() throws Exception {
        Reader reader = new InputStreamReader(System.in);
        // create the empty phrase
        Trie root = new Trie();
        Trie currNode;
        Trie previousNode = null;
        int phraseCounter = 1;
        try {
            root.add(0, 0); // initialise the root
            // stores byte that is read in as an integer
            int b = reader.read();
            // while where are still data to be read
            while (b >= 0) {
                currNode = root.find(b, 0);
                if (currNode == null) {
                    if (currNode == null) {
                        previousNode.add(b, phraseCounter);
                        System.out.println(previousNode.getPhraseNum() + "," + (char)b);
                        phraseCounter++;
                    }
                }
                b = reader.read(); // read the next byte
            }
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}