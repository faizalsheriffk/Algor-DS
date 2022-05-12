package trie;


public class Trie {


    private Node root = new Node(' ');

    private Node current = root;

    private class Node {

        private char value;

        private boolean isWordEnd;

        private Node[] children = new Node[26];

        Node(char ch) {

            this.value = ch;

        }


    }

    public void insert(String word) {

        for (char ch : word.toCharArray()) {

            var index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new Node(ch);

            current = current.children[index];


        }
        current.isWordEnd = true;
        current = root;

    }



    public static void main(String[] args){

            Trie trie = new Trie();
            trie.insert("petty");
            trie.insert("pettier");
            trie.insert("pettap");
            trie.insert("pettlap");
            System.out.println("hello the message is over");
    }

}

