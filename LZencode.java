import java.io.InputStreamReader;
import java.io.Reader;

public class LZencode {

    public static void main(String[] args) throws Exception {
        encode();
    }

    public static void encode() throws Exception {
        Reader reader = new InputStreamReader(System.in);
        Trie trie = new Trie();
        int phraseCounter;
        try {
            // stores byte that is read in as an integer
            int i = reader.read();

            // while where are still data to be read
            while (i != -1) {
                // writer.write((int)i);
                if (i == 10) { // check if we have finish
                }
                System.out.println(i);
                i = (int) reader.read(); // read the next byte
            }
        } catch (Exception x) {
            // prints error
            System.err.println(x);
            x.printStackTrace();
        }

    }
}