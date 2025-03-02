package com.example.hi1029.F11;

import java.util.*;

class PrimAdjacencyList {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int[] prim(List<List<Edge>> graph) {
        int n = graph.size();
        int[] parent = new int[n];
        int[] minWeight = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(minWeight, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        minWeight[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (inMST[u]) continue;
            inMST[u] = true;


            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.to;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < minWeight[v]) {
                    parent[v] = u;
                    minWeight[v] = weight;
                    pq.add(new Edge(v, weight));
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 5, 1);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 1, 3, 2);
        addEdge(graph, 1, 4, 4);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 2, 7, 1);
        addEdge(graph, 3, 4, 4);
        addEdge(graph, 3, 5, 1);
        addEdge(graph, 5, 6, 5);
        addEdge(graph, 4, 6, 7);
        addEdge(graph, 6, 7, 6);

        int[] parent = prim(graph);

        System.out.println("Minimal Spanning Tree:");
        for (int i = 1; i < n; i++) {
            System.out.println("Nod " + i + " anslöts via nod " + parent[i]);
        }
    }

    static void addEdge(List<List<Edge>> graph, int u, int v, int weight) {
        graph.get(u).add(new Edge(v, weight));
        graph.get(v).add(new Edge(u, weight));
    }
}

