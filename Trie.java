import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

public class Trie {
    ArrayList<Trie> _children;
    int _mmChar;
    int _phraseNum;

    // Constructor which takes the mismatched character
    public Trie() {
        Trie temp = null;
        _children = new ArrayList<Trie>();

        for (int i = 0; i < 256; i++) {
            _children.add(temp);
        }
        // _children.add(temp);
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
            } else { // otherwise there are already items in our children BST
                currNode = _children.get(index); // start at the root of the BST
                if (currNode == null) { // check if our children array is empty
                    // add first node in BST of children
                    currNode = new Trie();
                    currNode.setmmChar(mmChar);
                    currNode.setPhraseNum(phraseNum);
                    _children.add(index, currNode);
                } else { // otherwise we already have children
                    while (currNode != null) { // traverse our children BST
                        // check if mmChar is less than the root
                        if (mmChar < currNode.getmmChar()) {
                            index = currNode.getLeftChild(index); // sets the new index to the leftChild index
                            if (index < _children.size() - 1) {
                                if (_children.get(index) == null) {
                                    currNode = new Trie();
                                    currNode.setmmChar(mmChar);
                                    currNode.setPhraseNum(phraseNum);
                                    _children.add(index, currNode);
                                    break;
                                } else if (_children.get(index) != null) {
                                    currNode = _children.get(index);
                                }
                            }
                        } else if (mmChar > currNode.getmmChar()) {
                            index = currNode.getRightChild(index);
                            if (index < _children.size() - 1) {
                                if (_children.get(index) == null) {
                                    currNode = new Trie();
                                    currNode.setmmChar(mmChar);
                                    currNode.setPhraseNum(phraseNum);
                                    _children.add(index, currNode);
                                    break;
                                } else if (_children.get(index) != null) {
                                    currNode = _children.get(index);
                                }
                            }
                        }
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
        Trie currNode;
        int i = index;
        // if (i > _children.size() - 1) {
        // Trie temp = null;
        // _children.add(temp);
        // return null;
        // }
        currNode = _children.get(i);
        try {
            if (currNode == null) { // checks if the first child is empty
                return null;
            } else {
                while (currNode != null) { // traverse our BST
                    if (mmChar < currNode.getmmChar()) {
                        i = currNode.getLeftChild(i);
                        if (_children.get(i) == null) {
                            currNode = null;
                            break;
                        } else if (_children.get(i) != null) {
                            currNode = _children.get(i);
                        }
                        // if (i > _children.size() - 1) { // check if we are over the limit
                        // currNode = null;
                        // break;
                        // }
                        
                    } else if (mmChar > currNode.getmmChar()) {
                        i = currNode.getRightChild(i);
                        // if (i > _children.size() - 1) {
                        // currNode = null;
                        // break;
                        // }
                        currNode = _children.get(i);
                    } else if (mmChar == currNode.getmmChar()) {
                        break;
                    }
                }
                return currNode;
            }

        } catch (Exception x) {
            System.err.println(x);
            x.printStackTrace();
        }
        return currNode;

    }

    // returns leftchild index of the given index
    private int getLeftChild(int index) {
        return ((index + 1) * 2) - 1;
    }

    // returns Reftchild index of the given index
    private int getRightChild(int index) {
        return ((index + 1) * 2);
    }

    // get the mismatched character
    private int getmmChar() {
        return this._mmChar;
    }

    public int getPhraseNum() {
        return this._phraseNum;
    }

    // set mmchar
    private void setmmChar(int mmChar) {
        this._mmChar = mmChar;
    }

    // set phraseNum
    private void setPhraseNum(int phraseNum) {
        this._phraseNum = phraseNum;
    }
}
