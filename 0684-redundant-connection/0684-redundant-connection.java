class UnionFind {
    public int[] parent;
    public int[] rank;

    // Constructor
    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Function to find which subset a particular element belongs to
    // Returns FALSE if both vertices have the same parent, otherwise, updates the parent and rank lists by making a connection based on the passed edge
    // Returns TRUE if no cycle exits in the graph
    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    // Function to join two subsets into a single subset
    public boolean union(int v1, int v2) {
        // Find the root parents of v1 and v2
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) {
            return false;
        } 
        // Updates the parent and rank lists otherwise 
        else if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } 
        else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind connections = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!connections.union(v1, v2)) {
                return edge;
            }
        }
        return new int[]{};
    }
}

