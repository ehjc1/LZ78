import java.io.InputStreamReader;
import java.io.Reader;

public class LZencode {

    public static void main(String[] args) throws Exception {
        encode();
    }

    public static void encode() throws Exception {
        Reader reader = new InputStreamReader(System.in);
        Trie trie = new Trie();
        int phraseCounter = 0;
        try {
            // stores byte that is read in as an integer
            int b = reader.read();

            // while where are still data to be read
            while (b > 0) {
                // writer.write((int)i);
                
                trie.add(i);
                System.out.println(b);
                b = reader.read(); // read the next byte
            }
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}