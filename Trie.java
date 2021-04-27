import java.util.List;

public class Trie {
    private Trie _root;
    private List<Trie> _children;
    private Trie _parent;
    private int _counter;
    private int _level;
    private int _key;
    private int _data;
    private boolean isRoot = false;

    // constructor to initialise the Trie
    public Trie(int num, int data) {
        counter = 0;
        if(num != 0 && data != -1) {
            _key = num;
        }
    }

    public void add(int data) {
        // check if the root is null or there is nothing in our trie
        if(_root == null) {
            // set the root value to the empty pair
            _root = new Trie(_counter, null);
            _root.isRoot = true;
            

        }

    }

    public Trie find(int key) {
        return null;
    }

    // Private method that returnds the val of the counter
    private Integer getCounter() {
        return _counter;
    }

    // Private method used withint the class to retrive its data
    private int getData() {
        return _data;
    }

    private void setData(int data) {
        _data = data;
    }

    private void setPhraseNum(int num) {
        _key = num;
    }

}