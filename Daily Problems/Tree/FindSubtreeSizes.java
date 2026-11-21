class Solution {

    List<Integer>[] adj;
    List<Integer>[] tree;

    int[] newParent;
    int[] ans;
    int[] last;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        adj = new ArrayList[n];
        tree = new ArrayList[n];

        newParent = new int[n];
        ans = new int[n];
        last = new int[26];

        Arrays.fill(last, -1);

        // Step 1: Build the original tree
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        // Initially, every node has its original parent
        newParent = parent.clone();

        // Step 2: Find the nearest ancestor
        // having the same character
        dfs1(0, s);

        // Step 3: Build the modified tree
        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        // Step 4: Calculate subtree sizes
        dfs2(0);

        return ans;
    }

    void dfs1(int u, String s) {

        int c = s.charAt(u) - 'a';

        // Store the previous ancestor with this character
        int prev = last[c];

        // If an ancestor with the same character exists,
        // update the parent of the current node
        if (prev != -1) {
            newParent[u] = prev;
        }

        // Current node becomes the nearest ancestor
        // for its character
        last[c] = u;

        // Traverse children in the original tree
        for (int v : adj[u]) {
            dfs1(v, s);
        }

        // Restore the previous value during backtracking
        last[c] = prev;
    }

    int dfs2(int u) {

        // Every node contributes 1 to its subtree size
        ans[u] = 1;

        // Add the subtree sizes of all children
        for (int v : tree[u]) {
            ans[u] += dfs2(v);
        }

        return ans[u];
    }
}
