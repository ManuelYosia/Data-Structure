/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

/**
 *
 * @author nazwa
 */

import java.util.*;

class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class DijkstraTree {
    private static void dijkstra(ArrayList<ArrayList<Node>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(2, 5));
        graph.get(1).add(new Node(3, 1));
        graph.get(1).add(new Node(4, 9));
        graph.get(2).add(new Node(1, 3));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(4, 4));
        graph.get(3).add(new Node(5, 8));
        graph.get(4).add(new Node(5, 7));

        int source = 0; // Set the source vertex

        dijkstra(graph, source);
    }
}