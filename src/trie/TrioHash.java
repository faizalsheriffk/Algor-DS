package trie;


import java.sql.ClientInfoStatus;
import java.util.*;

public class TrioHash {


    public static final char KEY = ' ';

    //'' ->'p'|'p'->'e'|'e'
    private class Node{
        private char value;
        private HashMap<Character, Node> children = new HashMap<Character, Node>();
        private boolean isLastChar;

        Node(Character value){
            this.value = value;
        }

        public Node getChild(Character ch){
            return children.get(ch);
        }

        public void addChild(Character ch, Node node){
            children.put(ch, node);
        }

        public boolean hasChild(Character c){
            return !children.isEmpty() && children.get(c)!= null;
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public boolean deleteChild(char c){
            if(hasChildren()){
                children.remove(c);
                return true;
            }
        return false;
        }
    }

    private Node root = new Node(KEY);
    private Node current;
    private StringBuilder prefixBuilder = new StringBuilder();
    private List<String> autoCompStringList = new ArrayList<String>();


//     trie.insert("petty");
//     trie.insert("pettier");
//     trie.insert("pettap");
//     trie.insert("pettlap");

    public void insert(String word) {

        current = root;

        for (char ch : word.toCharArray()) {

            var valueNode = current.getChild(ch);

            if(valueNode == null){
                valueNode = new Node(ch);
                current.addChild(ch, valueNode);
            }
            current = current.getChild(ch);
        }
        current.isLastChar = true;
    }


    public boolean delete(String deleteWord){

        if(deleteWord == null || deleteWord.toCharArray().length == 0){
            return false;
        }
        var deleteCharSet = deleteWord.toCharArray();
      //  var node = root.children.get(deleteCharSet[0]);
        return delete(deleteCharSet, 0, root.children);
    }


    public String[] autoComplete(String searchStr){

        autoCompStringList.clear();
        String[] emptyResultSet = new String[0];
        if(searchStr == null || searchStr.length() == 0){
            return emptyResultSet;
        }
        var index = 0;

        Node prefixNode = collectPrefixNode(searchStr.toCharArray(), index, root.children);

        if(prefixNode == null || prefixNode.children.isEmpty()){
            return emptyResultSet;
        }
        List<String> autoCompletedString = new ArrayList<String>();
        if(prefixNode.isLastChar){
            autoCompletedString.add(prefixBuilder.toString());
        }
        collectAutoCompleteStrings(prefixBuilder.toString(), prefixNode);
        if(autoCompletedString!=null && !autoCompletedString.isEmpty()){
            String[] result = new String[autoCompletedString.size()];
            result = autoCompletedString.toArray(result);
            return result;
        }
        return emptyResultSet;
    }


    public boolean contains(String word) {

        if(word == null)
            return false;

        current = root;

        for (char ch : word.toCharArray()) {

            if(current.hasChild(ch) && current.getChild(ch).value == ch){

                current = current.getChild(ch);

            }else
                return false;
        }
        if (current.isLastChar)
            return true;
        else
            return false;
    }




    /**
     * There was an issue with how we sent the children node
     * @param array
     * @param index
     * @param children
     * @return
     */

    private boolean delete(char[] array, int index, HashMap<Character, Node> children) {


        var c = array[index];

        if (children!=null && children.get(c)!=null) {

            if (index == array.length - 1) {
                if (children.get(c).isLastChar) {
                    children.get(c).isLastChar = false;

                    //always run the code in your head
                    //make the datstructure less confusing

                    if (children.get(c).children.isEmpty()) {
                        //delete the node
                        children.remove(c);
                    }

                    return true;
                }
            } else {
                //continue

                return delete(array, ++index, children.get(c).children);
            }

        }
        return false;
    }





    private Node collectPrefixNode(char[] query, int index, HashMap<Character, Node> children){

        Node cur = null;
        //clear prefixbuilder

        this.prefixBuilder= null;
        this.prefixBuilder = new StringBuilder();

        for(char curChar: query){

            if(children!=null && !children.isEmpty()&&children.containsKey(curChar)){
                prefixBuilder.append(curChar);
                cur = children.get(curChar);
                children = cur.children;

            }
        }

        return cur;

    }

    //can
    //can telope
    //can non
    //can yon
    private  List<String> collectAutoCompleteStrings(String prefixBldr, Node currentNode){


        if(currentNode == null){
            return autoCompStringList;
        }

        var children = currentNode.children;



        if(!children.isEmpty()){

            for(Map.Entry<Character, Node> entry: children.entrySet()){

               /**Lesson: Don't retain state in the calling code if you don't want to retain after the recursive call comes bac*/
              // prefixBldr = prefixBldr+entry.getKey();
               if(entry.getValue().isLastChar){
                   autoCompStringList.add(prefixBldr+entry.getKey());
               }
               autoCompStringList.addAll(collectAutoCompleteStrings(prefixBldr+entry.getKey(), entry.getValue()));
            }

        }

        return autoCompStringList;

    }






    public static void main(String[] args){

            TrioHash trie = new TrioHash();
            trie.insert("petty");
            trie.insert("pettier");
            trie.insert("pettap");
            trie.insert("pettlap");

            System.out.println("hello the message is over");

            System.out.println("contains"+trie.contains("petto"));

            System.out.println("contains"+trie.delete("petty"));

            System.out.println("done");

            trie.insert("can");
            trie.insert("cannon");
            trie.insert("cantelope");
            trie.insert("canyon");

            var results = trie.autoComplete("cant");

            for (var result:results){
                System.out.println(result);
            }

    }

}

