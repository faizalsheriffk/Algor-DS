package graph;

import java.util.*;

public class Graph {

    public Graph(){

    }

    private HashMap<Node, List<Node>> adjListImpl = new HashMap<Node, List<Node>>();
    private class Node {

        private String label;

        Node(){

        }

        Node(String label){
            this.label = label;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(label, node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }

    public void addNode(String label){

        Node n = new Node(label);
        if(!adjListImpl.containsKey(n)){
            adjListImpl.put(n, new LinkedList<Node>());
        }

    }

    public Node removeNode(String label){

        Node toRemove = new Node(label);
        if(adjListImpl.containsKey(toRemove)){
            adjListImpl.remove(toRemove);

            for(Node key: adjListImpl.keySet()){

                List<Node> edges = adjListImpl.get(key);
                //there is a for loop inside
                edges.remove(toRemove);
            }
            return  toRemove;
        }
        return null;

    }

    public boolean addEdge(String source, String destination){

        Node src = new Node(source);

        if(!adjListImpl.containsKey(src)){
            return false;
        }
        Node dest = new Node(destination);
        List edgeList = adjListImpl.get(src);
        edgeList.add(dest);
        return true;
    }

    public void visitDepthFirst(String startLabel){

        Node startNode = new Node(startLabel);
        if(!adjListImpl.containsKey(startNode)){
            return;
        }

        System.out.println(startLabel);

        visitDepthFirst(startNode, new HashSet<Node>());

        System.out.println("visiting depth first iterative");

        visitDepthFirstIterative(startNode);

    }

    public Stack<Node> topologicalSort() {
        Stack<Node> stack = new Stack<Node>();
        Set<Node> visitedNodes = new HashSet<Node>();

        for (Map.Entry<Node, List<Node>> entry : adjListImpl.entrySet()) {

            if (!visitedNodes.contains(entry.getKey())) {
                topologicalSort(entry.getKey(), visitedNodes, stack);
            }
        }
        return stack;
    }

    public boolean isCyclic(){

        Set<Node> visitedNodes = new HashSet<Node>();
        Set<Node> parentNodes = new HashSet<Node>();

        for(Map.Entry<Node, List<Node>> entry:adjListImpl.entrySet()){

            parentNodes.add(entry.getKey());
            visitedNodes.clear();
            if(isCyclic(entry.getKey(), visitedNodes, parentNodes)){
                return true;
            }

        }

        return false;
    }

    public boolean isCyclic(Node n, Set<Node> visitedNodes, Set<Node> parentNodes){

        if(visitedNodes.contains(n)){

            if(parentNodes.contains(n))
                return  true;
            else
                return false;
        }else{
            visitedNodes.add(n);

            for(Node cNode: adjListImpl.get(n)){
                return isCyclic(cNode, visitedNodes, parentNodes);
            }
        }
        return false;
    }

    private void topologicalSort(Node node, Set<Node> visitedNodes, Stack stack){
      visitedNodes.add(node);
      for(Node n:adjListImpl.get(node)){

          if(!visitedNodes.contains(n)){
              topologicalSort(n, visitedNodes, stack);
          }
      }
      stack.push(node);

    }

    private void visitDepthFirst(Node node, Set<Node> visitedNodeSet){

        visitedNodeSet.add(node);

        for(Node adjNode: adjListImpl.get(node)){

            if(!visitedNodeSet.contains(adjNode)){
                System.out.println(adjNode.label);
                visitDepthFirst(adjNode, visitedNodeSet);
            }
        }
    }

    //A -> B-> C
    //B-> C
    //C -> A

    private void visitDepthFirstIterative(Node startNode){

        System.out.println(startNode.label);

        Set<Node> visitedNodeSet = new HashSet<Node>();
        Stack<Node> stack = new Stack<Node>();

        stack.addAll(adjListImpl.get(startNode));
        visitedNodeSet.add(startNode);

        Node currentNode = null;

        while(!stack.isEmpty()){

            currentNode = stack.pop();

            if(!visitedNodeSet.contains(currentNode)){
                System.out.println(currentNode.label);
                stack.addAll(adjListImpl.get(currentNode));
                visitedNodeSet.add(currentNode);
            }

        }


    }

    public void print(){


        for(Map.Entry<Node, List<Node>> entry: adjListImpl.entrySet()){
            System.out.println("Node["+entry.getKey().label+"] is connected to");

            for(Node n: entry.getValue()){
                System.out.println("["+n.label+"]");
            }
        }
    }

}
