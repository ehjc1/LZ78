
/*
    Names:  Eugene Chew     ,   Zachary Cui
    IDs:    1351553         ,   1364880

*/
import java.util.*;

public class Trie {

    // Linked list structure:
    // 2 linked lists
    // Such that each node has:
    // Left child & a right sibling

    int pNumber = 0;
    int mismatch = 0;
    Trie rSibling;
    Trie fChild;
    Trie parent;

    // the constructor
    public Trie() {
        rSibling = null;
        fChild = null;
        parent = null;
    }

    // add method that adds a new node
    public void add(int phraseNumber, int mismatchChar) {

        Trie current = fChild;
        Trie previous = null;
        try {
            if (mismatchChar == 0) { // check if we are adding the empty phrase
                this.mismatch = mismatchChar;
                this.pNumber = phraseNumber;
                this.parent = null;
            } else {
                if (fChild == null) { // check if the first child is null
                    current = new Trie();
                    current.mismatch = mismatchChar;
                    current.pNumber = phraseNumber;
                    current.parent = this;
                    fChild = current;
                } else {
                    while (current != null) { // while we are not at the end of the list
                        // we have a child
                        previous = current; // set previous to current
                        current = current.rSibling; // set current to the next sibling
                    }
                    if (current == null) { // check if we are at the end of the list
                        current = new Trie();
                        current.mismatch = mismatchChar;
                        current.pNumber = phraseNumber;
                        current.parent = this;
                        previous.rSibling = current;
                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace(); // error message
        }
    }

    // check if we already have the character
    public Trie find(int mismatch) {
        Trie curr = fChild; // start looking from the first child

        while (curr != null) { // while there is still something
            if (mismatch != curr.getMisMatch()) { // check if the character does not match
                if (curr.rSibling != null) { // check if our right sibling is not null
                    curr = curr.rSibling; // set curr to our right sibling
                } else {
                    curr = null;
                }
            } else {
                break;
            }
        }

        return curr; // return curr
    }

    // method that returns the phraseNumber
    public int getpNumber() {
        return this.pNumber;
    }

    // method that returns the mismatch char
    private int getMisMatch() {
        return this.mismatch;
    }
}
