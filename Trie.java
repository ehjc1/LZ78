import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    ArrayList<Trie> _children;
    int _mmChar;
    int _phraseNum;

    // Constructor which takes the mismatched character
    public Trie() {

    }

    // add method that adds the mmChar to the trie
    // takes the current available phraseNumber followed by the mmChar
    public void add(int mmChar, int phraseNum) {
        Trie currNode;
        int index = 0;
        try {
            // check if we are adding the empty phrase
            if (mmChar == 0) {
                setmmChar(mmChar); // set the empty phrase
                setPhraseNum(phraseNum);
            } else { // otherwise there are already items in the trie
                Trie root;
                Trie leftChild;
                Trie rightChild;

                root = _children.get(index);
                leftChild = _children.get(getLeftChild(index));
                rightChild = _children.get(getRightChild(index));
                if (root.getmmChar() == mmChar) { // check if the root value is the same as the mismatched char

                    root.add(mmChar, phraseNum);

                } else if (mmChar < root.getmmChar() && leftChild != null) { // check if mmChar is less than the root

                    leftChild.add(mmChar, phraseNum); // if so pass the value to our leftChild

                } else if (mmChar > root.getmmChar() && rightChild != null) { // check if mmChar is greater than the
                                                                              // root
                    rightChild.add(mmChar, phraseNum); // if so pass mmChar to our rightChild

                } else { // we couldn't find the mmChar in our list of children

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

    public int getPhraseNum() {
        return this._phraseNum;
    }

    // set parent
    private void setParent(Trie parent) {
        this._parent = parent;
    }

    // set mmchar
    private void setmmChar(int mmChar) {
        this._mmChar = mmChar;
    }

    private void setPhraseNum(int phraseNum) {
        this._phraseNum = phraseNum;
    }
}
