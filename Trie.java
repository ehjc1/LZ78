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
        int index = 0;
        try {
            // check if we are adding the empty phrase
            if (mmChar == null || mmChar < 0) {
                setmmChar(mmChar); // set the empty phrase
                // if (mmChar > 0) {
                //     // set the head of the trie to the empty phrase
                //     _root = new Trie();
                //     _root._mmChar = -1;
                //     parent = _root;
                //     currNode = new Trie(); // set current node to the node we are adding
                //     currNode.setmmChar(mmChar); // sets the mismatched char
                //     currNode.setParent(parent); // set the first tuple's parent to the root
                //     _children.add(currNode); // add the node to the list of children
                //     // upHeap(_children.size() - 1); // call upheap to put in min heap order
                // }
            } 
            else { // otherwise there are already items in the trie
                Trie root;
                Trie leftChild;
                Trie rightChild;

                root = _children.get(0);
                leftChild = _children.get(getLeftChild(0));
                rightChild = _children.get(getRightChild(0)); 
                if(root == null) { // check if we have any children
                    currNode = new Trie();
                    currNode.setmmChar(mmChar);
                    _children.add(currNode);
                } else if (mmChar < root.getmmChar() && leftChild != null) {
                    
                }
                if (mmChar > 0) { // check if the character is a valid character
                    currNode = find(mmChar, index); // return the child that matches the mmChar
                    //parent = currNode;
                    if (currNode != null) { // if we have found the child
                        currNode.add(mmChar); // call the child's add function
                    } else {
                        //parent = this._root;
                        currNode = new Trie();
                        currNode.setmmChar(mmChar);
                        //currNode.setParent(parent);
                        _children.add(currNode);
                    }

                }
            }
        } catch (Exception x) {
            System.err.print(x);
            x.printStackTrace();
        }
    }

    // finds a child that contains the mismatched char starting from the index
    public Trie find(int mmChar, int index) {
        Trie root;
        Trie leftChild;
        Trie rightChild;

        root = _children.get(index);
        leftChild = _children.get(getLeftChild(index));
        rightChild = _children.get(getRightChild(index));

        if (root.getmmChar() == mmChar) { // check if the root value is the same as the mismatched char

            return root; // return the that child if so

        } else if (mmChar < root.getmmChar() && leftChild != null) { // check if mmChar is less than the root

            return leftChild.find(mmChar, getLeftChild(index)); // if so pass the value to our leftChild

        } else if (mmChar > root.getmmChar() && rightChild != null) { // check if mmChar is greater than the root

            return rightChild.find(mmChar, getRightChild(index)); // if so pass mmChar to our rightChild

        } else { // we couldn't find the mmChar in our list of children
            return null; // return nothing as the mmChar is not in our arraylist of children
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
    private int getRightChild(int index) {
        return ((index + 1) * 2);
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
