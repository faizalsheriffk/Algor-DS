package graph.medium;

import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {
    private Map<Node, Node> visited = new HashMap<Node, Node>();

    //This problem had so much hiccups
     public Node cloneGraph(Node node) {

         if(node == null)
             return node;


         //using a map to store the values is critical
         Map<Node, Node> visitedNodes = new HashMap<Node, Node>();
         Queue<Node> pQ = new LinkedList<Node>();


         Node curCopy = null;

         pQ.add(node);
         curCopy = cloneNode(node);
         visitedNodes.put(node, curCopy);


         while(!pQ.isEmpty()){

             Node cur = pQ.remove();

             for(Node neighbor: cur.neighbors){

                 if(!visitedNodes.containsKey(neighbor)){
                  curCopy = cloneNode(neighbor);

                  var x = neighbor.val;
                  var y = curCopy.val;

                  visitedNodes.put(neighbor, curCopy);

                  pQ.add(neighbor);
                 }

                 var z = cur.val;
                 var zx = curCopy.val;

                 visitedNodes.get(cur).neighbors.add( visitedNodes.get(neighbor));

             }
         }

         return visitedNodes.get(node);
     }




    public Node cloneGraphDFS(Node node) {
        if(node == null){
            return node;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node copy = cloneNode(node);
        visited.put(node, copy);

        for(Node neighbor:node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return visited.get(node);
    }

    private Node cloneNode(Node n){
        ArrayList<Node> neighbors = new ArrayList<Node>();
        Node newCopy = new Node(n.val, neighbors);
        return newCopy;
    }


}