import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    Trie _root;
    Trie _parent;
    ArrayList<Trie> _children;
    int _phraseCounter;
    int _mmChar;

    // Constructor which takes the mismatched character
    public Trie() {
        this._root = null;
        this._parent = null;
        this._phraseCounter = 0;
    }

    // constructor to initialise the Trie
    // public Trie(int phraseCounter, int mmChar) {
    // if (phraseCounter >= 0 && mmChar != -1) { // check if the phraseNum and
    // mismatched char is valid
    // _phraseCounter = phraseCounter;
    // _mmChar = mmChar;
    // }
    // }

    // add method that adds the mmChar to the trie
    // takes the current available phraseNumber followed by the mmChar
    public void add(int mmChar) {
        Trie currNode;
        Trie parent;
        Trie root;
        Trie leftChild;
        Trie rightChild;
        int listSize = _children.size() - 1;

        try {
            // check if the root is null or there is nothing in our trie
            if (_root == null) {

                // set the head of the trie to the empty phrase
                _root = new Trie();
                _root._mmChar = -1;
                parent = _root;
                currNode = new Trie(); // set current node to the node we are adding
                currNode.setmmChar(mmChar); // sets the mismatched char
                currNode.setParent(parent); // set the first tuple's parent to the root
                _children.add(currNode); // add the node to the list of children
                //upHeap(_children.size() - 1); // call upheap to put in min heap order
                _root = currNode; // set the root to the child we just added

            } else { // otherwise there are already items in the trie
                if (mmChar > 0) {
                    int index = 0;
                    root = _children.get(index);
                    leftChild = _children.get(getLeftChild(index));
                    rightChild = _children.get(getReftChild(index));
                    if(mmChar <= root.getmmChar() && leftChild != null) {

                    }
                    parent = _root;
                    currNode = new Trie();
                    currNode.setParent(parent);
                    currNode.setmmChar(mmChar);
                    _children.add(currNode);
                    upHeap(listSize);
                    _root = currNode;

                }
            }
        } catch (Exception x) {
            System.err.print(x);
            x.printStackTrace();
        }
    }

    public Trie find(int mmChar) {
        int index = 0;
        Trie root;
        Trie leftChild;
        Trie rightChild;

        while(index <= _children.size()) {
            root = _children.get(index);
            leftChild = _children.get(getLeftChild(index));
            rightChild = _children.get(getReftChild(index));

            if(root.getmmChar() == mmChar) {
                return root;

            }
        }
    }

    // resets the root value to the top of the tree
    public void resetRoot() {
        while (_root.getmmChar() >= 0) {
            _root = _root.getParent();
        }
    }

    // returns leftchild index of the given index
    private int getLeftChild(int index) {
        return ((index + 1) * 2) - 1;

    }

    // returns Reftchild index of the given index
    private int getReftChild(int index) {
        return ((index + 1) * 2);

    }
    // puts children in order from lowest to highest
    private void upHeap(int nodeIndex) {
        Trie child;
        Trie parent;
        int parentIndex = (int) Math.floor(nodeIndex / 2);
        try {
            if (parentIndex > 0) {
                child = _children.get(nodeIndex);
                parent = _children.get(parentIndex);
                if (child.getmmChar() < parent.getmmChar()) {
                    swap(nodeIndex, parentIndex); // swap the position of the 2 index
                    upHeap(parentIndex);
                }
            }
        } catch (Exception x) {
            System.err.println(x);
            x.printStackTrace();
        }
    }

    // swap the position of 2 difference index
    private void swap(int a, int b) {
        Collections.swap(_children, a, b);
    }

    // get the mismatched character
    private int getmmChar() {
        return this._mmChar;
    }

    // get the parent
    private Trie getParent() {
        return this._parent;
    }

    // set parent
    private void setParent(Trie parent) {
        this._parent = parent;
    }

    // set mmchar
    private void setmmChar(int mmChar) {
        this._mmChar = mmChar;
    }
}