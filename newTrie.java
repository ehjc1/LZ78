public class newTrie {

    private int pNumber;
    private int mmChar;
    private newTrie next;

    public void add(int phraseNumber, int mismatchCharacter) {

        newTrie n = new newTrie();
        n.pNumber = phraseNumber;
        n.mmChar = mismatchCharacter;

    }

    public void find(int mismatchCharacter) {

    }

}
