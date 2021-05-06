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

    static int largestPhraseNumber = 0; 
    static triell pointer;

    public triell() {
        rSibling = null;
        fChild = null;
        parent = null;

    }

    public void add(int mismatchChar) {

        try {
            if (fChild == null && largestPhraseNumber == 0) { // This is a given, the 1st thing we're adding 
                triell first = new triell(); 
                fChild = first;
                first.parent = this;
                first.mismatch = mismatchChar;
                pNumber = largestPhraseNumber++; 
            }
            else  { 
                if (fChild.mismatch == mismatchChar) {
                    
                }
                triell next = fChild.rSibling; // Scanning 'horiziontally' for any matches
                while (next.rSibling != null) { // While we still have right siblings to compare with

                    if (mismatch == next.mismatch) { // if we found a match, then go a level deeper 
                        next.fChild = next;
                        while (next.fChild != null) { 
                            // While we can keep going downward
                            add(mismatchChar);
                        }
                        // We've reached the end
                        triell child = new triell();
                        child.parent = next;
                        child.mismatch = mismatchChar;
                        child.pNumber = largestPhraseNumber++;
                        break;
                    }

                    next = next.rSibling; // Move onto the next right sibling
                }
                // Needs a new node at that level
                if (next.rSibling == null) {
                    triell sibling = new triell(); 
                    sibling.pNumber = largestPhraseNumber++;
                    sibling.mismatch = mismatchChar;
                    sibling.parent = next.parent;
                    next.rSibling = sibling;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
