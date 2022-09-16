package graph.advanced;

import java.util.Arrays;

/**
 * This is BellMan Ford Algorithm.
 * <p>
 * Like Dijkstra's algorithm, Bellman-Ford proceeds by relaxation, in which approximations to the correct distance are
 * replaced by better ones until they eventually reach the solution.
 * In both algorithms, the approximate distance to each vertex is always an overestimate of the true distance and is
 * replaced by the minimum of its old value and the length of a newly found path.
 * However, Dijkstra's algorithm uses a priority queue to greedily select the closest vertex that has not yet been
 * processed, and performs this relaxation process on all of its outgoing edges; by contrast, the Bellman-Ford algorithm
 * simply relaxes all the edges and does this
 * ∣V∣−1∣V∣−1 times, where ∣V∣  ∣V∣ is the number of vertices in the graph. In each of these repetitions, the number of
 * vertices with correctly calculated distances grows, from which it follows that eventually, all vertices will have
 * their correct distances. This method allows the Bellman-Ford algorithm to be applied to a wider class of inputs than
 * Dijkstra.
 * An important part to understanding the Bellman Ford's working is that at each step, the relaxations lead to the
 * discovery of new shortest paths to nodes. After the first iteration over all the vertices, the algorithm finds out
 * all the shortest paths from the source to nodes which can be reached with one hop (one edge). That makes sense because
 * the only edges
 * we'll be able to relax are the ones that are directly connected to the source as all the other nodes have shortest
 * distances set to inf initially.
 */
public class CheapestFlightWithinKSteps {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        //this is key
        prices[src] = 0;

        //<= is very important
        for (int i = 0; i <= k; i++) {
            int[] tempPrices = Arrays.copyOf(prices, prices.length);

            for (int[] edge : flights) {
                var s = edge[0];
                var d = edge[1];
                var price = edge[2];

                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }

                //temp price is used to store lowest value at each level
                if (prices[s] + price < tempPrices[d]) {
                    tempPrices[d] = prices[s] + price;
                }


            }
            prices = tempPrices;
        }


        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
