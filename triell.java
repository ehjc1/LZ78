import java.util.*;

public class triell {

    // Linked list structure:
    // 2 linked lists
    // Such that each node has:
    // Left child & a right sibling

    int pNumber = 0;
    int mismatch = 0;
    triell rSibling;
    triell fChild;
    triell parent;

    static int largestPhraseNumber; 

    public triell() {
        rSibling = null;
        fChild = null;
        parent = null;

    }

    public void add(int mismatchChar) {
        
        try {
            if (fChild == null) { // This is a given, the 1st thing we're adding 
                triell first = new triell(); 
                fChild = first;
                first.parent = this;
                first.mismatch = mismatchChar;
            }
            else  { 
                triell next = fChild.rSibling; // Scanning 'horiziontally' for any matches
                while (next.rSibling != null) { 
                    if (mismatch == next.mismatch) {
                        triell child = new triell();
                        child.parent = this;
                        child.mismatch = mismatchChar;
                    } else {
                        next = fChild.rSibling;
                    }
                }
                triell add = new triell();
                add.mismatch = mismatchChar;
                next.rSibling = add;
    

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
