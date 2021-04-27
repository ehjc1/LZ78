import java.util.List;

public class Trie {
    private Trie root;
    private List<Trie> children;
    private Trie parent;
    private int counter;
    private int level;
    private byte data;

    public Trie() {
        counter = 0;

    }

    public void add(Byte data) {
        // check if we have children

    }

    public Trie find(int key) {
        return null;
    }

    // Private method that returnds the val of the counter
    private Integer getCounter() {
        return counter;
    }

    // Private method used withint the class to retrive its data
    private Byte getByte() {
        return data;
    }

}