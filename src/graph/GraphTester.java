package graph;

import java.util.Objects;

public class GraphTester {

    public static void main (String[] args){
        Graph graph = new Graph();

        //        graph.addNode("E");


        //        E
        //        |
        //        |
        // A----->B------>D
        //  ------C
        //A -> B, C
        //B -> D, E
        //C -> E
        //D-> E
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B" , "C");
        graph.addEdge("C" , "D");
        graph.addEdge("D" , "B");

        graph.print();
        graph.removeNode("B");
        graph.print();
        graph.visitDepthFirst("A");
        graph.topologicalSort();

        System.out.println("Is the graph cyclic"+graph.isCyclic());
        System.out.println(Objects.hash(34,45,16)+"::"+Objects.hash(45,34,16));


        //=== weighted graphs

        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addNode("D");
        weightedGraph.addNode("E");

        weightedGraph.addEdge("A", "B", 3);
        weightedGraph.addEdge("A", "D", 2);
        weightedGraph.addEdge("A", "C", 4);
        weightedGraph.addEdge("B", "D", 6);
        weightedGraph.addEdge("B", "E", 1);
        weightedGraph.addEdge("C", "D", 1);
        weightedGraph.addEdge("D", "E", 5);


        weightedGraph.print();
        var distance = weightedGraph.computeShortestDistance("A", "E");

        System.out.println(distance);

        System.out.println(weightedGraph.computeShortestPath("A","E"));

        System.out.println(weightedGraph.hasCycle());

        System.out.println(weightedGraph.constructSTP());

    }
}
