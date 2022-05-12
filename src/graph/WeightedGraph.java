package graph;



import java.util.*;

public class WeightedGraph {

    private class Node{

        private String label;

        Node(String label){
            this.label = label;
        }

        private Set<Edge> edges = new TreeSet<>(new Comparator<Edge>(){

            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

    }

    private class Edge{

        private Node from;
        private Node to;
        private int weight;

        Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return weight == edge.weight && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, weight);
        }
    }


    private class ShortestPathNodeVector{

        private Node node;
        private Integer distance = Integer.MAX_VALUE;
        private Node previousNode;


        ShortestPathNodeVector(Node n, Node p, int distance){
            this.node = n;
            this. previousNode = p;
            this.distance = distance;
        }

    }



    private Map<String, Node> nodes = new HashMap<String, Node>();


    public void addNode(String label){

        Node n = new Node(label);

        if(n == null){
            return;
        }

        nodes.put(label, n);
    }

    public void addEdge(String f, String t, int weight){

            Node from = nodes.get(f);
            Node to = nodes.get(t);
            if(from == null || to == null){
                new IllegalStateException("One of teh nodes does not exist with from node ="+from+" and to = "+to);
            }

            Edge edge = new Edge(from, to, weight);

            if(!from.edges.contains(edge)){
                from.edges.add(edge);

            }

            edge = new Edge(to, from, weight);

            if(!to.edges.contains(edge)){
                to.edges.add(edge);
            }

    }



    public int computeShortestDistance(String fromL, String toL){

        var shortestPathMap =  computeShortestPathMap(fromL, toL);

        return shortestPathMap.get(nodes.get(toL)).distance;

    }

    public String computeShortestPath(String fromL, String toL){

        var shortestPathMap =  computeShortestPathMap(fromL, toL);
        var current = shortestPathMap.get(nodes.get(toL));
        Stack<String> stack = new Stack<String>();

        while(current!=null){

            stack.push(current.node.label);

            if(current.previousNode!=null) {
                current = shortestPathMap.get(nodes.get(current.previousNode.label));
            }
            else {
                current = null;
            }

            stack.push("->");
        }
        stack.pop();
        StringBuilder path = new StringBuilder();
        while(!stack.isEmpty()){
            path.append(stack.pop());
        }

        return path.toString();

    }

    public boolean hasCycle(){

        Set<Node> visitedNodes = new HashSet<Node>();

        for(Node node: nodes.values()){

            if(visitedNodes.contains(node)){
                return true;
            }
            if(hasCycle(node, node.edges, visitedNodes)){
                return true;
            }
        }

        return false;
    }


    public Node constructSTP() {

        Node stp = null;
        Set<Node> visitedNodes = new HashSet<Node>();
        for(Node node: nodes.values()) {
            if(visitedNodes.contains(node)) {
                continue;
            }
            if(stp == null) {
                stp = new Node(node.label);
            }
            Queue cEdges = getEdgesOf(node);
            visitedNodes.add(node);
            constructSTP(stp, visitedNodes, cEdges);
        }
        return stp;
    }

    private Queue<Edge> getEdgesOf(Node node) {
        Queue<Edge> cEdges = getcEdgesPQueue();

        for(Edge edge: node.edges) {
            cEdges.add(edge);
        }
        return cEdges;
    }

    private PriorityQueue<Edge> getcEdgesPQueue() {
        return new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
    }

    private void constructSTP(Node stp, Set<Node> visitedNodes, Queue<Edge> currentEdges) {

        while(!currentEdges.isEmpty()) {
            Edge currentEdge = currentEdges.remove();

            Node currentNode = currentEdge.to;
            if(visitedNodes.contains(currentNode))
                continue;

            visitedNodes.add(currentNode);

            Edge newCurrentEdge = shallowCopyEdge(currentEdge);
            stp.edges.add(newCurrentEdge);

            Queue cEdges = getEdgesOf(currentNode);
            constructSTP(newCurrentEdge.to, visitedNodes, cEdges);
        }
    }

    private Edge shallowCopyEdge(Edge currentEdge) {
        Node from = new Node(currentEdge.from.label);
        Node to = new Node(currentEdge.to.label);

        Edge newCurrentEdge = new Edge(from, to, currentEdge.weight);
        return newCurrentEdge;
    }

//    public Node constructSTP(String startLabel){
//
//        Set<Node> visitedNodes = new HashSet<Node>();
//
//        //random start node
//        Node startNode = nodes.get(startLabel);
//
//        if(startNode == null){
//            return startNode;
//        }
//
//        Node stp = new Node(startNode.label);
//
//        constructSTP(stp, startNode, visitedNodes);
//
//        return stp;
//    }
//
//    private void constructSTP(Node stp, Node curNode, Set<Node> visitedNodes){
//
//        if(visitedNodes.contains(curNode)){
//            return;
//        }
//
//        visitedNodes.add(curNode);
//
//        for(Edge edge:curNode.edges){
//            if(visitedNodes.contains(edge.to)){
//                continue;
//            }
//
//            Node from = new Node(edge.from.label);
//            Node to = new Node(edge.to.label);
//
//            Edge newEdge = new Edge(from, to, edge.weight);
//
//            stp.edges.add(newEdge);
//            constructSTP(stp.edges.iterator().next().to, edge.to, visitedNodes);
//            break;
//        }
//    }

    private boolean hasCycle(Node node, Set<Edge> edges, Set<Node> visitedNode){

        visitedNode.add(node);
        for(Edge edge: edges){
            if(visitedNode.contains(edge.to) || hasCycle(edge.to, edge.to.edges, visitedNode)){
                return true;
            }

        }
        return false;
    }

    private HashMap<Node, ShortestPathNodeVector> computeShortestPathMap(String fromL, String toL) {
        HashMap<Node, ShortestPathNodeVector> shortestPathMap = initShortestPathMap();

        Node from = nodes.get(fromL);
        Node to = nodes.get(toL);

        if(from == null || to == null)
            throw new IllegalStateException();

        Queue<ShortestPathNodeVector> queue = new PriorityQueue<ShortestPathNodeVector>(new Comparator<ShortestPathNodeVector>() {
            @Override
            public int compare(ShortestPathNodeVector o1, ShortestPathNodeVector o2) {
                return o1.distance-o2.distance;
            }
        });

        ShortestPathNodeVector startNode = new ShortestPathNodeVector(from, null, 0);

        queue.add(startNode);

        shortestPathMap.put(from, startNode);

        Set<Node> visitedNodeSet = new HashSet<Node>();
        // visitedNodeSet.add(from);

        while(!queue.isEmpty()){

            var current = queue.remove();
            visitedNodeSet.add(current.node);

            var currentDistance = 0;
            //distance calculation
            if(current.previousNode!= null)
                currentDistance = current.distance+ shortestPathMap.get(current.previousNode).distance;
            else {
                currentDistance = current.distance;
            }

            if(currentDistance < shortestPathMap.get(current.node).distance){
                var nVector = shortestPathMap.get(current.node);
                nVector.distance = currentDistance;
                nVector.previousNode = current.previousNode;
                shortestPathMap.put(current.node, nVector);
            }

            for(Edge edge : nodes.get(current.node.label).edges){

                if(!visitedNodeSet.contains(edge.to))
                queue.add(new ShortestPathNodeVector(edge.to, edge.from, edge.weight));
            }

        }

        return shortestPathMap;
    }


    public void print(){

        for(Map.Entry<String, Node> nodeEntry: nodes.entrySet()){
            for(Edge edge : nodeEntry.getValue().edges)
                System.out.println(edge.from.label+"--"+edge.weight+"-->"+edge.to.label);
        }
    }

    private HashMap<Node, ShortestPathNodeVector> initShortestPathMap() {

        HashMap<Node, ShortestPathNodeVector> shortestPathMap = new HashMap<Node, ShortestPathNodeVector>();


        for(Node n: nodes.values()){

            shortestPathMap.putIfAbsent(n, new ShortestPathNodeVector(n, null, Integer.MAX_VALUE));

        }
        return  shortestPathMap;
    }


    //A -> A -> Previous Node -> MAX
    //B ->






}
