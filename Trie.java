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

    static int largestPhraseNumber = 0;
    static Trie pointer;

    public Trie() { // triell (name) = new triell();
        rSibling = null;
        fChild = null;
        parent = null;
    }

    public void add(int phraseNumber, int mismatchChar) {

        Trie current = fChild;
        Trie previous = null;
        try {
            if (mismatchChar == 0) {
                this.mismatch = mismatchChar;
                this.pNumber = phraseNumber;
                this.parent = null;
            } else {
                if (fChild == null) {
                    current = new Trie();
                    current.mismatch = mismatchChar;
                    current.pNumber = phraseNumber;
                    current.parent = this;
                    fChild = current;
                } else {
                    // Type any pseudo code here
                    while (current != null) {
                        // we have a child
                        previous = current; // set previous to current
                        current = current.rSibling; // set current to the next sibling
                    }
                    if (current == null) {
                        current = new Trie();
                        current.mismatch = mismatchChar;
                        current.pNumber = phraseNumber;
                        current.parent = this;
                        previous.rSibling = current;
                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Trie find(int mismatch) {
        Trie curr = fChild; // start looking from the first child

        while (curr != null) { // while there is still something
            if (mismatch != curr.getMisMatch()) {
                if (curr.rSibling != null) {
                    curr = curr.rSibling;
                } else {
                    curr = null;
                }
            } else {
                break;
            }
        }

        return curr;
    }

    public int getpNumber() {
        return this.pNumber;
    }

    private int getMisMatch() {
        return this.mismatch;
    }
}
