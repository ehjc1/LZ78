public class newTrie {

    node head;

    public void add(int phraseNumber, int mismatchCharacter) {

        node current = new node(phraseNumber, mismatchCharacter);
        current.next = head;
        head = current;
        return;
    }

    public node find(int mismatchCharacter) {

        node current = head;
        while (current != null) {
            if (current.mmChar == mismatchCharacter) {
                return current;
            }
            else current = current.next;
        }
        return null;

    }

    public class node { 

        private int pNumber;
        private int mmChar;
        public node next;

        public node(int phraseNumber, int mismatchCharacter) {
            pNumber = phraseNumber;
            mmChar = mismatchCharacter;
        }

    }

}
